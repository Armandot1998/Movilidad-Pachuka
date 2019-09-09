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
@Table(name = "UZMTEXTERNO")
public class externo {
	
	@SequenceGenerator(name = "SEQ_UZMTEXTERNO", sequenceName = "SEQ_UZMTEXTERNO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTEXTERNO")
	@Id
	@Column(name = "UZMTEXTERNO_ID")
	private Long id;
	
	@Column(name = "UZMTCONVENIO_ID")
	private Long id_convenio;
	
	@Column(name = "UZMTDOCENTEXTER_ID")
    private Long docentexter;
	
	@Column(name = "UZMTSOLICTMOV_ID")
    private Long solicitmov;
	
	@Column(name = "UZMTEXTERNO_GRUP_INV")
    private String grup_inv;
	
	@Column(name = "UZMTEXTERNO_LINEA_INV")
    private String linea_inv;
	
	@Column(name = "UZMTEXTERNO_BENEF")
    private String benef;
	
	@Column(name = "UZMTEXTERNO_FECH_INIC")
    private Date fech_inic;
	
	@Column(name = "UZMTEXTERNO_FECH_FIN")
    private Date fech_fin;
	
	@Column(name = "UZMTEXTERNO_OBJ")
    private String obj;
	
	@Column(name = "UZMTEXTERNO_METOD")
    private String metodo;
	
	@Column(name = "UZMTEXTERNO_META")
    private String meta;
	
	@Column(name = "UZMTEXTERNO_ENTREG")
    private String entreg;
	
	@Column(name = "STUSBGI_CODE")
    private Long code;
	
	@Column(name = "PEAEMPL_PIDM")
    private Long pdm;
	
	@Column(name = "UZMTEXTERNO_USUARIO_CREA")
    private String usuario_crea;
	
	@Column(name = "UZMTEXTERNO_FECHA_CREA")
    private Date fecha_crea;
	
	@Column(name = "UZMTEXTERNO_USUARIO_MOD")
    private String usuario_mod;
	
	@Column(name = "UZMYEXTERNO_FECHA_MOD")
    private Date fecha_mod;

	public externo() {
		
	}

	public externo(Long id_convenio, Long docentexter, Long solicitmov, String grup_inv, String linea_inv,
			String benef, Date fech_inic, Date fech_fin, String obj, String metodo, String meta, String entreg,
			Long code, Long pdm, String usuario_crea, Date fecha_crea, String usuario_mod, Date fecha_mod) {
		super();
		this.id_convenio = id_convenio;
		this.docentexter = docentexter;
		this.solicitmov = solicitmov;
		this.grup_inv = grup_inv;
		this.linea_inv = linea_inv;
		this.benef = benef;
		this.fech_inic = fech_inic;
		this.fech_fin = fech_fin;
		this.obj = obj;
		this.metodo = metodo;
		this.meta = meta;
		this.entreg = entreg;
		this.code = code;
		this.pdm = pdm;
		this.usuario_crea = usuario_crea;
		this.fecha_crea = fecha_crea;
		this.usuario_mod = usuario_mod;
		this.fecha_mod = fecha_mod;
	}

	public Long getId() {
		return id;
	}

	public Long getId_convenio() {
		return id_convenio;
	}

	public void setId_convenio(Long id_convenio) {
		this.id_convenio = id_convenio;
	}

	public Long getDocentexter() {
		return docentexter;
	}

	public void setDocentexter(Long docentexter) {
		this.docentexter = docentexter;
	}

	public Long getSolicitmov() {
		return solicitmov;
	}

	public void setSolicitmov(Long solicitmov) {
		this.solicitmov = solicitmov;
	}

	public String getGrup_inv() {
		return grup_inv;
	}

	public void setGrup_inv(String grup_inv) {
		this.grup_inv = grup_inv;
	}

	public String getLinea_inv() {
		return linea_inv;
	}

	public void setLinea_inv(String linea_inv) {
		this.linea_inv = linea_inv;
	}

	public String getBenef() {
		return benef;
	}

	public void setBenef(String benef) {
		this.benef = benef;
	}

	public Date getFech_inic() {
		return fech_inic;
	}

	public void setFech_inic(Date fech_inic) {
		this.fech_inic = fech_inic;
	}

	public Date getFech_fin() {
		return fech_fin;
	}

	public void setFech_fin(Date fech_fin) {
		this.fech_fin = fech_fin;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getEntreg() {
		return entreg;
	}

	public void setEntreg(String entreg) {
		this.entreg = entreg;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getPdm() {
		return pdm;
	}

	public void setPdm(Long pdm) {
		this.pdm = pdm;
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
		return "externo [id=" + id + ", id_convenio=" + id_convenio + ", docentexter=" + docentexter + ", solicitmov="
				+ solicitmov + ", grup_inv=" + grup_inv + ", linea_inv=" + linea_inv + ", benef=" + benef
				+ ", fech_inic=" + fech_inic + ", fech_fin=" + fech_fin + ", obj=" + obj + ", metodo=" + metodo
				+ ", meta=" + meta + ", entreg=" + entreg + ", code=" + code + ", pdm=" + pdm + ", usuario_crea="
				+ usuario_crea + ", fecha_crea=" + fecha_crea + ", usuario_mod=" + usuario_mod + ", fecha_mod="
				+ fecha_mod + "]";
	}

}

