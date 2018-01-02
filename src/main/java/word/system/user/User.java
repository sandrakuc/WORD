package word.system.user;

import word.system.common.Address;
import word.system.user.permission.UserPermission;

/**
 * 
 */
public class User {

    public enum Permission {
        LOGIN, PRACTIC_EXAMINER, TEORETICAL_EXAMINER, CITY_DEPARTMENT
    }

    protected UserPermission perms;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 
     */
    public Address address;

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String firstName;

    public UserPermission getPerms() {
        return perms;
    }

    public void setPerms(UserPermission perms) {
        this.perms = perms;
    }
}