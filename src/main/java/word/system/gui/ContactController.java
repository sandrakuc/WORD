package word.system.gui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

    @RequestMapping("contact")
    public String contact(HttpServletRequest request) {

        return "contact";
    }
}
