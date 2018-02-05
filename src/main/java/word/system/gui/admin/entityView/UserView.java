package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.crudui.crud.impl.GridCrud;
import word.system.gui.admin.MenuView;
import word.system.user.User;
import word.system.user.UserRepository;

import java.util.Collection;

public class UserView extends EntityView<User, UserRepository> {


    public UserView(Navigator navigator, UserRepository repository, Class<User> userClass) {
        super(navigator, repository, userClass);
    }
}
