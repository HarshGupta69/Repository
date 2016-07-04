/**
 * 
 */
package com.nagarro.resource.allocator.comperator;

import java.util.Comparator;

import com.nagarro.resource.allocator.vo.SkillSetVO;

/**
 * @author harshitgupta
 *
 */
public class SkillSetVOComperator implements Comparator<SkillSetVO> {

    /**
     * 
     */
    public SkillSetVOComperator() {
        super();
    }

    @Override
    public int compare(SkillSetVO o1, SkillSetVO o2) {
        int value = 0;
        if (o1.getSkillSet().size() == o2.getSkillSet().size()) {
            if (o1.getLevelCount() == o2.getLevelCount()) {
                value = 0;
            } else if (o1.getLevelCount() < o2.getLevelCount()) {
                value = 1;
            } else if (o1.getLevelCount() > o2.getLevelCount()) {
                value = -1;
            }
        } else if (o1.getSkillSet().size() < o2.getSkillSet().size()) {
            value = 1;
        } else if (o1.getSkillSet().size() > o2.getSkillSet().size()) {
            value = -1;
        }
        return value;
    }

}
