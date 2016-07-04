/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import java.util.Date;

import com.nagarro.resource.allocator.core.NagarroResourceAllocatorUtility;

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

    private String clientKey;
    private String projectKey;
    private String customerName;
    private String projectName;
    private boolean isKeyProject;
    private String projectDomain;
    private Date projectStartDate;
    private Date projectEndDate;
    private String requestID;
    private String role;
    private boolean isKeyPosition;
    private float yearsOfExperience;
    private SkillSetVO mandatorySkills;
    private String clientCommunication;
    private Date requestStartDate;
    private Date allocationEndDate;

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
    public boolean getIsKeyProject() {
        return isKeyProject;
    }

    /**
     * @param isKeyProject
     *            the isKeyProject to set
     */
    public void setIsKeyProject(Boolean isKeyProject) {
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
     * @return the requestID
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * @return the requestID
     */
    public int getRequestIDInt() {
        return Integer.parseInt(requestID.trim());
    }

    /**
     * @param requestID
     *            the requestID to set
     */
    public void setRequestID(String requestID) {
        this.requestID = requestID;
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
    public boolean isKeyPosition() {
        return isKeyPosition;
    }

    /**
     * @param isKeyPosition
     *            the isKeyPosition to set
     */
    public void setKeyPosition(boolean isKeyPosition) {
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
    public SkillSetVO getMandatorySkills() {
        return mandatorySkills;
    }

    /**
     * @param mandatorySkills
     *            the mandatorySkills to set
     */
    public void setMandatorySkills(SkillSetVO mandatorySkills) {
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
     * @param isKeyProject
     *            the isKeyProject to set
     */
    public void setKeyProject(boolean isKeyProject) {
        this.isKeyProject = isKeyProject;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProjectRequirementVO [clientKey=" + clientKey + ", projectKey=" + projectKey + ", customerName="
                + customerName + ", projectName=" + projectName + ", isKeyProject=" + isKeyProject + ", projectDomain="
                + projectDomain + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
                + ", requestID=" + requestID + ", role=" + role + ", isKeyPosition=" + isKeyPosition
                + ", yearsOfExperience=" + yearsOfExperience + ", mandatorySkills=" + mandatorySkills
                + ", clientCommunication=" + clientCommunication + ", requestStartDate=" + requestStartDate
                + ", allocationEndDate=" + allocationEndDate + "]";
    }

    public int getDaysOfRequirement() {
        return NagarroResourceAllocatorUtility.getDaysDifference(requestStartDate, allocationEndDate);
    }

    public boolean isRequirementCorrect() {
        boolean flag = true;
        if (getDaysOfRequirement() < 0) {
            flag = false;
        }
        return flag;
    }

}
