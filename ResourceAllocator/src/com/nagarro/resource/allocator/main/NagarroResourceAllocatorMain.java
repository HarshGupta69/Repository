/**
 * 
 */
package com.nagarro.resource.allocator.main;

import java.util.List;

import com.nagarro.resource.allocator.parse.XMLFileParser;
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;

/**
 * @author harshitgupta
 *
 */
public class NagarroResourceAllocatorMain {

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
        List<ResourceInformationVO> resourceInfoList = XMLFileParser.getResourceInformation();
        long endTimeResourceInfo = System.currentTimeMillis();
        System.out.println("Total Resource Information Size: " + resourceInfoList.size());
        System.out.println("Total Time Taking to Read Resource Information in Milli Sec: "
                + (endTimeResourceInfo - startTimeResourceInfo));
        long startTimeProjectReq = System.currentTimeMillis();
        List<ProjectRequirementVO> projectReqList = XMLFileParser.getProjectRequirement();
        long endTimeProjectReq = System.currentTimeMillis();
        System.out.println("Total Project Requirement Size: " + projectReqList.size());
        System.out.println("Total Time Taking to Read Project Requirement in Milli Sec: "
                + (endTimeProjectReq - startTimeProjectReq));
    }

}
