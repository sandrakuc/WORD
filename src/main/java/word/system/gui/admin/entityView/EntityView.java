package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;
import org.springframework.data.repository.CrudRepository;
import org.vaadin.crudui.crud.impl.GridCrud;
import word.system.gui.admin.MenuView;

import java.util.Collection;

public class EntityView<T, K extends CrudRepository<T, Long>> extends VerticalLayout implements View {

    Navigator navigator;
    K repository;
    Class<T> tClass;

    EntityView(Navigator navigator, K repository, Class<T> tClass) {
        this.navigator = navigator;
        this.repository = repository;

        addComponent(new MenuView(navigator));


        GridCrud<T> crud = new GridCrud<T>(tClass);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setFindAllOperation(() -> (Collection<T>)repository.findAll());
        crud.setAddOperation(repository::save);
        crud.setUpdateOperation(repository::save);
        crud.setDeleteOperation(repository::delete);

        final VerticalLayout layout = new VerticalLayout(crud);

        addComponent(layout);
    }
}
