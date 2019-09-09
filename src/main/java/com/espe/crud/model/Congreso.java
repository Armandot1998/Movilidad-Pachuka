package com.espe.crud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UZMTCONGEXP")
public class Congreso {

	
	@Id
	@Column(name = "UZMTCONGEXP_ID")
	private Long id;
	
	@Column(name = "UZMTCONGEXP_NOM")
	private String nombre;
	
	@Column(name = "UZMTCONGEXP_SIT_WEB")
	private String sitio_web;
	
	@Column(name = "UZMTCONGEXP_NOM_CONT")
	private String nom_cont;
	
	@Column(name = "UZMTCONGEXP_TELF")
	private String telf;
	
	
	@Column(name = "UZMTCONGEXP_EMAIL")
	private String email;
	
	@Column(name = "UZMTCONGEXP_FECH_INI")
	private Date fech_ini;
	
	@Column(name = "UZMTCONGEXP_FECH_FIN")
	private Date fech_fin;
	
	@Column(name = "UZMTCONGEXP_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTCONGEXP_FECHA_CREA")
	private Date fech_crea;
	
	@Column(name = "UZMTCONGEXP_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTCONGEXP_FECHA_MOD")
	private Date fech_mod;

	public Congreso() {

	}

	public Congreso(Long id, String nombre, String sitio_web, String nom_cont, String telf, String email, Date fech_ini,
			Date fech_fin, String usuario_crea, Date fech_crea, String usuario_mod, Date fech_mod) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sitio_web = sitio_web;
		this.nom_cont = nom_cont;
		this.telf = telf;
		this.email = email;
		this.fech_ini = fech_ini;
		this.fech_fin = fech_fin;
		this.usuario_crea = usuario_crea;
		this.fech_crea = fech_crea;
		this.usuario_mod = usuario_mod;
		this.fech_mod = fech_mod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSitio_web() {
		return sitio_web;
	}

	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}

	public String getNom_cont() {
		return nom_cont;
	}

	public void setNom_cont(String nom_cont) {
		this.nom_cont = nom_cont;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getFech_crea() {
		return fech_crea;
	}

	public void setFech_crea(Date fech_crea) {
		this.fech_crea = fech_crea;
	}

	public String getUsuario_mod() {
		return usuario_mod;
	}

	public void setUsuario_mod(String usuario_mod) {
		this.usuario_mod = usuario_mod;
	}

	public Date getFech_mod() {
		return fech_mod;
	}

	public void setFech_mod(Date fech_mod) {
		this.fech_mod = fech_mod;
	}

	@Override
	public String toString() {
		return "Congreso [id=" + id + ", nombre=" + nombre + ", sitio_web=" + sitio_web + ", nom_cont=" + nom_cont
				+ ", telf=" + telf + ", email=" + email + ", fech_ini=" + fech_ini + ", fech_fin=" + fech_fin
				+ ", usuario_crea=" + usuario_crea + ", fech_crea=" + fech_crea + ", usuario_mod=" + usuario_mod
				+ ", fech_mod=" + fech_mod + "]";
	}
	
}
