/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author harshitgupta
 *
 */
public class ProjectRequirementVO {

    /**
	 * 
	 */
    public ProjectRequirementVO() {

    }

    private String requestID;
    private String clientKey;
    private String projectKey;
    private String customerName;
    private String projectName;
    private String isKeyProject;
    private String projectDomain;
    private Date projectStartDate;
    private Date projectEndDate;
    private String role;
    private String isKeyPosition;
    private float yearsOfExperience;
    private List<String> mandatorySkills;
    private String clientCommunication;
    private Date requestStartDate;
    private Date allocationEndDate;
    private List<ResourceInformationVO> resourceInformationVOs = null;

    /**
     * @return the requestID
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * @param requestID
     *            the requestID to set
     */
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    /**
     * @return the clientKey
     */
    public String getClientKey() {
        return clientKey;
    }

    /**
     * @param clientKey
     *            the clientKey to set
     */
    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    /**
     * @return the projectKey
     */
    public String getProjectKey() {
        return projectKey;
    }

    /**
     * @param projectKey
     *            the projectKey to set
     */
    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     *            the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     *            the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the isKeyProject
     */
    public String getIsKeyProject() {
        return isKeyProject;
    }

    /**
     * @param isKeyProject
     *            the isKeyProject to set
     */
    public void setIsKeyProject(String isKeyProject) {
        this.isKeyProject = isKeyProject;
    }

    /**
     * @return the projectDomain
     */
    public String getProjectDomain() {
        return projectDomain;
    }

    /**
     * @param projectDomain
     *            the projectDomain to set
     */
    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }

    /**
     * @return the projectStartDate
     */
    public Date getProjectStartDate() {
        return projectStartDate;
    }

    /**
     * @param projectStartDate
     *            the projectStartDate to set
     */
    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    /**
     * @return the projectEndDate
     */
    public Date getProjectEndDate() {
        return projectEndDate;
    }

    /**
     * @param projectEndDate
     *            the projectEndDate to set
     */
    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the isKeyPosition
     */
    public String getIsKeyPosition() {
        return isKeyPosition;
    }

    /**
     * @param isKeyPosition
     *            the isKeyPosition to set
     */
    public void setIsKeyPosition(String isKeyPosition) {
        this.isKeyPosition = isKeyPosition;
    }

    /**
     * @return the yearsOfExperience
     */
    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * @param yearsOfExperience
     *            the yearsOfExperience to set
     */
    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * @return the mandatorySkills
     */
    public List<String> getMandatorySkills() {
        return mandatorySkills;
    }

    /**
     * @param mandatorySkills
     *            the mandatorySkills to set
     */
    public void setMandatorySkills(List<String> mandatorySkills) {
        this.mandatorySkills = mandatorySkills;
    }

    /**
     * @return the clientCommunication
     */
    public String getClientCommunication() {
        return clientCommunication;
    }

    /**
     * @param clientCommunication
     *            the clientCommunication to set
     */
    public void setClientCommunication(String clientCommunication) {
        this.clientCommunication = clientCommunication;
    }

    /**
     * @return the requestStartDate
     */
    public Date getRequestStartDate() {
        return requestStartDate;
    }

    /**
     * @param requestStartDate
     *            the requestStartDate to set
     */
    public void setRequestStartDate(Date requestStartDate) {
        this.requestStartDate = requestStartDate;
    }

    /**
     * @return the allocationEndDate
     */
    public Date getAllocationEndDate() {
        return allocationEndDate;
    }

    /**
     * @param allocationEndDate
     *            the allocationEndDate to set
     */
    public void setAllocationEndDate(Date allocationEndDate) {
        this.allocationEndDate = allocationEndDate;
    }

    /**
     * @return the resourceInformationVOs
     */
    public List<ResourceInformationVO> getResourceInformationVOs() {
        return resourceInformationVOs;
    }

    /**
     * @param resourceInformationVOs
     *            the resourceInformationVOs to set
     */
    public void setResourceInformationVOs(List<ResourceInformationVO> resourceInformationVOs) {
        this.resourceInformationVOs = new ArrayList<ResourceInformationVO>();
        for (ResourceInformationVO resourceInformationVO : resourceInformationVOs) {
            if (resourceInformationVO.getSkills().containsAll(mandatorySkills)
                    && 0 >= resourceInformationVO.getAvailableFromDate().compareTo(this.requestStartDate)) {
                ResourceInformationVO informationVO = new ResourceInformationVO(resourceInformationVO);
                informationVO.addPoints(1);
                this.resourceInformationVOs.add(informationVO);
            }
        }
    }

}
