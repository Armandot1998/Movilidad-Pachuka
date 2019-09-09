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
@Table(name = "UZMTSOLICTMOV")
public class solicitudmovilidad {

	@SequenceGenerator(name = "SEQ_UZMTSOLICTMOV", sequenceName = "SEQ_UZMTSOLICTMOV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTSOLICTMOV")
	@Id
	@Column(name = "UZMTSOLICTMOV_ID")
	private Long id;
	
	@Column(name = "UZMTVERIREQ_ID")
	private Long id_verif_req;
	
	@Column(name = "UZMTSOLICTMOV_ESTADO")
	private Boolean estado ;
	
	@Column(name = "UZMTSOLICTMOV_OBSER")
	private String obser;
	
	@Column(name = "UZMTSOLICTMOV_FECH")
	private Date fecha_solicitud;
	
	@Column(name = "UZMTSOLICTMOV_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTSOLICTMOV_FECHA_CREA")
	private Date fecha_crea;

	@Column(name = "UZMTSOLICTMOV_USUARIO_MOD")
	private String usuario_mod ;
	
	@Column(name = "UZMTSOLICTMOV_FECHA_MOD")
	private Date fecha_mod;

	
	public solicitudmovilidad() {
		
	}
	
   public solicitudmovilidad(Long id_verif_req,Boolean estado,String obser,Date fecha_solicitud,
		   					 String usuario_crea,Date fecha_crea,String usuario_mod,Date fecha_mod) {
	   super();
	   this.id_verif_req = id_verif_req;
	   this.estado = estado;
	   this.obser = obser;
	   this.fecha_solicitud = fecha_solicitud;
	   this.usuario_crea = usuario_crea;
	   this.fecha_crea = fecha_crea;
	   this.usuario_mod = usuario_mod;
	   this.fecha_mod = fecha_mod;
		
	}
	
	
	
	public Long getId() {
		return id;
	}

	public Long getId_verif_req() {
		return id_verif_req;
	}

	public void setId_verif_req(Long id_verif_req) {
		this.id_verif_req = id_verif_req;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getObser() {
		return obser;
	}

	public void setObser(String obser) {
		this.obser = obser;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
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
		return "solicitudmovilidad [id=" + id + ", id_verif_req=" + id_verif_req + ", estado=" + estado
				+ ", obser=" + obser + ", fecha_solicitud =" + fecha_solicitud +", usuario_crea =" + usuario_crea 
				+" , fecha_crea =" + fecha_crea +" , usuario_mod =" + usuario_mod +" , fecha_mod =" + fecha_mod +  "]";
	}
	
	
}
