package word.system.user.permission;

import word.system.user.User;

/**
 * 
 */
public class TeoreticalExaminerPermissionPermDecorator extends PermDecorator {


    /**
     * Default constructor
     *
     * @param userPerm
     */
    public TeoreticalExaminerPermissionPermDecorator(PermDecorator userPerm) {
        super(userPerm);
        this.myPerms.add(User.Permission.TEORETICAL_EXAMINER);
    }
}