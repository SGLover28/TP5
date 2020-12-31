package AENSIMLH.TP5.controller;


import AENSIMLH.TP5.model.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;


@Controller
public class meteoController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    Coordinates coordinates;

    @Autowired
    String nom;


@PostMapping("/meteo")
    public String AfficherMeteo(@RequestParam(value = "auteur", required = false, defaultValue = "default") String auteur, @RequestParam("content") String content, Model model) throws IOException {

    Address add;

//on regarde si la page vient d'être chargées via une nouvelle adresse ou une pre-enregistrée
    if(!auteur.contains("default")) {
        add = creaaddresse(auteur, content, true);
        nom = auteur;
    }else{
        String aut = addressRepository.trouverAuteur(content);
        
        add = creaaddresse(aut, content, false);
    }

     model.addAttribute("content", content);

//recherche de coordonées

        String urlDeLAdresseMeteo = "https://api-adresse.data.gouv.fr/search/?q=+" + add.getContent().replaceAll(" ", "+");

         System.out.println(urlDeLAdresseMeteo);

        URL url = new URL(urlDeLAdresseMeteo);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        JsonArray features = rootobj.get("features").getAsJsonArray();
        JsonObject cntFt = features.get(0).getAsJsonObject();
        JsonObject geo = cntFt.get("geometry").getAsJsonObject();
        JsonArray coordinatesA = geo.get("coordinates").getAsJsonArray();
        coordinates.setY(coordinatesA.get(0).getAsFloat());
        coordinates.setX(coordinatesA.get(1).getAsFloat());

        System.out.println(coordinates.toString());

//recherche de météo

    String urlDeMeteo = "https://api.openweathermap.org/data/2.5/weather?lat="+coordinates.getX()+"&lon="+coordinates.getY()+"&appid=514923569cc6ded076bce2351601000b&units=metric";
    System.out.println(urlDeMeteo);
    URL urlM = new URL(urlDeMeteo);
    URLConnection requestM = urlM.openConnection();
    requestM.connect();
    JsonParser jpM = new JsonParser();
    JsonElement rootM = jpM.parse(new InputStreamReader((InputStream) requestM.getContent()));
    JsonObject rootobjM = rootM.getAsJsonObject();
    //JsonArray weather = rootobjM.get("weather").getAsJsonArray();
    String desc = rootobjM.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
    String main = rootobjM.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString();
    System.out.println(desc);

    model.addAttribute("description", desc);
    model.addAttribute("main", main);

    String temp = rootobjM.get("main").getAsJsonObject().get("temp").getAsString();
    String fell = rootobjM.get("main").getAsJsonObject().get("feels_like").getAsString();

    model.addAttribute("temp", temp);
    model.addAttribute("ressenti", fell);

        model.addAttribute("coordinateX", coordinates.getX());

        model.addAttribute("coordinateY", coordinates.getY());
    model.addAttribute("nom", nom);

return "meteo";

}





 private void ajouterAuRepo(Address add){
    addressRepository.ajouter(add.getId(), add.getAuteur(), add.getContent(), add.getCreation());
 }


private Address creaaddresse(String auteur, String content, boolean estAEnregistrer) {
    Address add = new Address();
    add.setAuteur(auteur);
    add.setContent(content);
    add.setCreation(new Date());

    add.setId(addressRepository.compterLesAdresses() + 1);

    //on ajoute l'adresse si elle vient d'être demandée
    if(estAEnregistrer) {
        ajouterAuRepo(add);
    }
    return add;
    }
}