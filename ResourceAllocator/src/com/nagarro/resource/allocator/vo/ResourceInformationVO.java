/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import java.util.Date;
import java.util.List;

import com.nagarro.resource.allocator.core.AppConstants;

/**
 * @author harshitgupta
 *
 */
public class ResourceInformationVO {

    private String employeeId;
    private Date doj;
    private List<String> skills;
    private String domainExperience;
    private String rating;
    private String communicationsRating;
    private String nagp;
    private float yearsOfExperience;
    private String currentRole;
    private Date availableFromDate;
    private List<String> previousCustomerExperience;
    private float points;

    /**
	 * 
	 */
    public ResourceInformationVO() {

    }

    public ResourceInformationVO(ResourceInformationVO resourceInformationVO) {
        this.employeeId = resourceInformationVO.employeeId;
        this.doj = resourceInformationVO.doj;
        this.skills = resourceInformationVO.skills;
        this.domainExperience = resourceInformationVO.domainExperience;
        this.rating = resourceInformationVO.rating;
        this.communicationsRating = resourceInformationVO.communicationsRating;
        this.nagp = resourceInformationVO.nagp;
        this.yearsOfExperience = resourceInformationVO.yearsOfExperience;
        this.currentRole = resourceInformationVO.currentRole;
        this.availableFromDate = resourceInformationVO.availableFromDate;
        this.previousCustomerExperience = resourceInformationVO.previousCustomerExperience;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     *            the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the doj
     */
    public Date getDoj() {
        return doj;
    }

    /**
     * @param doj
     *            the doj to set
     */
    public void setDoj(Date doj) {
        this.doj = doj;
    }

    /**
     * @return the skills
     */
    public List<String> getSkills() {
        return skills;
    }

    /**
     * @param skills
     *            the skills to set
     */
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    /**
     * @return the domainExperience
     */
    public String getDomainExperience() {
        return domainExperience;
    }

    /**
     * @param domainExperience
     *            the domainExperience to set
     */
    public void setDomainExperience(String domainExperience) {
        this.domainExperience = domainExperience;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating
     *            the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the communicationsRating
     */
    public String getCommunicationsRating() {
        return communicationsRating;
    }

    /**
     * @param communicationsRating
     *            the communicationsRating to set
     */
    public void setCommunicationsRating(String communicationsRating) {
        this.communicationsRating = communicationsRating;
    }

    /**
     * @return the nagp
     */
    public String getNagp() {
        return nagp;
    }

    /**
     * @param nagp
     *            the nagp to set
     */
    public void setNagp(String nagp) {
        this.nagp = nagp;
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
     * @return the currentRole
     */
    public String getCurrentRole() {
        return currentRole;
    }

    /**
     * @param currentRole
     *            the currentRole to set
     */
    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    /**
     * @return the availableFromDate
     */
    public Date getAvailableFromDate() {
        return availableFromDate;
    }

    /**
     * @param availableFromDate
     *            the availableFromDate to set
     */
    public void setAvailableFromDate(Date availableFromDate) {
        this.availableFromDate = availableFromDate;
    }

    /**
     * @return the previousCustomerExperience
     */
    public List<String> getPreviousCustomerExperience() {
        return previousCustomerExperience;
    }

    /**
     * @param list
     *            the previousCustomerExperience to set
     */
    public void setPreviousCustomerExperience(List<String> previousCustomerExperience) {
        this.previousCustomerExperience = previousCustomerExperience;
    }

    /**
     * @return the points
     */
    public float getPoints() {
        return points;
    }

    /**
     * @param points
     *            the points to set
     */
    public void setPoints(float points) {
        this.points = points;
    }

    public void addPoints(double d) {
        this.points += d;
    }

    public void updatePoints(ResourceRequirementVO resourceRequirementVO) {
        if (nagp.equalsIgnoreCase(AppConstants.Y)) {
            addPoints(0.3);
        }
        if (rating.equalsIgnoreCase(AppConstants.A_PLUS)) {
            addPoints(0.2);
        } else if (rating.equalsIgnoreCase(AppConstants.A)) {
            addPoints(0.1);
        }
        if (null != domainExperience
                && domainExperience
                        .equalsIgnoreCase(resourceRequirementVO.getProjectRequirementVO().getProjectDomain())) {
            addPoints(0.2);
            if (null != previousCustomerExperience
                    && previousCustomerExperience.contains(resourceRequirementVO.getProjectRequirementVO()
                            .getCustomerName())) {
                addPoints(0.3);
            }
        }
        if (yearsOfExperience > resourceRequirementVO.getYearsOfExperience()) {
            addPoints((yearsOfExperience - resourceRequirementVO.getYearsOfExperience()) * 0.05);
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ResourceInformationVO [employeeId=" + employeeId + ", doj=" + doj + ", skills=" + skills
                + ", domainExperience=" + domainExperience + ", rating=" + rating + ", communicationsRating="
                + communicationsRating + ", nagp=" + nagp + ", yearsOfExperience=" + yearsOfExperience
                + ", currentRole=" + currentRole + ", availableFromDate=" + availableFromDate
                + ", previousCustomerExperience=" + previousCustomerExperience + ", points=" + points + "]";
    }

}
