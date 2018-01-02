package word.system.user.permission;

import word.system.user.User;

import java.util.*;

/**
 * 
 */
abstract public class PermDecorator implements UserPermission {

    UserPermission anotherUserPerms;

    Set<User.Permission> myPerms = new HashSet<User.Permission>();

    /**
     * Default constructor
     */
    public PermDecorator(UserPermission userPerm) {

        anotherUserPerms = userPerm;
    }

    public Set<User.Permission> getMyPerms() {
        return myPerms;
    }

    /**
     * 
     */
    protected UserPermission userPerm;

    /**
     * @param perm
     */
    public void Decorator(UserPermission perm) {
        // TODO implement here
    }

    @Override
    public Set<User.Permission> getPermissions() {
        HashSet<User.Permission> permsRet =  new HashSet<User.Permission>();
        permsRet.addAll(myPerms);
        permsRet.addAll(anotherUserPerms.getPermissions());

        return permsRet;
    }
}