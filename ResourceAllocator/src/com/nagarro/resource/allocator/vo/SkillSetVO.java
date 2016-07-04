/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import java.util.Set;

import com.nagarro.resource.allocator.core.NagarroResourceAllocatorUtility;
import com.nagarro.resource.allocator.core.SkillLevel;

/**
 * @author harshitgupta
 *
 */
public class SkillSetVO implements Comparable<SkillSetVO> {

    private Set<Skill> skillSet;

    /**
     * 
     */
    public SkillSetVO(String skills) {
        this.skillSet = NagarroResourceAllocatorUtility.stringToSkillSet(skills);
    }

    /**
     * @return the skillSet
     */
    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    /**
     * @param skillSet
     *            the skillSet to set
     */
    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SkillSetVO [skillSet=" + skillSet + "]";
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((skillSet == null) ? 0 : skillSet.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        SkillSetVO skillSetVO = (SkillSetVO) obj;
        if (null != skillSetVO
                && (this.skillSet.size() == skillSetVO.getSkillSet().size()
                        && this.skillSet.containsAll(skillSetVO.getSkillSet()) && skillSetVO.getSkillSet().containsAll(
                        this.skillSet))) {
            return true;
        }
        return false;
    }

    public boolean has(Object obj) {
        boolean b = true;
        SkillSetVO skillSetVO = (SkillSetVO) obj;
        if (null != skillSetVO) {
            for (Skill skill : skillSetVO.skillSet) {
                boolean flag = false;
                for (Skill skill2 : this.skillSet) {
                    if (skill.getSkillName().equals(skill2.getSkillName())
                            && SkillLevel.valueOf(skill.getSkillLevel()).getLevel() <= SkillLevel.valueOf(
                                    skill2.getSkillLevel()).getLevel()) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }

    @Override
    public int compareTo(SkillSetVO paramT) {
        int value = 0;
        if (this.getSkillSet().size() == paramT.getSkillSet().size()) {
            value = 0;
        } else if (this.getSkillSet().size() < paramT.getSkillSet().size()) {
            value = 1;
        } else if (this.getSkillSet().size() > paramT.getSkillSet().size()) {
            value = -1;
        }
        return value;
    }

    public int getLevelCount() {
        int levelCount = 0;
        for (Skill skill : this.skillSet) {
            levelCount += SkillLevel.valueOf(skill.getSkillLevel()).getLevel();
        }
        return levelCount;
    }
}
