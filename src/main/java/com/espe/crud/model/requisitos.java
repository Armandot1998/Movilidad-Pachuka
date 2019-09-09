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
@Table(name = "UZMTREQUISITO")
public class requisitos {

	@SequenceGenerator(name = "SEQ_UZMTREQUISITO", sequenceName = "SEQ_UZMTREQUISITO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTREQUISITO")
	@Id
	@Column(name = "UZMTREQUISITO_ID")
	private Long id_requisito;

	@Column(name = "UZMTREQUISITO_NOMBRE")
    private String nombre;
    
	@Column(name = "UZMTREQUISITO_DETALLE")
    private String detalle;
    
	@Column(name = "UZMTREQUISITO_ESTADO")
    private Boolean estado;
    
	@Column(name = "UZMTREQUISITO_USUARIO_CREA")
    private String usuario_crea;
	
	@Column(name = "UZMTREQUISITO_FECHA_CREA")
    private Date fecha_crea;
	
	@Column(name = "UZMTREQUISITO_USUARIO_MOD")
    private String usuario_mod;
	
	@Column(name = "UZMTREQUISITO_FECHA_MOD")
    private Date fecha_mod;

	public requisitos() {

	}

	public requisitos(String nombre, String detalle, Boolean estado, String usuario_crea,
			Date fecha_crea, String usuario_mod, Date fecha_mod) {
		super();
		this.nombre = nombre;
		this.detalle = detalle;
		this.estado = estado;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId_requisito() {
		return id_requisito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
		return "requisitos [id_requisito=" + id_requisito + ", nombre=" + nombre + ", detalle=" + detalle + ", estado="
				+ estado + ", usuario_crea=" + usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod="
				+ usuario_mod + ", fecha_mod=" + fecha_mod + "]";
	}

  
    
    
}
