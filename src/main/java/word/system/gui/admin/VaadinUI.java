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
import word.system.user.User;
import word.system.user.UserRepository;

import java.util.Collection;

@SpringUI(path="/admin")
@Theme("valo")
public class VaadinUI extends UI {

    UserRepository userRepository;

    private final UserEditor editor;

    Grid<User> grid;

    final TextField filter;

    private final Button addNewBtn;

    @Autowired
    public VaadinUI(UserRepository repo, UserEditor editor) {
        this.userRepository = repo;
        this.editor = editor;
        this.grid = new Grid<>(User.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New customer", FontAwesome.PLUS);
    }

    void listUsers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems((Collection<User>) userRepository.findAll());
        }
        else {
            grid.setItems(userRepository.findByLastNameStartsWithIgnoreCase(filterText));
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
// build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "firstName", "lastName");

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listUsers(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editUser(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editUser(new User()));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listUsers(filter.getValue());
        });

        // Initialize listing
        listUsers(null);
    }
}
