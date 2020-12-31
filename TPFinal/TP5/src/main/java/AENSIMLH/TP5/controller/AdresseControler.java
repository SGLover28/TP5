package AENSIMLH.TP5.controller;


import AENSIMLH.TP5.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//2nd TP étape 1, j'ai ajouté un nouveau controller/template

@Controller
public class AdresseControler {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    String nom;

    @GetMapping("/adresse")
    public void ajoutAdress(Model model) {

        model.addAttribute("nom", nom);
    }


}
