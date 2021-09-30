package thymeleaf.jorgen.workshop_thymeleaf.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> strings = new ArrayList<>();

    public Home(){

    }

    @GetMapping("/index")
    public String index(){

        return "index" ;
    }

    @GetMapping("/contact")

    public String contact(Model model){
        model.addAttribute("strings", strings);

        return "contact";

    }

    @PostMapping("/contact/add")
    public String process(@RequestParam (name="name") String input){
        strings.add(input);
        return "redirect:/contact";
    }

    @GetMapping
    public String about(){

        return null;
    }


}
