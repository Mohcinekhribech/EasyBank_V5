\c easybank_V4;
-- create numuretation
create type creditetat as enum('en_attente','accepte','refuse');


CREATE TABLE personne (
                          nom varchar(50) not null,
                          prenom varchar(50) not null,
                          dateNaissance date not null,
                          telephone varchar(50) not null
);

CREATE TABLE client (
                        code varchar(20) primary key,
                        adresse varchar(50) not null
) INHERITS (Personne);


CREATE TABLE employe (
                         matricule varchar(20) primary key ,
                         dateDeRecrutement date not null,
                         adresseEmail varchar(50) not null
) INHERITS (Personne);

create TABLE account (
                         accountNumber serial primary key ,
                         balance float not null,
                         creationdate date not null,
                         client_code varchar(20) not null,
                         status status not null,
                         foreign key (client_code) references client(code)


);
create TABLE credit (
                        numero serial primary key ,
                        code varchar(20) not null,
                        montant numeric(10,2) not null,
                        mois int not null,
                        etat creditetat not null,
                        remarques varchar(50) not null,
                        date date not null,
                        foreign key (code) references client(code)


);
create TABLE historical
(
    id serial primary key,
    numero_credit int not null,
    description varchar(50) not null,
    foreign key (numero_credit) references credit(numero)
)

