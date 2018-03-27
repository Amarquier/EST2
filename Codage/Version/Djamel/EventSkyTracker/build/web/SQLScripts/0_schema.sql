# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------
#                   Base de données skytracker - Mars 2017
# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------    

drop schema if exists skytracker;
create schema skytracker;
use skytracker;

# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------
#           Les tables fournies et modifiées par Klotz (TAROT)
# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------

# --------------------------------------------------------------
#                   Table des évènements
# --------------------------------------------------------------
create table evenement (
    `id`            integer not null auto_increment primary key,
    `idOfficiel`    varchar(30) not null,       # id officiel de l'évènement
    `telescope`     varchar(100) not null,       # CALERN, CHILI, etc...
    `chemin`        varchar(100) not null,
    `type`          varchar(10) not null,
    `date`          timestamp not null,
    `nouveau`       boolean not null default true # default vrai 
) engine=InnoDB character set utf8;

# --------------------------------------------------------------
#           Table des candidates pour un évènement donné
# --------------------------------------------------------------
create table candidate (
    `id`            integer not null auto_increment primary key,
    `eventId`       integer not null,           # clef étrangère sur evenement
    `chemin`        varchar(100) not null,
    `ra`            double not null,
    `dec`           double not null,

    index fkCan01 (`eventId`), 
    constraint fkCan01 foreign key (`eventId`) references evenement (`id`)

) engine=InnoDB character set utf8;

# --------------------------------------------------------------
#           Table des images pour une candidate donnée
# --------------------------------------------------------------
create table image (
    `id`            integer not null auto_increment primary key,
    `canId`         integer not null,            # clef étrangère sur candidate
    `chemin`        varchar(100) not null,
    `dateobs`       datetime not null,
    `crpix1`        double not null,
    `crpix2`        double not null,
    `crval1`        double not null,
    `crval2`        double not null,
    `cdelt1`        double not null,
    `cdelt2`        double not null,
    `crota2`        double not null,
    `ra`            double not null,
    `dec`           double not null,

    index fkImage01 (`canId`), 
    constraint fkImage01 foreign key (`canId`) references candidate (`id`)
) engine=InnoDB character set utf8;

# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------
#                       Nos tables pour eventSkyTracker
# ------------------------------------------------------------------------------
# ------------------------------------------------------------------------------

# --------------------------------------------------------------
#                   Table des utilisateurs
# --------------------------------------------------------------
create table user (
    `pseudo`        varchar(30) not null primary key, 
    `username`      varchar(100) not null,  
  # deux users ne peuvent pas avoir le même email
    `email`         varchar(255) not null unique, 
    `password`      varchar(200) not null,
  # ce champ sert pour user.create() à stocker la clef de confirmation du mail
  # une fois que le mail est confirmé, il stocke 'OK'
    `mailconfirme`  varchar(20) not null default "NO",
  # attention après suppression des anciens events et de ses candidats
  # remettre les deux clefs à 0

  # on incrémente le suivant modulo le nombre total de candidates
  # le premier candidat est généré de manière aléatoire
    `lastCan`       integer,                # clef étrangère sur candidate
                                            # peut être null
    `grade`         integer not null default 1, 
    `blocked`       boolean not null default 0,         # default faux 
    `registerDate`  datetime not null,  
    `lastVisitDate` datetime not null,
    `nbQualifications` integer not null default 0,
    `nbConnexions`  integer not null default 0
) engine=InnoDB character set utf8;

# --------------------------------------------------------------
#               Table des demandes de qualification
# --------------------------------------------------------------
create table qualification (
    `userPseudo` varchar(30) not null,
    `canId`      int not null,              # clef étrangère sur candidate
                                            # date de la qualification
    `date`       timestamp not null     default CURRENT_TIMESTAMP 
                                        on update CURRENT_TIMESTAMP,
    `x`          integer not null,          # la position de l'identification
    `y`          integer not null,          # lumineuse (le centre par défaut)
    `questionnaire`   text not null,             # reponse au questionnaire 

    # un user ne peut déposer qu'une fois une même proposition par candidate
    primary key (`userPseudo`, `canId`),

    index fkQualificationtion01 (`canId`), 
    constraint fkQualificationtion01 foreign key (`canId`) references candidate (`id`)
) engine=InnoDB character set utf8;

# --------------------------------------------------------------
#                       Table des actualités
# --------------------------------------------------------------
create table actu (
    `id`            integer not null auto_increment primary key,
    `date`          varchar(10) not null,
    `titre`         text not null,
    `contenu`       text not null
) engine=InnoDB character set utf8;
