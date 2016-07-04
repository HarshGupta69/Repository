/**
 * 
 */
package com.nagarro.resource.allocator.comperator;

import java.util.Comparator;

import com.nagarro.resource.allocator.vo.ProjectRequirementVO;

/**
 * @author harshitgupta
 *
 */
public class ProjectRequirementVOComperator implements Comparator<ProjectRequirementVO> {

    /**
     * 
     */
    public ProjectRequirementVOComperator() {
        super();
    }

    @Override
    public int compare(ProjectRequirementVO o1, ProjectRequirementVO o2) {
        int value = 0;
        if (o1.getDaysOfRequirement() == o2.getDaysOfRequirement()) {
            value = 0;
        } else if (o1.getDaysOfRequirement() > o2.getDaysOfRequirement()) {
            value = 1;
        } else if (o1.getDaysOfRequirement() < o2.getDaysOfRequirement()) {
            value = -1;
        }
        return value;
    }

}
