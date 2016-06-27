/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import java.util.Date;
import java.util.List;

/**
 * @author harshitgupta
 *
 */
public class ResourceRequirementVO {

    private String requestID;
    private String role;
    private String isKeyPosition;
    private float yearsOfExperience;
    private List<String> mandatorySkills;
    private String clientCommunication;
    private Date requestStartDate;
    private Date allocationEndDate;

    /**
     * 
     */
    public ResourceRequirementVO() {
        super();
    }

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

}
