package word.system.user.permission;

import word.system.user.User;

/**
 * 
 */
public class CityDepartmentPermissionPermDecorator extends PermDecorator {


    /**
     * Default constructor
     *
     * @param userPerm
     */
    public CityDepartmentPermissionPermDecorator(UserPermission userPerm) {
        super(userPerm);
        this.myPerms.add(User.Permission.CITY_DEPARTMENT);
    }
}