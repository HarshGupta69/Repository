/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;
import com.nagarro.resource.allocator.vo.SkillSetVO;

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

    public static Map<SkillSetVO, List<ResourceInformationVO>> getResourceInformation() {
        ParseResourceInformation parseResInfo = new ParseResourceInformation();
        return parseResInfo.parseResourceInformation();
    }

    public static Map<SkillSetVO, ArrayList<ProjectRequirementVO>> getProjectRequirement() {
        ParseProjectInformation parseProjInfo = new ParseProjectInformation();
        Map<SkillSetVO, ArrayList<ProjectRequirementVO>> projectRequirementMap =
                parseProjInfo.parseProjectRequirement();
        return projectRequirementMap;
    }
}
