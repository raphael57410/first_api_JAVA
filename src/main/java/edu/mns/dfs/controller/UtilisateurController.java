package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.UtilisateurDao;
import edu.mns.dfs.model.Utilisateur;
import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilisateurController {

    UtilisateurDao utilisateurDao;
    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao){
        this.utilisateurDao = utilisateurDao;
    }

    // user by id
    @GetMapping("/utilisateur/{id}")
    @JsonView(AffichageUtilisateur.class)
    public Utilisateur utilisateur(@PathVariable int id){

        return utilisateurDao.findById(id).orElse(null);
    }

    // User delete
    @DeleteMapping ("/utilisateur/{id}")
    public String supprimeUtilisateur(@PathVariable int id){
        utilisateurDao.deleteById(id);
        return "Utilisateur supprimé !";
    }

    @GetMapping("/utilisateur-by-login/{login}")
    @JsonView(AffichageUtilisateur.class)
    public Utilisateur utilisateur(@PathVariable String login){

        return utilisateurDao.findByLogin(login).orElse(null);
    }

    // All user
    @GetMapping("/liste-utilisateur")
    @JsonView(AffichageUtilisateur.class)
    public List<Utilisateur> utilisateurs(){

        List<Utilisateur> listeUtilisateur = utilisateurDao.findAll();
        return listeUtilisateur;
    }

    // Add user
    @PostMapping("/utilisateur")
    public String ajoutUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurDao.save(utilisateur);
        return "ok";
    }
}
