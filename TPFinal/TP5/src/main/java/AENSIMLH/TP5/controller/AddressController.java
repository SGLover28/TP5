package AENSIMLH.TP5.controller;

import AENSIMLH.TP5.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller demandé en Etape 22 TP1, permet de voir l'ensemble des adresses enregistrées dans la base de donnée
//J'ai ajouté la possibilité d'accéder à la page météo à partir des addresse déjà enregistrées

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    String nom;


    @GetMapping("/addresse")
    public String showAddresses(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll ());
        model.addAttribute("nom", nom);
        return "addresses";
    }

}
