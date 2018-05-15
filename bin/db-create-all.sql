create table excluded_food (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_excluded_food primary key (id)
);

create table language (
  id                            bigint auto_increment not null,
  code                          varchar(255),
  language                      varchar(255),
  translation_status            tinyint(1) default 0,
  constraint pk_language primary key (id)
);

create table meal (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  price                         double,
  ingredients                   varchar(255),
  images                        varchar(255),
  constraint pk_meal primary key (id)
);

create table meal_availability (
  id                            bigint auto_increment not null,
  restaurant_id                 bigint,
  meal_id                       bigint,
  available                     tinyint(1) default 0,
  constraint pk_meal_availability primary key (id)
);

create table restaurant (
  id                            bigint auto_increment not null,
  geolocation                   varchar(255),
  owner_id                      bigint,
  address                       varchar(255),
  name                          varchar(255),
  type                          varchar(255),
  constraint pk_restaurant primary key (id)
);

create table special_diet (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_special_diet primary key (id)
);

create table text (
  id                            bigint auto_increment not null,
  code                          varchar(255),
  language                      varchar(255),
  text                          varchar(255),
  constraint pk_text primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  admin                         tinyint(1) default 0,
  email                         varchar(255),
  password                      varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  gender                        varchar(255),
  birthdate                     varchar(255),
  address                       varchar(255),
  preferences                   varchar(255),
  phone                         varchar(255),
  height                        varchar(255),
  weight                        varchar(255),
  special_diets                 varchar(255),
  excluded_foods                varchar(255),
  spoken_languages              varchar(255),
  constraint pk_user primary key (id)
);

