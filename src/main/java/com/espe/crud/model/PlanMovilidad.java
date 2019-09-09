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
@Table(name = "UZMTPLANMOV")
public class PlanMovilidad {
	
	@SequenceGenerator(name = "SEQ_UZMTPLANMOV", sequenceName = "SEQ_UZMTUZMTPLANMOV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTUZMTPLANMOV")
	@Id
	@Column(name = "UZMTPLANMOV_ID")
	private Long id_planmov;
	
	@Column(name = "UZMTIPMOV_ID")
	private Long id_tipmov;
	
	@Column(name = "UZMTPLANMOV_NOMBRE")
	private String nombre;
	
	@Column(name = "UZMTPLANMOV_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTPLANMOV_FECHA_CREA")
	private Date fecha_crea;
		
	@Column(name = "UZMTPLANMOV_USUARIO_MOD")
	private String usuario_mod;	

	@Column(name = "UZMTPLANMOV_FECHA_MOD")
    private Date fecha_mod;
    
    

	public PlanMovilidad() {
		
	}



	public PlanMovilidad(Long id_tipmov, String nombre, String usuario_crea, Date fecha_crea,
			String usuario_mod, Date fecha_mod) {
		super();
		this.id_tipmov = id_tipmov;
		this.nombre = nombre;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}



	public Long getId_planmov() {
		return id_planmov;
	}

	public Long getId_tipmov() {
		return id_tipmov;
	}



	public void setId_tipmov(Long id_tipmov) {
		this.id_tipmov = id_tipmov;
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
		return "PlanMovilidad [id_planmov=" + id_planmov + ", id_tipmov=" + id_tipmov + ", nombre=" + nombre
				+ ", usuario_crea=" + usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod
				+ ", fecha_mod=" + fecha_mod + "]";
	}
	
}
