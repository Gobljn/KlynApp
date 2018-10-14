create table USER (
	ID int not null auto_increment primary key,
    NOME varchar(20),
    COGNOME varchar(20),
    DATA_NASCITA date,
    SESSO char(1),
    NUMERO_TELEFONO int,
    MAIL varchar(40),
    OCCUPAZIONE varchar(20),
    ZONA varchar(30),
    RUOLO char(1)
    );
    
