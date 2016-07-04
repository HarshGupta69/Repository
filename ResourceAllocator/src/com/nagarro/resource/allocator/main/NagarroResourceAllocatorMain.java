/**
 * 
 */
package com.nagarro.resource.allocator.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.resource.allocator.core.GenerateExcelFile;
import com.nagarro.resource.allocator.core.NagarroResourceAllocatorUtility;
import com.nagarro.resource.allocator.parse.XMLFileParser;
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.QueuedResourceVO;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;
import com.nagarro.resource.allocator.vo.SkillSetVO;

/**
 * @author harshitgupta
 *
 */
public class NagarroResourceAllocatorMain {

    public static Map<SkillSetVO, List<ResourceInformationVO>> resourceInfoMap = null;

    public static List<ResourceInformationVO> resourceInformationVOs = new ArrayList<ResourceInformationVO>();

    public static Map<SkillSetVO, ArrayList<ProjectRequirementVO>> projectRequirementMap = null;

    public static List<QueuedResourceVO> queuedResourceVOs = new ArrayList<QueuedResourceVO>();

    public static Set<ProjectRequirementVO> resourceNotAvailableForProjectRequirementVOs =
            new HashSet<ProjectRequirementVO>();

    public static Set<SkillSetVO> skillSetVOs = new HashSet<SkillSetVO>();

    public static List<SkillSetVO> skillList = null;

    /**
	 * 
	 */
    public NagarroResourceAllocatorMain() {
        super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        long startTimeResourceInfo = System.currentTimeMillis();
        resourceInfoMap = XMLFileParser.getResourceInformation();
        long endTimeResourceInfo = System.currentTimeMillis();
        System.out.println("Total Resource Information Size: " + resourceInfoMap.size());
        System.out.println("Total Time Taking to Read Resource Information in Milli Sec: "
                + (endTimeResourceInfo - startTimeResourceInfo));
        long startTimeProjectReq = System.currentTimeMillis();
        projectRequirementMap = XMLFileParser.getProjectRequirement();
        NagarroResourceAllocatorUtility.solve();
        System.out.println("For " + resourceNotAvailableForProjectRequirementVOs.size()
                + " openings we do not have sufficent resources. Project Requirement's are : "
                + resourceNotAvailableForProjectRequirementVOs);
        System.out.println(resourceInformationVOs.size() + " still not allocated to any opening.");
        // NagarroResourceAllocatorUtility.generateOutPut();
        long endTimeProjectReq = System.currentTimeMillis();
        try {
            GenerateExcelFile.createWorkBook(queuedResourceVOs);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Total Project Requirement Size: " + projectRequirementMap.size());
        System.out.println("Total Time Taking to Read Project Requirement in Milli Sec: "
                + (endTimeProjectReq - startTimeProjectReq));
    }

}
