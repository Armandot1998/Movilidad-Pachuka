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
@Table(name = "UZMTTIPMOV")
public class solicitudes {
	
	@SequenceGenerator(name = "SEQ_UZMTIPMOV", sequenceName = "SEQ_UZMTIPMOV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTTIPMOV")
	@Id
	@Column(name = "UZMTIPMOV_ID")
    private Long id;
	
	@Column(name = "UZMTCONVO_ID")
    private Long id_convo;
	
	@Column(name = "UZMTIPMOV_NOMBRE")
    private String nombre;
	
	@Column(name = "UZMTIPMOV_USUARIO_CREA")
    private String usuario_crea;
	
	@Column(name = "UZMTIPMOV_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTIPMOV_USUARIO_MOD")
	private String usuario_mod;
	
	
	@Column(name = "UZMTIPMOV_FECHA_MOD")
	private Date fecha_mod ;

	
	

	public solicitudes() {
		
	}

	public solicitudes(Long id_convo,String nombre,String usuario_crea,
				Date fecha_crea,String usuario_mod,Date fecha_mod) {
		super();
		this.id_convo = id_convo;
		this.nombre = nombre;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}
	
	public Long getId() {
		return id;
	}

	public Long getId_convo() {
		return id_convo;
	}


	public void setId_convo(Long id_convo) {
		this.id_convo = id_convo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "solicitudes[id ="+ id +",id_convo ="+id_convo+",nombre ="+nombre + ",usuario_crea="+ usuario_crea 
				+ ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod=" + fecha_mod + "]";
	}

}
