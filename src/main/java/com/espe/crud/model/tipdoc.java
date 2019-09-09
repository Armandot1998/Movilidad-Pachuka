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
@Table(name = "UZMTTIPDOC")
public class tipdoc {

	@SequenceGenerator(name = "SEQ_UZMTTIPDOC", sequenceName = "SEQ_UZMTTIPDOC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTTIPDOC")
	@Id
	@Column(name = "UZMTTIPDOC_ID")
	private Long id;
	
	@Column(name = "UZMTTIPDOC_NOM_DOC")
	private String nom_doc;
	
	@Column(name = "UZMTTIPDOC_EST")
    private Boolean estado;
	
	@Column(name = "UZMTIPDOC_USUARIO_CREA")
    private String usuario_crea;
	
	@Column(name = "UZMTIPDOC_FECHA_CREA")
    private Date fecha_crea;
	
	@Column(name = "UZMTIPDOC_USUARIO_MOD")
    private String usuario_mod;
	
	@Column(name = "UZMTIPDOC_FECHA_MOD")
    private Date fecha_mod;
	

	public tipdoc() {
		
	}


	public tipdoc(String nom_doc, Boolean estado, String usuario_crea, Date fecha_crea, String usuario_mod,
			Date fecha_mod) {
		super();
		this.nom_doc = nom_doc;
		this.estado = estado;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}


	public Long getId() {
		return id;
	}

	public String getNom_doc() {
		return nom_doc;
	}


	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
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
		return "cargdoc [id=" + id + ", nom_doc=" + nom_doc + ", estado=" + estado + ", usuario_crea=" + usuario_crea
				+ ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod=" + fecha_mod + "]";
	}
	
}
