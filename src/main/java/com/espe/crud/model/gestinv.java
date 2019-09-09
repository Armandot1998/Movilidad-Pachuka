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
@Table(name = "UZMTMGESTINV")
public class gestinv {

	@SequenceGenerator(name = "SEQ_UZMTMGESTINV", sequenceName = "SEQ_UZMTMGESTINV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTMGESTINV")
	@Id
	@Column(name = "UZMTMGESTINV_ID")
	private Long id;
	
	@Column(name = "UZMTSOLICTMOV_ID")
	private Long id_solictmov;

	@Column(name = "UZMTMGESTINV_OBJ")
	private String obj;
	
	@Column(name = "UZMTMGESTINV_CONVENIO_E")
	private String convenio;
	
	@Column(name = "UZMTMGESTINV_P_COOPER_E")
	private String p_cooper;
	
	@Column(name = "UZMTMGESTINV_A_COLABO")
	private String a_colab;
	
	@Column(name = "UZMTMGESTINV_NOM_INST")
	private String nom_inst;
	
	@Column(name = "UZMTMGESTINV_SIT_WEB_INST")
	private String sit_web_isnt;
	
	@Column(name = "UZMTMGESTINV_NOM_C_INST")
	private String nom_c_inst;
	
	@Column(name = "UZMTMGESTINV_TELF_C_INST")
	private String telf_c_inst;
	
	@Column(name = "UZMTMGESTINV_EMAIL_C_INST")
	private String email_c_inst;
	
	@Column(name = "UZMTMGESTINV_FECH_INI")
	private Date fech_ini;
	
	@Column(name = "UZMTMGESTINV_FECH_FIN")
	private Date fech_fin;
	
	@Column(name = "UZMTMGESTINV_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTMGESTINV_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTMGESTINV_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTMGESTINV_FECHA_MOD")
	private Date fecha_mod;
	

	public gestinv() {
		
	}

	

	public gestinv(Long id_solictmov, String obj, String convenio, String p_cooper, String a_colab,
			String nom_inst, String sit_web_isnt, String nom_c_inst, String telf_c_inst, String email_c_inst,
			Date fech_ini, Date fech_fin, String usuario_crea, Date fecha_crea, String usuario_mod, Date fecha_mod) {
		super();
		this.id_solictmov = id_solictmov;
		this.obj = obj;
		this.convenio = convenio;
		this.p_cooper = p_cooper;
		this.a_colab = a_colab;
		this.nom_inst = nom_inst;
		this.sit_web_isnt = sit_web_isnt;
		this.nom_c_inst = nom_c_inst;
		this.telf_c_inst = telf_c_inst;
		this.email_c_inst = email_c_inst;
		this.fech_ini = fech_ini;
		this.fech_fin = fech_fin;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}



	public Long getId() {
		return id;
	}

	public Long getId_solictmov() {
		return id_solictmov;
	}


	public void setId_solictmov(Long id_solictmov) {
		this.id_solictmov = id_solictmov;
	}


	public String getObj() {
		return obj;
	}


	public void setObj(String obj) {
		this.obj = obj;
	}


	public String getConvenio() {
		return convenio;
	}


	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}


	public String getP_cooper() {
		return p_cooper;
	}


	public void setP_cooper(String p_cooper) {
		this.p_cooper = p_cooper;
	}


	public String getA_colab() {
		return a_colab;
	}


	public void setA_colab(String a_colab) {
		this.a_colab = a_colab;
	}


	public String getNom_inst() {
		return nom_inst;
	}


	public void setNom_inst(String nom_inst) {
		this.nom_inst = nom_inst;
	}


	public String getSit_web_isnt() {
		return sit_web_isnt;
	}


	public void setSit_web_isnt(String sit_web_isnt) {
		this.sit_web_isnt = sit_web_isnt;
	}


	public String getNom_c_inst() {
		return nom_c_inst;
	}


	public void setNom_c_inst(String nom_c_inst) {
		this.nom_c_inst = nom_c_inst;
	}


	public String getTelf_c_inst() {
		return telf_c_inst;
	}


	public void setTelf_c_inst(String telf_c_inst) {
		this.telf_c_inst = telf_c_inst;
	}


	public String getEmail_c_inst() {
		return email_c_inst;
	}


	public void setEmail_c_inst(String email_c_inst) {
		this.email_c_inst = email_c_inst;
	}


	public Date getFech_ini() {
		return fech_ini;
	}


	public void setFech_ini(Date fech_ini) {
		this.fech_ini = fech_ini;
	}


	public Date getFech_fin() {
		return fech_fin;
	}


	public void setFech_fin(Date fech_fin) {
		this.fech_fin = fech_fin;
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
		return "gestinv [id=" + id + ", id_solictmov=" + id_solictmov + ", obj=" + obj + ", convenio=" + convenio
				+ ", p_cooper=" + p_cooper + ", a_colab=" + a_colab + ", nom_inst=" + nom_inst + ", sit_web_isnt="
				+ sit_web_isnt + ", nom_c_inst=" + nom_c_inst + ", telf_c_inst=" + telf_c_inst + ", email_c_inst="
				+ email_c_inst + ", fech_ini=" + fech_ini + ", fech_fin=" + fech_fin + ", usuario_crea=" + usuario_crea
				+ ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod=" + fecha_mod + "]";
	}

	
}

