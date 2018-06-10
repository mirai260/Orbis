create table admin (
  id_admin                      bigint auto_increment not null,
  login                         varchar(255),
  mdp                           varchar(255),
  constraint pk_admin primary key (id_admin)
);

create table concept (
  id_concept                    bigint auto_increment not null,
  nom                           varchar(255),
  constraint pk_concept primary key (id_concept)
);

create table concept_parcours (
  id_concept_parcours           bigint auto_increment not null,
  id_concept                    bigint,
  id_parcours                   bigint,
  constraint pk_concept_parcours primary key (id_concept_parcours)
);

create table domaine (
  id_domaine                    bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_domaine primary key (id_domaine)
);

create table eleve (
  id_eleve                      bigint auto_increment not null,
  login                         varchar(255),
  mdp                           varchar(255),
  constraint pk_eleve primary key (id_eleve)
);

create table metier (
  id_metier                     bigint auto_increment not null,
  nom                           varchar(255),
  description                   varchar(255),
  constraint pk_metier primary key (id_metier)
);

create table metier_domaine (
  id_metier_domaine             bigint auto_increment not null,
  id_metier                     bigint,
  id_domaine                    bigint,
  constraint pk_metier_domaine primary key (id_metier_domaine)
);

create table metier_parcours (
  id_metier_parcours            bigint auto_increment not null,
  id_metier                     bigint,
  id_parcours                   bigint,
  constraint pk_metier_parcours primary key (id_metier_parcours)
);

create table parcours (
  id_parcours                   bigint auto_increment not null,
  nom                           varchar(255),
  description                   varchar(255),
  constraint pk_parcours primary key (id_parcours)
);

create table prerequis (
  id_prerequis                  bigint auto_increment not null,
  nom                           varchar(255),
  description                   varchar(255),
  niveau                        varchar(255),
  note                          varchar(255),
  constraint pk_prerequis primary key (id_prerequis)
);

create table prerequis_parcours (
  id_prerequis_parcours         bigint auto_increment not null,
  id_prerequis                  bigint,
  id_parcours                   bigint,
  constraint pk_prerequis_parcours primary key (id_prerequis_parcours)
);

create table professeur (
  id_professeur                 bigint auto_increment not null,
  login                         varchar(255),
  mdp                           varchar(255),
  constraint pk_professeur primary key (id_professeur)
);

