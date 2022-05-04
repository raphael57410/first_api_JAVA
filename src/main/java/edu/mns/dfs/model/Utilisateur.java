package edu.mns.dfs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageProfession;
import edu.mns.dfs.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Utilisateur {

    @Id
    // auto généré l'id dans la base de donnée
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // filtre qu'on utilise pour filtrer les données que l'on veut envoyer a la "vue"
    @JsonView({AffichageUtilisateur.class,AffichageProfession.class})
    private Integer id;

    @JsonView({AffichageUtilisateur.class,AffichageProfession.class})
    private String login;

    private String password;

    @ManyToOne
    @JsonView(AffichageUtilisateur.class)
    private Profession profession;

    @ManyToMany
    @JoinTable(name="competence_utilisateur",joinColumns = @JoinColumn(name= "utilisateur_id"),inverseJoinColumns = @JoinColumn(name = "competence_id"))
    @JsonView(AffichageUtilisateur.class)
    private List<Competence> listeCompetence;
}
