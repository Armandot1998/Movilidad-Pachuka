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
@Table(name = "UZMTVERIREQ", schema="UTIC")
public class verificacion {
	
	@SequenceGenerator(name = "SEQ_UZMTVERIREQ", sequenceName = "SEQ_UZMTVERIREQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTVERIREQ")
	@Id
	@Column(name = "UZMTVERIREQ_ID")
	private Long id;
	
	@Column(name = "UZMTREQPLANM_ID")
	private Long id_requisito_pl;
	
	@Column(name = "UZMTREQMOVSUBM_ID")
	private Long id_requisito_submov;
	
	@Column(name = "PEAEMPL_PIDM")
	private Long pidm;
	
	@Column(name = "UZMTVERIREQ_ESTADO")
	private Boolean estado ;
	
	@Column(name = "UZMTVERIREQ_COD_SOLIC")
	private String codigo_solicitud;
	
	@Column(name = "UZMTVERIREQ_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTVERIREQ_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTVERIREQ_USUARIO_MOD")
	private String usuario_mod ;
	
	@Column(name = "UZMTVERIREQ_FECHA_MOD")
	private Date fecha_mod;

	
	public verificacion() {
		
	}
	
    public verificacion(Long id_requisito_pl,Long id_requisito_submov,Long pidm,Boolean estado,
    		             String codigo_solicitud, String usuario_crea, Date fecha_crea, String usuario_mod,Date fecha_mod) {
    	super();
    	this.id_requisito_pl = id_requisito_pl;
    	this.id_requisito_submov = id_requisito_submov;
    	this.pidm = pidm;
    	this.estado = estado;
    	this.codigo_solicitud = codigo_solicitud;
    	this.usuario_crea = usuario_crea;
    	this.fecha_crea = fecha_crea;
    	this.usuario_mod = usuario_mod;
    	this.fecha_mod = fecha_mod;
		
	}
	
	public Long getId() {
		return id;
	}

	public Long getId_requisito_pl() {
		return id_requisito_pl;
	}

	public void setId_requisito_pl(Long id_requisito_pl) {
		this.id_requisito_pl = id_requisito_pl;
	}

	public Long getId_requisito_submov() {
		return id_requisito_submov;
	}

	public void setId_requisito_submov(Long id_requisito_submov) {
		this.id_requisito_submov = id_requisito_submov;
	}

	public Long getPidm() {
		return pidm;
	}

	public void setPidm(Long pidm) {
		this.pidm = pidm;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCodigo_solicitud() {
		return codigo_solicitud;
	}

	public void setCodigo_solicitud(String codigo_solicitud) {
		this.codigo_solicitud = codigo_solicitud;
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
		return "verificacion[id ="+ id +",id_requisito_pl ="+id_requisito_submov+",id_requisito_submov ="+id_requisito_submov
				+",pidm="+pidm+",estado="+estado+",codigo_solicitud="+codigo_solicitud+",usuario_crea="
				+ usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod="
				+ fecha_mod + "]";
	}
	
	
	
}
