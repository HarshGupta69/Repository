/**
 * 
 */
package com.nagarro.resource.allocator.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.nagarro.resource.allocator.core.NagarroResourceAllocatorUtility;
import com.nagarro.resource.allocator.vo.ResourceInformationVO;

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

    public List<ResourceInformationVO> parseResourceInformation() {
        List<ResourceInformationVO> resourceInfoVOList = new ArrayList<ResourceInformationVO>();
        try {
            File xmlFile = new File("resources.xml");
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
                    ResourceInformationVO resourceInfoVO = new ResourceInformationVO();
                    resourceInfoVO.setEmployeeId(null != eElement.getElementsByTagName("EmployeeID").item(0) ? eElement
                            .getElementsByTagName("EmployeeID").item(0).getTextContent() : null);
                    resourceInfoVO.setDoj(null != eElement.getElementsByTagName("DOJ").item(0)
                            ? NagarroResourceAllocatorUtility.stringToDate(eElement.getElementsByTagName("DOJ").item(0)
                                    .getTextContent()) : null);
                    resourceInfoVO.setSkills(null != eElement.getElementsByTagName("Skills").item(0)
                            ? NagarroResourceAllocatorUtility.stringToList(eElement.getElementsByTagName("Skills")
                                    .item(0).getTextContent()) : null);
                    resourceInfoVO.setDomainExperience(null != eElement.getElementsByTagName("DomainExperience")
                            .item(0) ? eElement.getElementsByTagName("DomainExperience").item(0).getTextContent()
                            : null);
                    resourceInfoVO.setRating(null != eElement.getElementsByTagName("Rating").item(0) ? eElement
                            .getElementsByTagName("Rating").item(0).getTextContent() : null);
                    resourceInfoVO.setCommunicationsRating(null != eElement
                            .getElementsByTagName("CommunicationsRating").item(0) ? eElement
                            .getElementsByTagName("CommunicationsRating").item(0).getTextContent() : null);
                    resourceInfoVO.setNagp(null != eElement.getElementsByTagName("NAGP").item(0) ? eElement
                            .getElementsByTagName("NAGP").item(0).getTextContent() : null);
                    resourceInfoVO.setYearsOfExperience(null != eElement.getElementsByTagName("YearsOfExperience")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToFloat(eElement
                            .getElementsByTagName("YearsOfExperience").item(0).getTextContent()) : null);
                    resourceInfoVO.setCurrentRole(null != eElement.getElementsByTagName("CurrentRole").item(0)
                            ? eElement.getElementsByTagName("CurrentRole").item(0).getTextContent() : null);
                    resourceInfoVO.setPreviousCustomerExperience(null != eElement.getElementsByTagName(
                            "PreviousCustomerExperience").item(0) ? eElement
                            .getElementsByTagName("PreviousCustomerExperience").item(0).getTextContent() : null);
                    resourceInfoVO.setAvailableFromDate(null != eElement.getElementsByTagName("AvailableFromDate")
                            .item(0) ? NagarroResourceAllocatorUtility.stringToDate(eElement
                            .getElementsByTagName("AvailableFromDate").item(0).getTextContent()) : null);
                    resourceInfoVOList.add(resourceInfoVO);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return resourceInfoVOList;
    }
}
