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
@Table(name = "UZMTREQMOVSUBM")
public class requisitosmovsubm {

	@SequenceGenerator(name = "SEQ_UZMTREQMOVSUBM", sequenceName = "SEQ_UZMTREQMOVSUBM", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTREQMOVSUBM")
	@Id
	@Column(name = "UZMTREQMOVSUBM_ID")
	private Long id;
	
	@Column(name = "UZMTREQUISITO_ID")
	private Long id_requisito;
	
	@Column(name = "UZMTMOVSUBM_ID")
	private Long id_movsubm;
	
	@Column(name = "UZMTREQMOVSUBM_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTREQMOVSUBM_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTREQMOVSUBM_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTREQMOVSUBM_FECHA_MOD")
	private Date fecha_mod;

	public requisitosmovsubm() {

	}

	public requisitosmovsubm(Long id_requisito, Long id_movsubm, String usuario_crea, Date fecha_crea,
			String usuario_mod, Date fecha_mod) {
		super();
		this.id_requisito = id_requisito;
		this.id_movsubm = id_movsubm;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId() {
		return id;
	}

	public Long getId_requisito() {
		return id_requisito;
	}

	public void setId_requisito(Long id_requisito) {
		this.id_requisito = id_requisito;
	}

	public Long getId_movsubm() {
		return id_movsubm;
	}

	public void setId_movsubm(Long id_movsubm) {
		this.id_movsubm = id_movsubm;
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
		return "requisitosmovsubm [id=" + id + ", id_requisito=" + id_requisito + ", id_movsubm=" + id_movsubm
				+ ", usuario_crea=" + usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod
				+ ", fecha_mod=" + fecha_mod + "]";
	}
	
}
