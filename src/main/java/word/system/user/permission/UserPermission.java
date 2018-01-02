package word.system.user.permission;

import word.system.user.User;

import java.util.*;

/**
 * 
 */
public interface UserPermission {



    /**
     * @return
     */
    public Set<User.Permission> getPermissions();

}