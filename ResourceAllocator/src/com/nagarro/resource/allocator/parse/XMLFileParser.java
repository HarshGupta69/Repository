/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.util.List;

import com.nagarro.resource.allocator.vo.ResourceInformationVO;

/**
 * @author harshitgupta
 *
 */
public class XMLFileParser {

    /**
	 * 
	 */
    public XMLFileParser() {

    }

    public static List<ResourceInformationVO> getResourceInformation() {
        ParseResourceInformation parseResInfo = new ParseResourceInformation();
        return parseResInfo.parseResourceInformation();
    }
}
