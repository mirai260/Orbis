create table admin (
  id_admin                      bigint auto_increment not null,
  login                         varchar(255),
  mdp                           varchar(255),
  constraint pk_admin primary key (id_admin)
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

create table parcours (
  id_parcours                   bigint auto_increment not null,
  parcours                      varchar(255),
  description                   varchar(255),
  constraint pk_parcours primary key (id_parcours)
);

create table prerequis (
  id_parcours                   bigint auto_increment not null,
  parcours                      varchar(255),
  description                   varchar(255),
  constraint pk_prerequis primary key (id_parcours)
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

