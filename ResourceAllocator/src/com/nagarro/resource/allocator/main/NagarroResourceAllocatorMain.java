/**
 * 
 */
package com.nagarro.resource.allocator.main;

import java.util.List;
import java.util.Map;

import com.nagarro.resource.allocator.parse.XMLFileParser;
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;

/**
 * @author harshitgupta
 *
 */
public class NagarroResourceAllocatorMain {

    public static Map<String, List<ResourceInformationVO>> resourceInfoMap = null;

    public static Map<String, List<ProjectRequirementVO>> projectReqMap = null;

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
        projectReqMap = XMLFileParser.getProjectRequirement();
        long endTimeProjectReq = System.currentTimeMillis();
        System.out.println("Total Project Requirement Size: " + projectReqMap.size());
        System.out.println("Total Time Taking to Read Project Requirement in Milli Sec: "
                + (endTimeProjectReq - startTimeProjectReq));
//        System.out.println(resourceInfoMap);
//        System.out.println(projectReqMap);
    }

}
