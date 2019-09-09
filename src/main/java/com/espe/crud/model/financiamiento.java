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
@Table(name = "UZMTFINAN")
public class financiamiento {
	
	@SequenceGenerator(name = "SEQ_UZMTFINAN", sequenceName = "SEQ_UZMTFINAN", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTFINAN")
	@Id
	@Column(name = "UZMTFINAN_ID")
	private Long id;
	
	@Column(name = "UZMTMGESTINV_ID")
	private Long id_gestinv;
	
	@Column(name = "UZMTFMOVILIDAD_ID")
	private Long id_fmovilidad;
	
	@Column(name = "UZMTESTINTER_ID")
	private Long id_testint;
	
	@Column(name = "UZMTEXTERNO_ID")
	private Long id_externo;
	
	@Column(name = "UZMTFINAN_PASAJE")
	private Long id_pasaje;
	
	@Column(name = "UZMTFINAN_VIATICO")
	private Long finan_viatico;
	
	@Column(name = "UZMTFINAN_OTROS")
	private Long otros;
	
	@Column(name = "UZMTFINAN_TOTAL")
	private Long total;
	
	@Column(name = "UZMTFINAN_USUARIO_CREA")
	private String usuario_crea;
	
	@Column(name = "UZMTFINAN_FECHA_CREA")
	private Date fecha_crea;
	
	@Column(name = "UZMTFINAN_USUARIO_MOD")
	private String usuario_mod;
	
	@Column(name = "UZMTFINAN_FECHA__MOD")
	private Date fecha_mod;

	public financiamiento() {
	
	}

	public financiamiento(Long id_gestinv, Long id_fmovilidad, Long id_testint, Long id_externo,
			Long id_pasaje, Long finan_viatico, Long otros, Long total, String usuario_crea, Date fecha_crea,
			String usuario_mod, Date fecha_mod) {
		super();
		this.id_gestinv = id_gestinv;
		this.id_fmovilidad = id_fmovilidad;
		this.id_testint = id_testint;
		this.id_externo = id_externo;
		this.id_pasaje = id_pasaje;
		this.finan_viatico = finan_viatico;
		this.otros = otros;
		this.total = total;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId() {
		return id;
	}

	public Long getId_gestinv() {
		return id_gestinv;
	}

	public void setId_gestinv(Long id_gestinv) {
		this.id_gestinv = id_gestinv;
	}

	public Long getId_fmovilidad() {
		return id_fmovilidad;
	}

	public void setId_fmovilidad(Long id_fmovilidad) {
		this.id_fmovilidad = id_fmovilidad;
	}

	public Long getId_testint() {
		return id_testint;
	}

	public void setId_testint(Long id_testint) {
		this.id_testint = id_testint;
	}

	public Long getId_externo() {
		return id_externo;
	}

	public void setId_externo(Long id_externo) {
		this.id_externo = id_externo;
	}

	public Long getId_pasaje() {
		return id_pasaje;
	}

	public void setId_pasaje(Long id_pasaje) {
		this.id_pasaje = id_pasaje;
	}

	public Long getFinan_viatico() {
		return finan_viatico;
	}

	public void setFinan_viatico(Long finan_viatico) {
		this.finan_viatico = finan_viatico;
	}

	public Long getOtros() {
		return otros;
	}

	public void setOtros(Long otros) {
		this.otros = otros;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
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
		return "financiamiento [id=" + id + ", id_gestinv=" + id_gestinv + ", id_fmovilidad=" + id_fmovilidad
				+ ", id_testint=" + id_testint + ", id_externo=" + id_externo + ", id_pasaje=" + id_pasaje
				+ ", finan_viatico=" + finan_viatico + ", otros=" + otros + ", total=" + total + ", usuario_crea="
				+ usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod="
				+ fecha_mod + "]";
	}
}
