create table WORK_SESSION (
	MAIL varchar(50),
    DATE_START timestamp,
    DURATION integer,
    STATE boolean,
    primary key (MAIL, DATE_START)
);