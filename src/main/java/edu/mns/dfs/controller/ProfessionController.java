package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.ProfessionDao;
import edu.mns.dfs.model.Profession;
import edu.mns.dfs.view.AffichageProfession;
import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessionController {

    ProfessionDao professionDao;
    @Autowired
    public ProfessionController(ProfessionDao professionDao){
        this.professionDao = professionDao;
    }

    // user by id
    @GetMapping("/profession/{id}")
    @JsonView(AffichageProfession.class)
    public Profession profession(@PathVariable int id){

        return professionDao.findById(id).orElse(null);
    }

    // User delete
    @DeleteMapping ("/profession/{id}")
    public String supprimeProfession(@PathVariable int id){
        professionDao.deleteById(id);
        return "Profession supprimé !";
    }

    // All user
    @GetMapping("/liste-profession")
    @JsonView(AffichageProfession.class)
    public List<Profession> professions(){

        List<Profession> listeProfession = professionDao.findAll();
        return listeProfession;
    }

    // Add user
    @PostMapping("/profession")
    public String ajoutProfession(@RequestBody Profession profession){
        professionDao.save(profession);
        return "ok";
    }
}
