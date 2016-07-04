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
public class QueuedResourceVO {

    private ResourceInformationVO resourceInformationVO;
    private ProjectRequirementVO projectRequirementVO;
    private Date requestStartDate;
    private Date allocationEndDate;
    private float points;

    public QueuedResourceVO(ProjectRequirementVO projectRequirementVO, ResourceInformationVO resourceInformationVO) {
        setProjectRequirementVO(projectRequirementVO);
        setResourceInformationVO(resourceInformationVO);
        this.points =
                NagarroResourceAllocatorUtility.getPointsOfResourceForRequirement(projectRequirementVO,
                        resourceInformationVO);
    }

    /**
     * @return the resourceInformationVO
     */
    public ResourceInformationVO getResourceInformationVO() {
        return resourceInformationVO;
    }

    /**
     * @param resourceInformationVO
     *            the resourceInformationVO to set
     */
    public void setResourceInformationVO(ResourceInformationVO resourceInformationVO) {
        this.resourceInformationVO = resourceInformationVO;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "QueuedResourceVO [resourceInformationVO=" + resourceInformationVO + ", projectRequirementVO="
                + projectRequirementVO + ", requestStartDate=" + requestStartDate + ", allocationEndDate="
                + allocationEndDate + ", points=" + points + "]";
    }

    /**
     * @return the projectRequirementVO
     */
    public ProjectRequirementVO getProjectRequirementVO() {
        return projectRequirementVO;
    }

    /**
     * @param projectRequirementVO
     *            the projectRequirementVO to set
     */
    public void setProjectRequirementVO(ProjectRequirementVO projectRequirementVO) {
        this.projectRequirementVO = projectRequirementVO;
        this.requestStartDate = projectRequirementVO.getRequestStartDate();
        this.allocationEndDate = projectRequirementVO.getAllocationEndDate();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((allocationEndDate == null) ? 0 : allocationEndDate.hashCode());
        result = prime * result + ((projectRequirementVO == null) ? 0 : projectRequirementVO.hashCode());
        result = prime * result + ((requestStartDate == null) ? 0 : requestStartDate.hashCode());
        result = prime * result + ((resourceInformationVO == null) ? 0 : resourceInformationVO.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        QueuedResourceVO queuedResourceVO = (QueuedResourceVO) obj;
        if (this == obj)
            return true;
        else if (this.resourceInformationVO == queuedResourceVO.getResourceInformationVO()
                && NagarroResourceAllocatorUtility.dateRangeIntersecting(this.requestStartDate, this.allocationEndDate,
                        queuedResourceVO.requestStartDate, queuedResourceVO.allocationEndDate))
            return true;
        return false;
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
}
