package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.carfactory.Machine;
import word.system.carfactory.MachineRepository;
import word.system.user.User;
import word.system.user.UserRepository;

public class MachineView extends EntityView<Machine, MachineRepository> {

    public MachineView(Navigator navigator, MachineRepository repository, Class<Machine> machineClass) {
        super(navigator, repository, machineClass);
    }

}

