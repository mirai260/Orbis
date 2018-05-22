

DROP TABLE IF EXISTS Eleve;
CREATE TABLE Eleve
(
  idEleve LONG,
  login VARCHAR(255),
  mdp VARCHAR(255)
);


DROP TABLE IF EXISTS Admin;
CREATE TABLE Admin
(
  idAdmin LONG,
  login VARCHAR(255),
  mdp VARCHAR(255)
);


DROP TABLE IF EXISTS Professeur;
CREATE TABLE Professeur
(
  idProfesseur LONG,
  login VARCHAR(255),
  mdp VARCHAR(255)
);


DROP TABLE IF EXISTS Parcours;
CREATE TABLE Parcours
(
  idParcours LONG,
  parcours VARCHAR(255),
  description VARCHAR(255)
);


DROP TABLE IF EXISTS PrerequisParcours;
CREATE TABLE PrerequisParcours
(
  idParcours LONG,
  idPrerequis LONG
);
DROP TABLE IF EXISTS Prerequis;
CREATE TABLE Prerequis
(
  idPrerequis LONG,
  nom VARCHAR(255),
  note VARCHAR(255),
  niveau VARCHAR(255),
  description VARCHAR(255)
);



DROP TABLE IF EXISTS Metier;
CREATE TABLE Metier
(
  idMetier LONG,
  nom VARCHAR(255),
  description VARCHAR(255),
  domaine VARCHAR(255)
);

DROP TABLE IF EXISTS Domaine;
CREATE TABLE Domaine
(
  idDomaine LONG,
  domaine VARCHAR(255)
);

DROP TABLE IF EXISTS Concept;
CREATE TABLE Concept
(
  idConcept LONG,
  concept VARCHAR(255)
);

DROP TABLE IF EXISTS ModuleComplementaire;
CREATE TABLE ModuleComplementaire
(
  idModule LONG,
  nom VARCHAR(255),
  description VARCHAR(255),
  lienFicheModule VARCHAR(255)
);



