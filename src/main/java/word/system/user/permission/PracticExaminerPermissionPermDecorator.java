package word.system.user.permission;

import word.system.user.User;

/**
 * 
 */
public class PracticExaminerPermissionPermDecorator extends PermDecorator {


    /**
     * Default constructor
     *
     * @param userPerm
     */
    public PracticExaminerPermissionPermDecorator(PermDecorator userPerm) {
        super(userPerm);
        this.myPerms.add(User.Permission.PRACTIC_EXAMINER);
    }
}