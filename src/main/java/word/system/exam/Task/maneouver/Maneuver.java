package word.system.exam.Task.maneouver;

import word.system.common.DriveLicenseType;

/**
 * 
 */
public class Maneuver {

    /**
     * Default constructor
     */
    public Maneuver() {
    }

    public Maneuver(String name, String description, DriveLicenseType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * 
     */
    protected String name;

    /**
     * 
     */
    protected String description;

    /**
     * 
     */
    protected DriveLicenseType type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DriveLicenseType getType() {
        return type;
    }

    public void setType(DriveLicenseType type) {
        this.type = type;
    }
}