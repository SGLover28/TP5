package AENSIMLH.TP5.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Je me suis permis de transformer cette page en page d'acceuil, accessible via la nav bar demandée en étape 27

@Controller
public class HelloWorldController {



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="nameGET", required=false, defaultValue="World") String nameGET, Model model) {
        model.addAttribute("nomTemplate", nameGET);


        return "greeting";
    }



}
