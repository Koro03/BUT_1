DROP SCHEMA programme_but CASCADE;
CREATE SCHEMA programme_but;
SET SCHEMA 'programme_but';

CREATE TABLE _competences(
  lib_competence VARCHAR(20) PRIMARY KEY
); 

CREATE TABLE _activite(
  lib_activite VARCHAR(20),
  lib_competence VARCHAR(20),
  CONSTRAINT activite_pk PRIMARY KEY (lib_activite)
);
CREATE TABLE _semestre(
  numero_sem VARCHAR(20),
  numero_n INTEGER,
  CONSTRAINT numero_sem PRIMARY KEY (numero_sem)
);

CREATE TABLE _ue (
  code_ue VARCHAR(20),
  lib_activite VARCHAR(20),
  numero_sem VARCHAR(20),
  CONSTRAINT ue_pk PRIMARY KEY (code_ue)
);
CREATE TABLE _sae (
  code_sae VARCHAR(20),
  lib_sae VARCHAR(20),
  nb_h_td_enc INTEGER,
  nb_h_td_projet_autonomie INTEGER,
  CONSTRAINT sae_pk PRIMARY KEY (code_sae) 
);
CREATE TABLE _ressources (
	code_r VARCHAR(20),
	lib_r VARCHAR(20),
	nb_h_CM_PN INTEGER,
	nb_h_TD_PN INTEGER,
	nb_h_TP_PN INTEGER,
	numero_semestre VARCHAR(20),
	CONSTRAINT ressources_pk PRIMARY KEY (code_r)

);

CREATE TABLE _parcours (
	code_p VARCHAR(20),
	libelle_parcours VARCHAR(20),
	nbre_gpe_TD_P INTEGER,
	nbre_gpe_TP_P INTEGER,
	CONSTRAINT parcours_pk PRIMARY KEY (code_p)
);
CREATE TABLE _niveau(
	numero_n INTEGER PRIMARY KEY
);

CREATE TABLE _comprend_r (
	code_r VARCHAR(20),
	code_sae VARCHAR(20),
	nb_h_td INTEGER,
	nb_h_tp INTEGER,
	CONSTRAINT comprend_r_pk PRIMARY KEY (code_r,code_sae),
	CONSTRAINT comprend_r_fk1 FOREIGN KEY (code_r) REFERENCES  _ressources(code_r),
  CONSTRAINT comprend_r_fk2 FOREIGN KEY (code_sae) REFERENCES  _sae(code_sae)
);

CREATE TABLE _est_enseignee (
	code_r VARCHAR(20),
	code_p VARCHAR(20),
	CONSTRAINT  est_enseignee_pk PRIMARY KEY (code_r,code_p)
);

CREATE TABLE _correspond(
	 code_p VARCHAR(20),
	 lib_activite VARCHAR(20),
	 numero_n INTEGER,
	CONSTRAINT  correspond_pk PRIMARY KEY (code_p,lib_activite,numero_n),
	CONSTRAINT  correspond_fk1 FOREIGN KEY (code_p) REFERENCES _parcours (code_p),
	CONSTRAINT  correspond_fk2 FOREIGN KEY (lib_activite) REFERENCES _activite (lib_activite),
	CONSTRAINT  correspond_fk3 FOREIGN KEY (numero_n) REFERENCES _niveau(numero_n)
);
 

ALTER TABLE _activite ADD CONSTRAINT competences_fk FOREIGN KEY(lib_competence) REFERENCES _competences(lib_competence);

ALTER TABLE _semestre ADD CONSTRAINT semestre FOREIGN KEY (numero_n) REFERENCES niveau (numero_n) 
  
ALTER TABLE _ue ADD CONSTRAINT activite_fk FOREIGN KEY (lib_act) REFERENCES activite(lib_act),
ALTER TABLE _ue ADD CONSTRAINT semestre_fk FOREIGN KEY (numero_sem) REFERENCES semestre(numero_sem)

ALTER TABLE _ressources ADD CONSTRAINT  ressources_fk FOREIGN KEY (numero_semestre) REFERENCES semestre (numero_semestre)

