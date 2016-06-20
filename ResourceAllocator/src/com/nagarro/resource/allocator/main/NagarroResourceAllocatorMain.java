/**
 * 
 */
package com.nagarro.resource.allocator.main;

import java.util.List;

import com.nagarro.resource.allocator.parse.XMLFileParser;
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
        long startTime = System.currentTimeMillis();
        List<ResourceInformationVO> resourceInfoList = XMLFileParser.getResourceInformation();
        long endTime = System.currentTimeMillis();
        System.out.println("Total Resource Size: " + resourceInfoList.size());
        System.out.println("Total Time in Milli Sec: " + (endTime - startTime));
    }

}
