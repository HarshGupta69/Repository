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

    private String clientKey;
    private String projectKey;
    private String customerName;
    private String projectName;
    private String isKeyProject;
    private String projectDomain;
    private Date projectStartDate;
    private Date projectEndDate;
    private List<ResourceRequirementVO> resourceRequirementVOs = new ArrayList<ResourceRequirementVO>();

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
     * @return the resourceRequirementVOs
     */
    public List<ResourceRequirementVO> getResourceRequirementVOs() {
        return resourceRequirementVOs;
    }

    /**
     * @param resourceRequirementVOs
     *            the resourceRequirementVOs to set
     */
    public void setResourceRequirementVOs(List<ResourceRequirementVO> resourceRequirementVOs) {
        this.resourceRequirementVOs = resourceRequirementVOs;
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
                + ", resourceRequirementVOs=" + resourceRequirementVOs + "]";
    }

}
