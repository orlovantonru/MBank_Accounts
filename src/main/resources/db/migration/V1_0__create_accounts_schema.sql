CREATE TABLE public.accounts (
                                 id serial
                                     constraint table__pk
                                         primary key,
                                 accountNumber varchar(20) NOT NULL,
                                 accountDate date NULL,
                                 userId int4 NULL,
                                 percent float NULL,
                                 saldo float NULL

);







