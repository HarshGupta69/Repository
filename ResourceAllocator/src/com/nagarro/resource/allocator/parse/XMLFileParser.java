/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.util.List;
import java.util.Map;

import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
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

    public static Map<String, List<ResourceInformationVO>> getResourceInformation() {
        ParseResourceInformation parseResInfo = new ParseResourceInformation();
        return parseResInfo.parseResourceInformation();
    }

    public static Map<String, ProjectRequirementVO> getProjectRequirement() {
        ParseProjectInformation parseProjInfo = new ParseProjectInformation();
        return parseProjInfo.parseProjectRequirement();
    }
}
