package word.system.user.wojtekTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PersonController {

    @GetMapping("person")
    public String formGet() {
        return "person";
    }

    @PostMapping("person")
    public String formPost(Person person, Model model) {
        model.addAttribute("person", person);
        System.out.println("\n\n\nDodano osobe\n" + person.getName() + "\n" + person.getSurname() + "\n Mozna by ja tu dodac do bazy\n\n\n\n");
        return "person";
    }





}
