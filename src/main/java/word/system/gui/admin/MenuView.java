package word.system.gui.admin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class MenuView extends HorizontalLayout implements View {


    Navigator navigator;

    public MenuView(Navigator navigator) {
        this.navigator = navigator;

        addMenuItem("user");
        addMenuItem("machine");
        addMenuItem("answer");
        addMenuItem("drivingLicenseApplication");
    }

    protected void addMenuItem(String view) {
        Button btn = new Button(view);
        btn.addClickListener(new ButtonListener(view));
        addComponent(btn);
    }

    class ButtonListener implements Button.ClickListener {
        String menuitem;
        public ButtonListener(String menuitem) {
            this.menuitem = menuitem;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            navigator.navigateTo(menuitem);
            System.out.println("przekierowanie do"+ menuitem);
        }
    }


}
