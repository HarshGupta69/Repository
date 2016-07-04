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
import com.nagarro.resource.allocator.main.NagarroResourceAllocatorMain;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;
import com.nagarro.resource.allocator.vo.SkillSetVO;

/**
 * @author laxmanthagan
 *
 */
public class ParseResourceInformation {

    /**
	 * 
	 */
    public ParseResourceInformation() {

    }

    public Map<SkillSetVO, List<ResourceInformationVO>> parseResourceInformation() {
        Map<SkillSetVO, List<ResourceInformationVO>> resourceInfoVOMap =
                new HashMap<SkillSetVO, List<ResourceInformationVO>>();
        try {
            File xmlFile = new File("F:\\Resource Allocator\\resources.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("record");
            System.out.println("---------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    ResourceInformationVO resourceInfoVO = new ResourceInformationVO();
                    resourceInfoVO.setEmployeeId(null != eElement.getElementsByTagName("EmployeeID").item(0) ? eElement
                            .getElementsByTagName("EmployeeID").item(0).getTextContent() : null);
                    resourceInfoVO.setDoj(null != eElement.getElementsByTagName("DOJ").item(0)
                            ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("DOJ").item(0)
                                    .getTextContent()) : null);
                    resourceInfoVO.setSkillSetVO(new SkillSetVO(null != eElement.getElementsByTagName("Skills").item(0)
                            ? eElement.getElementsByTagName("Skills").item(0).getTextContent() : null));
                    resourceInfoVO.setDomainExperience(null != eElement.getElementsByTagName("DomainExperience")
                            .item(0) ? eElement.getElementsByTagName("DomainExperience").item(0).getTextContent()
                            : null);
                    resourceInfoVO.setRating(null != eElement.getElementsByTagName("Rating").item(0) ? eElement
                            .getElementsByTagName("Rating").item(0).getTextContent() : null);
                    resourceInfoVO.setCommunicationsRating(null != eElement
                            .getElementsByTagName("CommunicationsRating").item(0) ? eElement
                            .getElementsByTagName("CommunicationsRating").item(0).getTextContent() : null);
                    resourceInfoVO.setNagp(null != eElement.getElementsByTagName("NAGP").item(0)
                            ? NagarroResourceAllocatorUtility.stringToBoolean(eElement.getElementsByTagName("NAGP")
                                    .item(0).getTextContent()) : null);
                    resourceInfoVO.setYearsOfExperience(null != eElement.getElementsByTagName("YearsOfExperience")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToFloat(eElement
                            .getElementsByTagName("YearsOfExperience").item(0).getTextContent()) : null);
                    resourceInfoVO.setCurrentRole(null != eElement.getElementsByTagName("CurrentRole").item(0)
                            ? eElement.getElementsByTagName("CurrentRole").item(0).getTextContent() : null);
                    resourceInfoVO.setPreviousCustomerExperience(null != eElement.getElementsByTagName(
                            "PreviousCustomerExperience").item(0) ? NagarroResourceAllocatorUtility
                            .stringToList(eElement.getElementsByTagName("PreviousCustomerExperience").item(0)
                                    .getTextContent()) : null);
                    resourceInfoVO.setAvailableFromDate(null != eElement.getElementsByTagName("AvailableFromDate")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToDate(eElement
                            .getElementsByTagName("AvailableFromDate").item(0).getTextContent()) : null);
                    resourceInfoVO.initialPoints();
                    NagarroResourceAllocatorMain.resourceInformationVOs.add(resourceInfoVO);
                    addResourceToMapBySkill(resourceInfoVOMap, resourceInfoVO);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return resourceInfoVOMap;
    }

    private void addResourceToMapBySkill(Map<SkillSetVO, List<ResourceInformationVO>> resourceInfoVOMap,
            ResourceInformationVO resourceInformationVO) {
        if (null == resourceInfoVOMap.get(resourceInformationVO.getSkillSetVO())) {
            List<ResourceInformationVO> resourceInformationVOs = new ArrayList<ResourceInformationVO>();
            resourceInfoVOMap.put(resourceInformationVO.getSkillSetVO(), resourceInformationVOs);
        }
        NagarroResourceAllocatorMain.skillSetVOs.add(resourceInformationVO.getSkillSetVO());
        resourceInfoVOMap.get(resourceInformationVO.getSkillSetVO()).add(resourceInformationVO);
    }
}
