INSERT INTO profession (nom) VALUES ("developpeur"),("comptable"),("pdg");

INSERT INTO utilisateur (login,password,profession_id) VALUES ("franck","root",3),("admin","root",1);

INSERT INTO competence (nom) VALUES ("JAVA"),("PHP"),("Excel");

INSERT INTO competence_utilisateur (utilisateur_id, competence_id) VALUES (1,1),(1,2),(2,1),(2,3);