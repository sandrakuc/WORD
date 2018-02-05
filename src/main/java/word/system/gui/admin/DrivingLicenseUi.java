package word.system.gui.admin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.impl.GridCrud;
import word.system.pwpw.DrivingLicense;
import word.system.pwpw.DrivingLicenseRepository;
import word.system.user.User;
import word.system.user.UserRepository;

import java.util.Collection;

@SpringUI(path="/admin/driving-license-ui")
@Theme("valo")
public class DrivingLicenseUi extends UI {


    DrivingLicenseRepository drivingLicenseRepository;

    @Autowired
    public DrivingLicenseUi(DrivingLicenseRepository drivingLicenseRepository) {
        this.drivingLicenseRepository = drivingLicenseRepository;
    }

    @Override
    protected void init(VaadinRequest request) {

        GridCrud<DrivingLicense> crud = new GridCrud<>(DrivingLicense.class);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setFindAllOperation(() -> (Collection<DrivingLicense>)drivingLicenseRepository.findAll());
        crud.setAddOperation(drivingLicenseRepository::save);
        crud.setUpdateOperation(drivingLicenseRepository::save);
        crud.setDeleteOperation(drivingLicenseRepository::delete);

        final VerticalLayout layout = new VerticalLayout(crud);

        setContent(layout);
    }
}
