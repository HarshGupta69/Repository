/**
 * 
 */
package com.nagarro.resource.allocator.core;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.nagarro.resource.allocator.comperator.SkillSetVOComperator;
import com.nagarro.resource.allocator.main.NagarroResourceAllocatorMain;
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.QueuedResourceVO;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;
import com.nagarro.resource.allocator.vo.Skill;
import com.nagarro.resource.allocator.vo.SkillSetVO;

/**
 * @author harshitgupta
 *
 */
public class NagarroResourceAllocatorUtility {

    /**
     * 
     */
    public NagarroResourceAllocatorUtility() {
        super();
    }

    public static Date stringToDate(String dateString) {
        Date date = null;
        if (null != dateString && !"".equals(dateString)) {
            try {
                date = AppConstants.FORMATTOR.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static List<String> stringToList(String string) {
        List<String> list = new ArrayList<String>();
        if (null != string) {
            String[] listArray = string.split(",");
            for (String str : listArray) {
                list.add(str.trim());
            }
        }
        return list;
    }

    public static Set<Skill> stringToSkillSet(String string) {
        Set<Skill> set = new HashSet<Skill>();
        if (null != string) {
            String[] listArray = string.split(",");
            for (String str : listArray) {
                String[] arr = str.trim().toUpperCase().split("-");
                set.add(new Skill(arr[0].trim(), arr[1].trim()));
            }
        }
        return set;
    }

    public static float stringToFloat(String floatString) {
        float floatN = 0;
        if (null != floatString && !AppConstants.BLANK.equals(floatString)) {
            floatN = Float.parseFloat(floatString);
        }
        return floatN;
    }

    public static boolean stringToBoolean(String booleanString) {
        if (null != booleanString && AppConstants.Y.equals(booleanString)) {
            return true;
        }
        return false;
    }

    private static void initSkillList() {
        NagarroResourceAllocatorMain.skillList = new ArrayList<SkillSetVO>(NagarroResourceAllocatorMain.skillSetVOs);
        Collections.sort(NagarroResourceAllocatorMain.skillList, new SkillSetVOComperator());
    }

    public static float getPointsOfResourceForRequirement(ProjectRequirementVO projectRequirementVO,
            ResourceInformationVO resourceInformationVO) {
        float f = resourceInformationVO.getPoints() + 1;
        if (null != resourceInformationVO.getDomainExperience()
                && resourceInformationVO.getDomainExperience()
                        .equalsIgnoreCase(projectRequirementVO.getProjectDomain())) {
            f += 0.2;
            if (null != resourceInformationVO.getPreviousCustomerExperience()
                    && resourceInformationVO.getPreviousCustomerExperience().contains(
                            projectRequirementVO.getCustomerName())) {
                f += 0.3;
            }
        }
        if (resourceInformationVO.getYearsOfExperience() > projectRequirementVO.getYearsOfExperience()) {
            f += ((resourceInformationVO.getYearsOfExperience() - projectRequirementVO.getYearsOfExperience()) * 0.05);
        }
        return f;
    }

    private static boolean isEligibleForProject(ProjectRequirementVO projectRequirementVO, float f) {
        boolean b = true;
        if (projectRequirementVO.getIsKeyProject()
                && ((projectRequirementVO.isKeyPosition() && f > 2.0) || (!projectRequirementVO.isKeyPosition() && f > 1.3))) {
            b = false;
        } else if (!projectRequirementVO.getIsKeyProject()
                && ((projectRequirementVO.isKeyPosition() && f > 1.5) || (!projectRequirementVO.isKeyPosition() && f > 1))) {
            b = false;
        }
        return b;
    }

    private static float getAveragePointForProjectRequirement(ProjectRequirementVO projectRequirementVO) {
        float f = 0;
        if (projectRequirementVO.getIsKeyProject() && projectRequirementVO.isKeyPosition()) {
            f = 2f;
        } else if (projectRequirementVO.getIsKeyProject() && !projectRequirementVO.isKeyPosition()) {
            f = 1.3f;
        } else if (!projectRequirementVO.getIsKeyProject() && projectRequirementVO.isKeyPosition()) {
            f = 1.5f;
        } else if (!projectRequirementVO.getIsKeyProject() && !projectRequirementVO.isKeyPosition()) {
            f = 1f;
        }
        return f;
    }

    private static ResourceInformationVO findMostElegibleResourceForProject(ProjectRequirementVO projectRequirementVO,
            Map<Float, ResourceInformationVO> map) {
        ResourceInformationVO resourceInformationVO = null;
        if (map.size() == 1) {
            resourceInformationVO = (ResourceInformationVO) map.values().toArray()[0];
        } else if (map.size() > 1) {
            resourceInformationVO =
                    map.get(closestFloat(getAveragePointForProjectRequirement(projectRequirementVO), map.keySet()));
        }
        return resourceInformationVO;
    }

    private static boolean isAvailableForProject(ProjectRequirementVO projectRequirementVO,
            ResourceInformationVO resourceInformationVO) {
        boolean b = false;
        if (resourceInformationVO.getAvailableFromDate().before(projectRequirementVO.getRequestStartDate())
                || resourceInformationVO.getAvailableFromDate().equals(projectRequirementVO.getRequestStartDate())) {
            b = true;
        }
        return b;
    }

    private static boolean isAllotedToAnotherProjectForSameTime(ProjectRequirementVO projectRequirementVO,
            ResourceInformationVO resourceInformationVO) {
        boolean b = false;
        QueuedResourceVO queuedResourceVO = new QueuedResourceVO(projectRequirementVO, resourceInformationVO);
        if (NagarroResourceAllocatorMain.queuedResourceVOs.contains(queuedResourceVO)) {
            b = true;
        }
        return b;
    }

    public static void solve() {
        initSkillList();
        for (SkillSetVO skill : NagarroResourceAllocatorMain.skillList) {
            if (NagarroResourceAllocatorMain.projectRequirementMap.get(skill) != null
                    && NagarroResourceAllocatorMain.resourceInfoMap.get(skill) != null) {
                List<ProjectRequirementVO> projectRequirementVOs =
                        NagarroResourceAllocatorMain.projectRequirementMap.get(skill);
                for (int i = 0; i < projectRequirementVOs.size(); i++) {
                    ProjectRequirementVO projectRequirementVO = projectRequirementVOs.get(i);
                    Map<Float, ResourceInformationVO> map = new HashMap<Float, ResourceInformationVO>();
                    for (ResourceInformationVO resourceInformationVO : getAllEligibleResourcesBySkill(skill)) {
                        if (isAvailableForProject(projectRequirementVO, resourceInformationVO)
                                && !isAllotedToAnotherProjectForSameTime(projectRequirementVO, resourceInformationVO)) {
                            float f = getPointsOfResourceForRequirement(projectRequirementVO, resourceInformationVO);
                            if (isEligibleForProject(projectRequirementVO, f)) {
                                map.put(f, resourceInformationVO);
                            }
                        }
                    }
                    ResourceInformationVO resourceInformationVO =
                            findMostElegibleResourceForProject(projectRequirementVO, map);
                    if (null != resourceInformationVO) {
                        QueuedResourceVO queuedResourceVO =
                                new QueuedResourceVO(projectRequirementVO, resourceInformationVO);
                        NagarroResourceAllocatorMain.queuedResourceVOs.add(queuedResourceVO);
                        NagarroResourceAllocatorMain.resourceInformationVOs.remove(resourceInformationVO);
                        projectRequirementVOs.remove(projectRequirementVO);
                        i--;
                    } else {
                        NagarroResourceAllocatorMain.resourceNotAvailableForProjectRequirementVOs
                                .add(projectRequirementVO);
                    }
                }
            }
        }
    }

    private static Set<ResourceInformationVO> getAllEligibleResourcesBySkill(SkillSetVO skillSetVO) {
        Set<ResourceInformationVO> resourceInformationVOs = new HashSet<ResourceInformationVO>();
        for (SkillSetVO setVO : NagarroResourceAllocatorMain.resourceInfoMap.keySet()) {
            if (setVO.has(skillSetVO)) {
                resourceInformationVOs.addAll(NagarroResourceAllocatorMain.resourceInfoMap.get(setVO));
            }
        }
        return resourceInformationVOs;
    }

    public static boolean dateRangeIntersecting(Date fD1, Date fD2, Date sD1, Date sD2) {
        boolean b = false;
        if (fD1.equals(sD1) || fD1.equals(sD2) || fD2.equals(sD1) || fD2.equals(sD2)) {
            b = true;
        } else if ((fD1.before(sD1) && sD1.before(fD2)) || (fD1.before(sD2) && sD2.before(fD1))
                || (sD1.before(fD1) && fD1.before(sD2)) || (sD1.before(fD2) && fD2.before(sD2))
                || (fD1.before(sD1) && fD2.before(sD2)) || (sD1.before(fD1) && sD2.before(fD2))) {
            b = true;
        }
        return b;
    }

    private static float closestFloat(float f, Set<Float> in) {
        float min = Integer.MAX_VALUE;
        float closest = f;
        for (float v : in) {
            final float diff = Math.abs(v - f);
            if (diff < min) {
                min = diff;
                closest = v;
            }
        }

        return closest;
    }

    public static void generateOutPut() {
        for (QueuedResourceVO queuedResourceVO : NagarroResourceAllocatorMain.queuedResourceVOs) {
            System.out.println(queuedResourceVO.getProjectRequirementVO().getProjectName() + "--"
                    + queuedResourceVO.getPoints() + "------"
                    + queuedResourceVO.getResourceInformationVO().getEmployeeId());
        }
    }

    public static int getDaysDifference(Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
