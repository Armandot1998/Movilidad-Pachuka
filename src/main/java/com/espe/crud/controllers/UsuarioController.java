package com.espe.crud.controllers;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.espe.crud.model.Persona;
import com.espe.crud.model.UsuarioDocente;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {
	
    public static final Logger logger= LoggerFactory.getLogger(añosController.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/findbyPIDM/{id}")
	public List<UsuarioDocente> findbyPIDM3(@PathVariable Long id) throws SQLException{
		String q = "SELECT DISTINCT pebempl.pebempl_PIDM AS PAR_PIDM,\r\n" + 
				"    (SELECT MAX(spriden_ID) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS ID_BANNER,\r\n" + 
				"    (SELECT  MAX(spbpers_SSN) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)) as NUMERO_DOCUMENTO,\r\n" + 
				"     (SELECT MAX(spriden_LAST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS APELLIDO,\r\n" + 
				"    (SELECT MAX(spriden_FIRST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS NOMBRES,\r\n" + 
				"    (SELECT  MAX(SPBPERS_BIRTH_DATE) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS FECHA_NACIMIENTO,\r\n" + 
				"    (SELECT  MAX((SELECT MAX(stvcitz_desc) FROM STVCITZ WHERE stvcitz_code = SPBPERS_CITZ_CODE)) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS NACIONALIDAD,\r\n" + 
				"    (SELECT SPBPERS_SEX FROM SPBPERS WHERE (spbpers_pidm = pebempl.pebempl_PIDM) ) AS SEXO,\r\n" + 
				"    (SELECT MAX(GOREMAL_EMAIL_ADDRESS) from GOREMAL WHERE GOREMAL_PIDM = PEBEMPL_PIDM AND GOREMAL_EMAL_CODE = 'STAN' AND GOREMAL_PREFERRED_IND = 'Y') AS CORREO_INSTITUCIONAL ,\r\n" + 
				"    (SELECT MAX(GOREMAL_EMAIL_ADDRESS) from GOREMAL WHERE GOREMAL_PIDM = PEBEMPL_PIDM AND GOREMAL_EMAL_CODE = 'PERS'  AND goremal_status_ind = 'A' AND goremal_activity_date =   (SELECT MAX(goremal_activity_date) from GOREMAL WHERE GOREMAL_PIDM = PEBEMPL_PIDM AND GOREMAL_EMAL_CODE = 'PERS'   AND goremal_status_ind = 'A' )) AS CORREO_PERSONAL,\r\n" + 
				"PEBEMPL_FIRST_HIRE_DATE as FECHA_ORIGINAL,\r\n" + 
				"(SELECT FTVORGN_TITLE FROM FTVORGN WHERE FTVORGN_ORGN_CODE = PEBEMPL_ORGN_CODE_HOME) AS SECCION,\r\n" + 
				"(SELECT PTRJBLN_DESC FROM PTRJBLN WHERE PTRJBLN_CODE = PEBEMPL_JBLN_CODE) AS UBICACION,\r\n" + 
				"(SELECT STVCOLL_DESC FROM STVCOLL WHERE STVCOLL_CODE = PEBEMPL_COLL_CODE)as DEPARTAMENTO,\r\n" + 
				"(SELECT STVCAMP_DESC FROM STVCAMP WHERE STVCAMP_CODE = PEBEMPL_CAMP_CODE)as CAMPUS,\r\n" + 
				"\r\n" + 
				"( SELECT  (select PTVEGRP_DESC from payroll.PTVEGRP WHERE PTVEGRP_CODE = pebempl_EGRP_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM\r\n" + 
				") AS RELACION_LABORAL,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"CASE pebempl_bcat_code\r\n" + 
				"WHEN 'DO' THEN ( SELECT  (SELECT PTRECLS_LONG_DESC FROM PTRECLS  WHERE PTRECLS_CODE = pebempl.PEBEMPL_ECLS_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM )\r\n" + 
				"WHEN 'SP' THEN 'TIEMPO PARCIAL'\r\n" + 
				"END  AS DEDICACION,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"(SELECT DISTINCT\r\n" + 
				"(select max(ptrtenr_desc)  from PTRTENR where ptrtenr_code= PERAPPT_TENURE_CODE ) as CATEGORIA_ESCALAFON\r\n" + 
				"FROM PEBEMPL r, PERAPPT\r\n" + 
				"WHERE\r\n" + 
				"r.pebempl_PIDM = PERAPPT.PERAPPT_PIDM\r\n" + 
				"AND r.pebempl_empl_status = 'A'\r\n" + 
				"--AND( r.pebempl_bcat_code = 'DO' )\r\n" + 
				"AND r.pebempl_PIDM = pebempl.pebempl_PIDM\r\n" + 
				"AND (r.pebempl_bcat_code = 'DO' or r.pebempl_bcat_code = 'SP' ) AND\r\n" + 
				"    r.pebempl_empl_status = (SELECT MAX(NBRJOBS_STATUS) FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM\r\n" + 
				"    AND (nbrjobs_pict_code = 'ED' or nbrjobs_pict_code = 'LD' )   AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"    FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM AND   (nbrjobs_pict_code = 'ED'\r\n" + 
				"    or nbrjobs_pict_code = 'LD' )))\r\n" + 
				"AND PERAPPT_APPT_EFF_DATE =     (select MAX(PERAPPT_APPT_EFF_DATE)  from PERAPPT WHERE PERAPPT_PIDM = pebempl.pebempl_PIDM)\r\n" + 
				") AS TIPO_ACADEMICO,\r\n" + 
				"\r\n" + 
				"(SELECT PTRECLS_LONG_DESC FROM PTRECLS WHERE PTRECLS_CODE = pebempl_ECLS_CODE) AS TIPO_FM,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  NVL (( SELECT DISTINCT nbrjobs_DESC\r\n" + 
				"  FROM NBRJOBS\r\n" + 
				"       WHERE (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') AND\r\n" + 
				"       NBRJOBS_pidm = pebempl.pebempl_PIDM\r\n" + 
				"       )\r\n" + 
				"        AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"        FROM NBRJOBS where NBRJOBS_pidm = pebempl.pebempl_PIDM AND (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') ))\r\n" + 
				"       ),0) AS DESC_PUESTO\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    FROM PEBEMPL,\r\n" + 
				"   SISEAC.SEG_USUARIO\r\n" + 
				"\r\n" + 
				"     WHERE PEBEMPL_PIDM = "+ id +"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"and\r\n" + 
				"  (select nbrbjob_contract_type from nbrbjob  where nbrbjob_pidm = pebempl.pebempl_PIDM and  nbrbjob_posn =\r\n" + 
				"\r\n" + 
				"( SELECT DISTINCT nbrjobs_posn FROM NBRJOBS WHERE (nbrjobs_pict_code IN ('ED','LD') AND NBRJOBS_pidm = pebempl.pebempl_PIDM )\r\n" + 
				"AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date) FROM NBRJOBS where NBRJOBS_pidm = pebempl.pebempl_PIDM AND (nbrjobs_pict_code IN ('ED','LD') )))\r\n" + 
				"and nbrbjob_end_date is null) in ('S','P')";
	System.out.println(q);
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<>(UsuarioDocente.class));
	}
	
	@GetMapping("persona/findbyID/{id}")
	public List<Persona> findbyID(@PathVariable Long id) throws SQLException{
		String q = "SELECT DISTINCT pebempl.pebempl_PIDM AS PAR_PIDM,\r\n" + 
				"    (SELECT MAX(spriden_ID) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS ID_BANNER,\r\n" + 
				"    (SELECT  MAX(spbpers_SSN) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)) as NUMERO_DOCUMENTO,\r\n" + 
				"    (SELECT MAX(spriden_LAST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS APELLIDO,\r\n" + 
				"    (SELECT MAX(spriden_FIRST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS NOMBRES,\r\n" + 
				"    (SELECT  MAX(SPBPERS_NAME_PREFIX)  FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)) as PREFIJO,\r\n" + 
				"    (SELECT  MAX(SPBPERS_BIRTH_DATE) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS FECHA_NACIMIENTO,\r\n" + 
				"    (SELECT  MAX((SELECT MAX(stvcitz_desc) FROM STVCITZ WHERE stvcitz_code = SPBPERS_CITZ_CODE)) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS NACIONALIDAD,\r\n" + 
				"    (SELECT SPBPERS_SEX FROM SPBPERS WHERE (spbpers_pidm = pebempl.pebempl_PIDM) ) AS SEXO,\r\n" + 
				"    (SELECT (select substr(MAX(gorrace_desc),15,10) from gorrace where gorrace_race_cde=GORPRAC_RACE_CDE) FROM  GORPRAC WHERE (GORPRAC_PIDM =pebempl.pebempl_PIDM) and GORPRAC_RACE_CDE in ('1','2','3','4','5','6','7','8')) AS TIPO_SANGRE,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" CASE\r\n" + 
				"( select MAX(GOVSDAV_VALUE_AS_CHAR)  from  GOVSDAV\r\n" + 
				"  WHERE GOVSDAV_TABLE_NAME = 'PDRBENE' AND GOVSDAV_ATTR_NAME = 'TIPO_DISCAPACIDAD'\r\n" + 
				"  and govsdav_pk_parenttab like pebempl.pebempl_PIDM  || '%' || '1' )\r\n" + 
				"WHEN '1' THEN 'AUDITIVA'\r\n" + 
				"WHEN '2' THEN 'FISICA'\r\n" + 
				"WHEN '3' THEN 'INTELECTUAL'\r\n" + 
				"WHEN '4' THEN 'VISUAL'\r\n" + 
				"END AS TIPO_DISC,\r\n" + 
				"    \r\n" + 
				" pebempl_bcat_code  AS TIPO_EMPLEADO,\r\n" + 
				" pebempl_empl_status AS STATUS,\r\n" + 
				"(SELECT FTVORGN_TITLE FROM FTVORGN WHERE FTVORGN_ORGN_CODE = PEBEMPL_ORGN_CODE_HOME) AS SECCION,\r\n" + 
				"(SELECT PTRJBLN_DESC FROM PTRJBLN WHERE PTRJBLN_CODE = PEBEMPL_JBLN_CODE) AS UBICACION,\r\n" + 
				"(SELECT STVCOLL_DESC FROM STVCOLL WHERE STVCOLL_CODE = PEBEMPL_COLL_CODE)as DEPARTAMENTO,\r\n" + 
				"(SELECT STVCAMP_DESC FROM STVCAMP WHERE STVCAMP_CODE = PEBEMPL_CAMP_CODE)as CAMPUS,\r\n" + 
				"\r\n" + 
				"( SELECT  (select PTVEGRP_DESC from payroll.PTVEGRP WHERE PTVEGRP_CODE = pebempl_EGRP_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM\r\n" + 
				") AS RELACION_LABORAL,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"CASE pebempl_bcat_code\r\n" + 
				"WHEN 'DO' THEN ( SELECT  (SELECT PTRECLS_LONG_DESC FROM PTRECLS  WHERE PTRECLS_CODE = pebempl.PEBEMPL_ECLS_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM )\r\n" + 
				"WHEN 'SP' THEN 'ADMINISTRATIVO'\r\n" + 
				"END  AS DEDICACION,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"(SELECT DISTINCT\r\n" + 
				"(select max(ptrtenr_desc)  from PTRTENR where ptrtenr_code= PERAPPT_TENURE_CODE ) as CATEGORIA_ESCALAFON\r\n" + 
				"FROM PEBEMPL r, PERAPPT\r\n" + 
				"WHERE\r\n" + 
				"r.pebempl_PIDM = PERAPPT.PERAPPT_PIDM\r\n" + 
				"AND r.pebempl_empl_status = 'A'\r\n" + 
				"--AND( r.pebempl_bcat_code = 'DO' )\r\n" + 
				"AND r.pebempl_PIDM = pebempl.pebempl_PIDM\r\n" + 
				"AND (r.pebempl_bcat_code = 'DO' or r.pebempl_bcat_code = 'SP' ) AND\r\n" + 
				"    r.pebempl_empl_status = (SELECT MAX(NBRJOBS_STATUS) FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM\r\n" + 
				"    AND (nbrjobs_pict_code = 'ED' or nbrjobs_pict_code = 'LD' )   AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"    FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM AND   (nbrjobs_pict_code = 'ED'\r\n" + 
				"    or nbrjobs_pict_code = 'LD' )))\r\n" + 
				"AND PERAPPT_APPT_EFF_DATE =     (select MAX(PERAPPT_APPT_EFF_DATE)  from PERAPPT WHERE PERAPPT_PIDM = pebempl.pebempl_PIDM)\r\n" + 
				") AS TIPO_ACADEMICO,\r\n" + 
				"\r\n" + 
				"(SELECT PTRECLS_LONG_DESC FROM PTRECLS WHERE PTRECLS_CODE = pebempl_ECLS_CODE) AS TIPO_FM,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  NVL (( SELECT DISTINCT nbrjobs_DESC\r\n" + 
				"  FROM NBRJOBS\r\n" + 
				"       WHERE (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') AND\r\n" + 
				"       NBRJOBS_pidm = pebempl.pebempl_PIDM\r\n" + 
				"       )\r\n" + 
				"        AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"        FROM NBRJOBS where NBRJOBS_pidm = pebempl.pebempl_PIDM AND (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') ))\r\n" + 
				"       ),0) AS DESC_PUESTO\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    FROM PEBEMPL,\r\n" + 
				"   SISEAC.SEG_USUARIO\r\n" + 
				"\r\n" + 
				"     WHERE PEBEMPL_PIDM = SEG_USUARIO.SPRIDEN_PIDM\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"AND SEG_USUARIO.USU_ID = "+ id + "\r\n" + 
				"\r\n" + 
				"    ORDER BY APELLIDO, NOMBRES";
	System.out.println(q);
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<>(Persona.class));
	}
	
	@GetMapping("persona/findbyPIDM/{id}")
	public List<Persona> findbyPIDM(@PathVariable Long id) throws SQLException{
		String q = "SELECT DISTINCT SEG_USUARIO.USU_ID AS USU_ID,\r\n" + 
				"    (SELECT MAX(spriden_ID) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS ID_BANNER,\r\n" + 
				"    (SELECT  MAX(spbpers_SSN) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)) as NUMERO_DOCUMENTO,\r\n" + 
				"    (SELECT MAX(spriden_LAST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS APELLIDO,\r\n" + 
				"    (SELECT MAX(spriden_FIRST_NAME) FROM SPRIDEN WHERE spriden_pidm = pebempl.pebempl_PIDM and spriden.spriden_change_ind is null ) AS NOMBRES,\r\n" + 
				"    (SELECT  MAX(SPBPERS_NAME_PREFIX)  FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)) as PREFIJO,\r\n" + 
				"    (SELECT  MAX(SPBPERS_BIRTH_DATE) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS FECHA_NACIMIENTO,\r\n" + 
				"    (SELECT  MAX((SELECT MAX(stvcitz_desc) FROM STVCITZ WHERE stvcitz_code = SPBPERS_CITZ_CODE)) FROM spbpers WHERE (spbpers_pidm = pebempl.pebempl_PIDM)  )AS NACIONALIDAD,\r\n" + 
				"    (SELECT SPBPERS_SEX FROM SPBPERS WHERE (spbpers_pidm = pebempl.pebempl_PIDM) ) AS SEXO,\r\n" + 
				"    (SELECT (select substr(MAX(gorrace_desc),15,10) from gorrace where gorrace_race_cde=GORPRAC_RACE_CDE) FROM  GORPRAC WHERE (GORPRAC_PIDM =pebempl.pebempl_PIDM) and GORPRAC_RACE_CDE in ('1','2','3','4','5','6','7','8')) AS TIPO_SANGRE,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" CASE\r\n" + 
				"( select MAX(GOVSDAV_VALUE_AS_CHAR)  from  GOVSDAV\r\n" + 
				"  WHERE GOVSDAV_TABLE_NAME = 'PDRBENE' AND GOVSDAV_ATTR_NAME = 'TIPO_DISCAPACIDAD'\r\n" + 
				"  and govsdav_pk_parenttab like pebempl.pebempl_PIDM  || '%' || '1' )\r\n" + 
				"WHEN '1' THEN 'AUDITIVA'\r\n" + 
				"WHEN '2' THEN 'FISICA'\r\n" + 
				"WHEN '3' THEN 'INTELECTUAL'\r\n" + 
				"WHEN '4' THEN 'VISUAL'\r\n" + 
				"END AS TIPO_DISC,\r\n" + 
				"    \r\n" + 
				" pebempl_bcat_code  AS TIPO_EMPLEADO,\r\n" + 
				" pebempl_empl_status AS STATUS,\r\n" + 
				"(SELECT FTVORGN_TITLE FROM FTVORGN WHERE FTVORGN_ORGN_CODE = PEBEMPL_ORGN_CODE_HOME) AS SECCION,\r\n" + 
				"(SELECT PTRJBLN_DESC FROM PTRJBLN WHERE PTRJBLN_CODE = PEBEMPL_JBLN_CODE) AS UBICACION,\r\n" + 
				"(SELECT STVCOLL_DESC FROM STVCOLL WHERE STVCOLL_CODE = PEBEMPL_COLL_CODE)as DEPARTAMENTO,\r\n" + 
				"(SELECT STVCAMP_DESC FROM STVCAMP WHERE STVCAMP_CODE = PEBEMPL_CAMP_CODE)as CAMPUS,\r\n" + 
				"\r\n" + 
				"( SELECT  (select PTVEGRP_DESC from payroll.PTVEGRP WHERE PTVEGRP_CODE = pebempl_EGRP_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM\r\n" + 
				") AS RELACION_LABORAL,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"CASE pebempl_bcat_code\r\n" + 
				"WHEN 'DO' THEN ( SELECT  (SELECT PTRECLS_LONG_DESC FROM PTRECLS  WHERE PTRECLS_CODE = pebempl.PEBEMPL_ECLS_CODE)\r\n" + 
				"  FROM pebempl t where t.PEBEMPL_pidm = pebempl.pebempl_PIDM )\r\n" + 
				"WHEN 'SP' THEN 'ADMINISTRATIVO'\r\n" + 
				"END  AS DEDICACION,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"(SELECT DISTINCT\r\n" + 
				"(select max(ptrtenr_desc)  from PTRTENR where ptrtenr_code= PERAPPT_TENURE_CODE ) as CATEGORIA_ESCALAFON\r\n" + 
				"FROM PEBEMPL r, PERAPPT\r\n" + 
				"WHERE\r\n" + 
				"r.pebempl_PIDM = PERAPPT.PERAPPT_PIDM\r\n" + 
				"AND r.pebempl_empl_status = 'A'\r\n" + 
				"--AND( r.pebempl_bcat_code = 'DO' )\r\n" + 
				"AND r.pebempl_PIDM = pebempl.pebempl_PIDM\r\n" + 
				"AND (r.pebempl_bcat_code = 'DO' or r.pebempl_bcat_code = 'SP' ) AND\r\n" + 
				"    r.pebempl_empl_status = (SELECT MAX(NBRJOBS_STATUS) FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM\r\n" + 
				"    AND (nbrjobs_pict_code = 'ED' or nbrjobs_pict_code = 'LD' )   AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"    FROM NBRJOBS where NBRJOBS_pidm = r.pebempl_PIDM AND   (nbrjobs_pict_code = 'ED'\r\n" + 
				"    or nbrjobs_pict_code = 'LD' )))\r\n" + 
				"AND PERAPPT_APPT_EFF_DATE =     (select MAX(PERAPPT_APPT_EFF_DATE)  from PERAPPT WHERE PERAPPT_PIDM = pebempl.pebempl_PIDM)\r\n" + 
				") AS TIPO_ACADEMICO,\r\n" + 
				"\r\n" + 
				"(SELECT PTRECLS_LONG_DESC FROM PTRECLS WHERE PTRECLS_CODE = pebempl_ECLS_CODE) AS TIPO_FM,\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  NVL (( SELECT DISTINCT nbrjobs_DESC\r\n" + 
				"  FROM NBRJOBS\r\n" + 
				"       WHERE (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') AND\r\n" + 
				"       NBRJOBS_pidm = pebempl.pebempl_PIDM\r\n" + 
				"       )\r\n" + 
				"        AND nbrjobs_effective_date = (SELECT MAX(nbrjobs_effective_date)\r\n" + 
				"        FROM NBRJOBS where NBRJOBS_pidm = pebempl.pebempl_PIDM AND (nbrjobs_pict_code IN ('ES','LS','CT','ED','LD') ))\r\n" + 
				"       ),0) AS DESC_PUESTO\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    FROM PEBEMPL,\r\n" + 
				"   SISEAC.SEG_USUARIO\r\n" + 
				"\r\n" + 
				"     WHERE PEBEMPL_PIDM = SEG_USUARIO.SPRIDEN_PIDM\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"AND SEG_USUARIO.SPRIDEN_PIDM = "+ id + "\r\n" + 
				"\r\n" + 
				"    ORDER BY APELLIDO, NOMBRES";
	System.out.println(q);
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<>(Persona.class));
	}
}
