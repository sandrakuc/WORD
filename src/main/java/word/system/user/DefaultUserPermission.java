package word.system.user;

import word.system.user.permission.PermDecorator;
import word.system.user.permission.UserPermission;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class DefaultUserPermission implements UserPermission {

    @Override
    public Set<User.Permission> getPermissions() {
        HashSet<User.Permission> perms = new HashSet<User.Permission>();
        perms.add(User.Permission.LOGIN);
        return perms;
    }
}