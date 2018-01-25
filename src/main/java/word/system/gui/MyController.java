package word.system.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Controller
public class MyController {



    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        return "index";
    }

}
