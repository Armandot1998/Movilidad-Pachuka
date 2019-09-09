package com.espe.crud.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "UZMTESTINTER")
public class formexterinvi {

	@SequenceGenerator(name = "SEQ_UZMTESTINTER", sequenceName = "SEQ_UZMTESTINTER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTESTINTER")
	@Id
	@Column(name = "UZMTESTINTER_ID")
	private Long id;
	
	@Column(name = "UZMTCONVENIO_ID")
	private Long id_convenio;
	
	@Column(name = "UZMTCRONOG_ID")
	private Long id_cronog;
	
	@Column(name = "UZMTLUGAR_ID")
	private Long id_lugar;
	
	@Column(name = "UZMTSOLICTMOV_ID")
	private Long id_solitmov;
	
	@Column(name = "UZMTESTINTER_ANTEC")
	private String antecedentes;
	
	@Column(name = "UZMTESTINTER_OBJ")
	private String obj;
	
	@Column(name = "UZMTESTINTER_FECH_INIC")
	private Date fecha_ini;
	
	@Column(name = "UZMTESTINTER_FECH_FIN")
	private Date fecha_fin;
	
	@Column(name = "UZMTESTINTER_META")
	private String meta;
	
	@Column(name = "UZMTESTINTER_ENTREG")
	private String entreg;
	
	@Column(name = "UZMTESTINTER_NOM_CONT")
	private String nom_cont;
	
	@Column(name = "UZMTESTINTER_TELF_CONT")
	private String telf_cont;
	
	@Column(name = "UZMTESTINTER_EMAIL_CONT")
	private String email_cont;
	
	@Column(name = "UZMTESTINTER_NOM_DOCTORA")
	private String nom_doctora;
	
	@Column(name = "UZMTESTINTER_NOM_TESIS")
	private String nom_tesis;
	
	@Column(name = "UZMTESTINTER_NUM_APRO_DOCT")
	private String num_apro_doct;
	
	@Column(name = "UZMTESTINTER_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTESTINTER_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTESTINTER_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTESTINTER_FECHA_MOD")
	private Date fecha_mod;
	
	public formexterinvi(Long id_convenio, Long id_cronog, Long id_lugar, Long id_solitmov,
			String antecedentes, String obj, Date fecha_ini, Date fecha_fin, String meta, String entreg,
			String nom_cont, String telf_cont, String email_cont, String nom_doctora, String nom_tesis,
			String num_apro_doct, String usuario_crea, Date fecha_crea, String usuario_mod, Date fecha_mod) {
		super();
		this.id_convenio = id_convenio;
		this.id_cronog = id_cronog;
		this.id_lugar = id_lugar;
		this.id_solitmov = id_solitmov;
		this.antecedentes = antecedentes;
		this.obj = obj;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.meta = meta;
		this.entreg = entreg;
		this.nom_cont = nom_cont;
		this.telf_cont = telf_cont;
		this.email_cont = email_cont;
		this.nom_doctora = nom_doctora;
		this.nom_tesis = nom_tesis;
		this.num_apro_doct = num_apro_doct;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId() {
		return id;
	}

	public Long getId_convenio() {
		return id_convenio;
	}


	public void setId_convenio(Long id_convenio) {
		this.id_convenio = id_convenio;
	}


	public Long getId_cronog() {
		return id_cronog;
	}


	public void setId_cronog(Long id_cronog) {
		this.id_cronog = id_cronog;
	}


	public Long getId_lugar() {
		return id_lugar;
	}


	public void setId_lugar(Long id_lugar) {
		this.id_lugar = id_lugar;
	}


	public Long getId_solitmov() {
		return id_solitmov;
	}


	public void setId_solitmov(Long id_solitmov) {
		this.id_solitmov = id_solitmov;
	}


	public String getAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}


	public String getObj() {
		return obj;
	}


	public void setObj(String obj) {
		this.obj = obj;
	}


	public Date getFecha_ini() {
		return fecha_ini;
	}


	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}


	public Date getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public String getMeta() {
		return meta;
	}


	public void setMeta(String meta) {
		this.meta = meta;
	}


	public String getEntreg() {
		return entreg;
	}


	public void setEntreg(String entreg) {
		this.entreg = entreg;
	}


	public String getNom_cont() {
		return nom_cont;
	}


	public void setNom_cont(String nom_cont) {
		this.nom_cont = nom_cont;
	}


	public String getTelf_cont() {
		return telf_cont;
	}


	public void setTelf_cont(String telf_cont) {
		this.telf_cont = telf_cont;
	}


	public String getEmail_cont() {
		return email_cont;
	}


	public void setEmail_cont(String email_cont) {
		this.email_cont = email_cont;
	}


	public String getNom_doctora() {
		return nom_doctora;
	}


	public void setNom_doctora(String nom_doctora) {
		this.nom_doctora = nom_doctora;
	}


	public String getNom_tesis() {
		return nom_tesis;
	}


	public void setNom_tesis(String nom_tesis) {
		this.nom_tesis = nom_tesis;
	}


	public String getNum_apro_doct() {
		return num_apro_doct;
	}


	public void setNum_apro_doct(String num_apro_doct) {
		this.num_apro_doct = num_apro_doct;
	}


	public String getUsuario_crea() {
		return usuario_crea;
	}


	public void setUsuario_crea(String usuario_crea) {
		this.usuario_crea = usuario_crea;
	}


	public Date getFecha_crea() {
		return fecha_crea;
	}


	public void setFecha_crea(Date fecha_crea) {
		this.fecha_crea = fecha_crea;
	}


	public String getUsuario_mod() {
		return usuario_mod;
	}


	public void setUsuario_mod(String usuario_mod) {
		this.usuario_mod = usuario_mod;
	}


	public Date getFecha_mod() {
		return fecha_mod;
	}


	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}


	@Override
	public String toString() {
		return "formexterinvi [id=" + id + ", id_convenio=" + id_convenio + ", id_cronog=" + id_cronog + ", id_lugar="
				+ id_lugar + ", id_solitmov=" + id_solitmov + ", antecedentes=" + antecedentes + ", obj=" + obj
				+ ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", meta=" + meta + ", entreg=" + entreg
				+ ", nom_cont=" + nom_cont + ", telf_cont=" + telf_cont + ", email_cont=" + email_cont
				+ ", nom_doctora=" + nom_doctora + ", nom_tesis=" + nom_tesis + ", num_apro_doct=" + num_apro_doct
				+ ", usuario_crea=" + usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod
				+ ", fecha_mod=" + fecha_mod + "]";
	}

	
}

