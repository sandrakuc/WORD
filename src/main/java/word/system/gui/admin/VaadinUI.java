package word.system.gui.admin;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.vaadin.crudui.crud.impl.GridCrud;
import word.system.user.User;
import word.system.user.UserRepository;

import java.util.Collection;

@SpringUI(path="/admin")
@Theme("valo")
public class VaadinUI extends UI {

    UserRepository userRepository;

    @Autowired
    public VaadinUI(UserRepository repo, UserEditor editor) {
        this.userRepository = repo;
    }

    @Override
    protected void init(VaadinRequest request) {

        GridCrud<User> crud = new GridCrud<>(User.class);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setFindAllOperation(() -> (Collection<User>)userRepository.findAll());
        crud.setAddOperation(userRepository::save);
        crud.setUpdateOperation(userRepository::save);
        crud.setDeleteOperation(userRepository::delete);

        final VerticalLayout layout = new VerticalLayout(crud);

        setContent(layout);
    }
}
