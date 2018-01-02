package word.system.exam.maneouver;

import java.util.*;

/**
 * 
 */
public class ManeuverResult {

    /**
     * Default constructor
     */
    public ManeuverResult() {
    }

    protected Maneuver maneuver;

    /**
     * 
     */
    protected boolean negative1;

    /**
     * 
     */
    protected boolean negative2;

    /**
     * 
     */
    protected boolean positive;


    public Maneuver getManeuver() {
        return maneuver;
    }

    public void setManeuver(Maneuver maneuver) {
        this.maneuver = maneuver;
    }

    public boolean isNegative1() {
        return negative1;
    }

    public void setNegative1(boolean negative1) {
        this.negative1 = negative1;
    }

    public boolean isNegative2() {
        return negative2;
    }

    public void setNegative2(boolean negative2) {
        this.negative2 = negative2;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }
}