CREATE TABLE public.accounts (
                                 idaccount int4 NOT NULL,
                                 numaccount varchar NOT NULL,
                                 dateaccount date NULL,
                                 iduser int4 NULL,
                                 CONSTRAINT accounts_pk PRIMARY KEY (idaccount)
);
CREATE INDEX accounts_idaccount_idx ON public.accounts USING btree (idaccount);





