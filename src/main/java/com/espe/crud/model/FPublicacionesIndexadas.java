	package com.espe.crud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UZMTFMOVILIDAD")
public class FPublicacionesIndexadas {

	@SequenceGenerator(name = "SEQ_UZMTFMOVILIDAD", sequenceName = "SEQ_UZMTFMOVILIDAD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTFMOVILIDAD")
	@Id
	@Column(name = "UZMTFMOVILIDAD_ID")
	private Long id_fmovilidad;
	
	@Column(name = "UZMTCONGEXP_ID")
	private Long id_congresxp;
	
	@Column(name = "UZMTSOLICITMOV_ID")
	private String id_solicitmov;
	
	@Column(name = "MOVBD_ID")
	private String id_movbd;
	
	@Column(name = "UZMTFMOVILIDAD_NOM_ARTIC")
	private String nom_artic;
	
	@Column(name = "UZMTFMOVILIDAD_NOM_REVIS")
	private String nom_revis;
	
	@Column(name = "UZMTFMOVILIDAD_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTFMOVILIDAD_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTFMOVILIDAD_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTFMOVILIDAD_FECHA_MOD")
	private Date fecha_mod;

	public FPublicacionesIndexadas() {

	}

	public FPublicacionesIndexadas(Long id_congresxp, String id_solicitmov, String id_movbd,
			String nom_artic, String nom_revis, String usuario_crea, Date fecha_crea, String usuario_mod,
			Date fecha_mod) {
		super();
		this.id_congresxp = id_congresxp;
		this.id_solicitmov = id_solicitmov;
		this.id_movbd = id_movbd;
		this.nom_artic = nom_artic;
		this.nom_revis = nom_revis;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId_fmovilidad() {
		return id_fmovilidad;
	}

	public Long getId_congresxp() {
		return id_congresxp;
	}

	public void setId_congresxp(Long id_congresxp) {
		this.id_congresxp = id_congresxp;
	}

	public String getId_solicitmov() {
		return id_solicitmov;
	}

	public void setId_solicitmov(String id_solicitmov) {
		this.id_solicitmov = id_solicitmov;
	}

	public String getId_movbd() {
		return id_movbd;
	}

	public void setId_movbd(String id_movbd) {
		this.id_movbd = id_movbd;
	}

	public String getNom_artic() {
		return nom_artic;
	}

	public void setNom_artic(String nom_artic) {
		this.nom_artic = nom_artic;
	}

	public String getNom_revis() {
		return nom_revis;
	}

	public void setNom_revis(String nom_revis) {
		this.nom_revis = nom_revis;
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
		return "FPublicacionesIndexadas [id_fmovilidad=" + id_fmovilidad + ", id_congresxp=" + id_congresxp
				+ ", id_solicitmov=" + id_solicitmov + ", id_movbd=" + id_movbd + ", nom_artic=" + nom_artic
				+ ", nom_revis=" + nom_revis + ", usuario_crea=" + usuario_crea + ", fecha_crea=" + fecha_crea
				+ ", usuario_mod=" + usuario_mod + ", fecha_mod=" + fecha_mod + "]";
	}	
	
}
