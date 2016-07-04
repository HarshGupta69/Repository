/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.nagarro.resource.allocator.core.NagarroResourceAllocatorUtility;
import com.nagarro.resource.allocator.main.NagarroResourceAllocatorMain;
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;
import com.nagarro.resource.allocator.vo.SkillSetVO;

/**
 * @author harshitgupta
 *
 */
public class ParseProjectInformation {

    /**
	 * 
	 */
    public ParseProjectInformation() {

    }

    public Map<SkillSetVO, ArrayList<ProjectRequirementVO>> parseProjectRequirement() {
        Map<SkillSetVO, ArrayList<ProjectRequirementVO>> projectReqMap =
                new HashMap<SkillSetVO, ArrayList<ProjectRequirementVO>>();
        try {
            File xmlFile = new File("F:\\Resource Allocator\\openings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("record");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    ProjectRequirementVO projectRequirementVO = createProjectRequirementVOByElement(eElement);
                    if (!projectReqMap.containsKey(projectRequirementVO.getMandatorySkills())) {
                        ArrayList<ProjectRequirementVO> projectRequirementVOs = new ArrayList<ProjectRequirementVO>();
                        projectReqMap.put(projectRequirementVO.getMandatorySkills(), projectRequirementVOs);
                    }
                    NagarroResourceAllocatorMain.skillSetVOs.add(projectRequirementVO.getMandatorySkills());
                    projectReqMap.get(projectRequirementVO.getMandatorySkills()).add(projectRequirementVO);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return projectReqMap;
    }

    private ProjectRequirementVO createProjectRequirementVOByElement(Element eElement) {
        ProjectRequirementVO projectRequirementVO = new ProjectRequirementVO();
        projectRequirementVO.setClientKey(null != eElement.getElementsByTagName("ClientKey").item(0) ? eElement
                .getElementsByTagName("ClientKey").item(0).getTextContent() : null);
        projectRequirementVO.setProjectKey(null != eElement.getElementsByTagName("ProjectKey").item(0) ? eElement
                .getElementsByTagName("ProjectKey").item(0).getTextContent() : null);
        projectRequirementVO.setCustomerName(null != eElement.getElementsByTagName("CustomerName").item(0) ? eElement
                .getElementsByTagName("CustomerName").item(0).getTextContent() : null);
        projectRequirementVO.setProjectName(null != eElement.getElementsByTagName("ProjectName").item(0) ? eElement
                .getElementsByTagName("ProjectName").item(0).getTextContent() : null);
        projectRequirementVO.setIsKeyProject(null != eElement.getElementsByTagName("IsKeyProject").item(0)
                ? NagarroResourceAllocatorUtility.stringToBoolean(eElement.getElementsByTagName("IsKeyProject").item(0)
                        .getTextContent()) : null);
        projectRequirementVO.setProjectDomain(null != eElement.getElementsByTagName("ProjectDomain").item(0) ? eElement
                .getElementsByTagName("ProjectDomain").item(0).getTextContent() : null);
        projectRequirementVO.setProjectStartDate(null != eElement.getElementsByTagName("ProjectStartDate").item(0)
                ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("ProjectStartDate")
                        .item(0).getTextContent()) : null);
        projectRequirementVO.setProjectEndDate(null != eElement.getElementsByTagName("ProjectEndDate").item(0)
                ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("ProjectEndDate").item(0)
                        .getTextContent()) : null);
        projectRequirementVO.setRequestID(null != eElement.getElementsByTagName("RequestID").item(0) ? eElement
                .getElementsByTagName("RequestID").item(0).getTextContent() : null);
        projectRequirementVO.setRole(null != eElement.getElementsByTagName("Role").item(0) ? eElement
                .getElementsByTagName("Role").item(0).getTextContent() : null);
        projectRequirementVO.setKeyPosition(null != eElement.getElementsByTagName("IsKeyPosition").item(0)
                ? NagarroResourceAllocatorUtility.stringToBoolean(eElement.getElementsByTagName("IsKeyPosition")
                        .item(0).getTextContent()) : null);
        projectRequirementVO.setYearsOfExperience(null != eElement.getElementsByTagName("YearsOfExperience").item(0)
                ? NagarroResourceAllocatorUtility.stringToFloat(eElement.getElementsByTagName("YearsOfExperience")
                        .item(0).getTextContent()) : null);
        projectRequirementVO.setMandatorySkills(new SkillSetVO(null != eElement.getElementsByTagName("MandatorySkills")
                .item(0) ? eElement.getElementsByTagName("MandatorySkills").item(0).getTextContent() : null));
        projectRequirementVO.setClientCommunication(null != eElement.getElementsByTagName("ClientCommunication")
                .item(0) ? eElement.getElementsByTagName("ClientCommunication").item(0).getTextContent() : null);
        projectRequirementVO.setRequestStartDate(null != eElement.getElementsByTagName("RequestStartDate").item(0)
                ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("RequestStartDate")
                        .item(0).getTextContent()) : null);
        projectRequirementVO.setAllocationEndDate(null != eElement.getElementsByTagName("AllocationEndDate").item(0)
                ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("AllocationEndDate")
                        .item(0).getTextContent()) : null);
        return projectRequirementVO;
    }

}
