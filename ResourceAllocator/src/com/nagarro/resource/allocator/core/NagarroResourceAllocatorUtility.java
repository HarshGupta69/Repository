/**
 * 
 */
package com.nagarro.resource.allocator.core;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagarro.resource.allocator.main.NagarroResourceAllocatorMain;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;

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

    public static float stringToFloat(String floatString) {
        float floatN = 0;
        if (null != floatString && !AppConstants.BLANK.equals(floatString)) {
            floatN = Float.parseFloat(floatString);
        }
        return floatN;
    }
    
    public static List<ResourceInformationVO> getResourceInformationVOBySkillSet(List<String> skillSet){
        List<ResourceInformationVO> resourceInformationVOs = new ArrayList<ResourceInformationVO>();
        for(String skill : skillSet){
            for(ResourceInformationVO resourceInformationVO : NagarroResourceAllocatorMain.resourceInfoMap.get(skill)){
                if(resourceInformationVO.getSkills().containsAll(skillSet) && !resourceInformationVOs.contains(resourceInformationVO)){
                    resourceInformationVOs.add(resourceInformationVO);
                }
            }
        }
        return resourceInformationVOs;
    }
}
