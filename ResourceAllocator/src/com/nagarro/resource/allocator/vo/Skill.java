/**
 * 
 */
package com.nagarro.resource.allocator.vo;

import com.nagarro.resource.allocator.core.SkillLevel;

/**
 * @author harshitgupta
 *
 */
public class Skill {

    private String skillName;

    private String skillLevel;

    /**
     * @return the skillName
     */
    public String getSkillName() {
        return skillName;
    }

    /**
     * @param skillName
     *            the skillName to set
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    /**
     * @param skillName
     * @param skillLevel
     */
    public Skill(String skillName, String skillLevel) {
        super();
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }

    /**
     * @return the skillLevel
     */
    public String getSkillLevel() {
        return skillLevel;
    }

    /**
     * @param skillLevel
     *            the skillLevel to set
     */
    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Skill [skillName=" + skillName + ", skillLevel=" + skillLevel + "]";
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
        result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Skill skill = (Skill) obj;
        if (this.skillName.equals(skill.skillName)
                && SkillLevel.valueOf(this.skillLevel).getLevel() == SkillLevel.valueOf(skill.skillLevel).getLevel())
            return true;
        return false;
    }

}
