package edu.mns.dfs.controller;

import edu.mns.dfs.model.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccueilController {


    @GetMapping("/")
    public String accueil() {
        return "Le serveur marche mais ici il n'y a pas de données";
    }
}
