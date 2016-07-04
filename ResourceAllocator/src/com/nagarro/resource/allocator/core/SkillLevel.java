/**
 * 
 */
package com.nagarro.resource.allocator.core;

/**
 * @author harshitgupta
 *
 */
public enum SkillLevel {
    EXPERT(2, "EXPERT"), INTERMEDIATE(1, "INTERMEDIATE"), BEGINNER(0, "INTERMEDIATE");

    private int level;

    private String levelName;

    /**
     * @param level
     * @param levelName
     */
    private SkillLevel(int level, String levelName) {
        this.level = level;
        this.levelName = levelName;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the levelName
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName
     *            the levelName to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
