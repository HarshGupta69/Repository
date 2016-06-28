/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.nagarro.resource.allocator.vo.ProjectRequirementVO;

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

    public Map<String, List<ProjectRequirementVO>> parseProjectRequirement() {
        Map<String, List<ProjectRequirementVO>> projectReqMap = new HashMap<String, List<ProjectRequirementVO>>();
        try {
            File xmlFile = new File("openings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("record");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    ProjectRequirementVO projectReqVO = new ProjectRequirementVO();
                    projectReqVO.setRequestID(null != eElement.getElementsByTagName("RequestID").item(0) ? eElement
                            .getElementsByTagName("RequestID").item(0).getTextContent() : null);
                    projectReqVO.setClientKey(null != eElement.getElementsByTagName("ClientKey").item(0) ? eElement
                            .getElementsByTagName("ClientKey").item(0).getTextContent() : null);
                    projectReqVO.setProjectKey(null != eElement.getElementsByTagName("ProjectKey").item(0) ? eElement
                            .getElementsByTagName("ProjectKey").item(0).getTextContent() : null);
                    projectReqVO.setCustomerName(null != eElement.getElementsByTagName("CustomerName").item(0)
                            ? eElement.getElementsByTagName("CustomerName").item(0).getTextContent() : null);
                    projectReqVO.setProjectName(null != eElement.getElementsByTagName("ProjectName").item(0) ? eElement
                            .getElementsByTagName("ProjectName").item(0).getTextContent() : null);
                    projectReqVO.setIsKeyProject(null != eElement.getElementsByTagName("IsKeyProject").item(0)
                            ? eElement.getElementsByTagName("IsKeyProject").item(0).getTextContent() : null);
                    projectReqVO.setProjectDomain(null != eElement.getElementsByTagName("ProjectDomain").item(0)
                            ? eElement.getElementsByTagName("ProjectDomain").item(0).getTextContent() : null);
                    projectReqVO.setProjectStartDate(null != eElement.getElementsByTagName("ProjectStartDate").item(0)
                            ? NagarroResourceAllocatorUtility.stringToDate(eElement
                                    .getElementsByTagName("ProjectStartDate").item(0).getTextContent()) : null);
                    projectReqVO.setProjectEndDate(null != eElement.getElementsByTagName("ProjectEndDate").item(0)
                            ? NagarroResourceAllocatorUtility.stringToDate(eElement
                                    .getElementsByTagName("ProjectEndDate").item(0).getTextContent()) : null);
                    projectReqVO.setRole(null != eElement.getElementsByTagName("Role").item(0) ? eElement
                            .getElementsByTagName("Role").item(0).getTextContent() : null);
                    projectReqVO.setIsKeyPosition(null != eElement.getElementsByTagName("IsKeyPosition").item(0)
                            ? eElement.getElementsByTagName("IsKeyPosition").item(0).getTextContent() : null);
                    projectReqVO.setYearsOfExperience(null != eElement.getElementsByTagName("YearsOfExperience")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToFloat(eElement
                            .getElementsByTagName("YearsOfExperience").item(0).getTextContent()) : null);
                    projectReqVO.setMandatorySkills(null != eElement.getElementsByTagName("MandatorySkills").item(0)
                            ? NagarroResourceAllocatorUtility.stringToList(eElement
                                    .getElementsByTagName("MandatorySkills").item(0).getTextContent()) : null);
                    projectReqVO.setClientCommunication(null != eElement.getElementsByTagName("ClientCommunication")
                            .item(0) ? eElement.getElementsByTagName("ClientCommunication").item(0).getTextContent()
                            : null);
                    projectReqVO.setRequestStartDate(null != eElement.getElementsByTagName("RequestStartDate").item(0)
                            ? NagarroResourceAllocatorUtility.stringToDate(eElement
                                    .getElementsByTagName("RequestStartDate").item(0).getTextContent()) : null);
                    projectReqVO.setAllocationEndDate(null != eElement.getElementsByTagName("AllocationEndDate")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToDate(eElement
                            .getElementsByTagName("AllocationEndDate").item(0).getTextContent()) : null);
                    projectReqVO.setResourceInformationVOs();
                    addProjectReqToMapByProject(projectReqMap, projectReqVO);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return projectReqMap;
    }

    private void addProjectReqToMapByProject(Map<String, List<ProjectRequirementVO>> projectReqVOMap,
            ProjectRequirementVO projectRequirementVO) {
        if (!projectReqVOMap.containsKey(projectRequirementVO.getProjectName())) {
            List<ProjectRequirementVO> projectRequirementVOs = new ArrayList<ProjectRequirementVO>();
            projectReqVOMap.put(projectRequirementVO.getProjectName(), projectRequirementVOs);
        }
        projectReqVOMap.get(projectRequirementVO.getProjectName()).add(projectRequirementVO);
    }

}
