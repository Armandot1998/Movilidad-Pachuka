package com.espe.crud.vo;

import java.sql.Date;

public class convenioVo {
 
	private Long uzmtconvenio_id;
	private String uzmttipconve_nom;
	private Date uzmtconvenio_fech_fin;
	private Date uzmtconvenio_fech_ini;
	private Boolean uzmtconvenio_estado;
;
	private String stusbgi_code;
	public Long getUzmtconvenio_id() {
		return uzmtconvenio_id;
	}
	public void setUzmtconvenio_id(Long uzmtconvenio_id) {
		this.uzmtconvenio_id = uzmtconvenio_id;
	}
	public String getUzmttipconve_nom() {
		return uzmttipconve_nom;
	}
	public void setUzmttipconve_nom(String uzmttipconve_nom) {
		this.uzmttipconve_nom = uzmttipconve_nom;
	}
	public Date getUzmtconvenio_fech_fin() {
		return uzmtconvenio_fech_fin;
	}
	public void setUzmtconvenio_fech_fin(Date uzmtconvenio_fech_fin) {
		this.uzmtconvenio_fech_fin = uzmtconvenio_fech_fin;
	}
	public Date getUzmtconvenio_fech_ini() {
		return uzmtconvenio_fech_ini;
	}
	public void setUzmtconvenio_fech_ini(Date uzmtconvenio_fech_ini) {
		this.uzmtconvenio_fech_ini = uzmtconvenio_fech_ini;
	}
	public Boolean getUzmtconvenio_estado() {
		return uzmtconvenio_estado;
	}
	public void setUzmtconvenio_estado(Boolean uzmtconvenio_estado) {
		this.uzmtconvenio_estado = uzmtconvenio_estado;
	}
	public String getStusbgi_code() {
		return stusbgi_code;
	}
	public void setStusbgi_code(String stusbgi_code) {
		this.stusbgi_code = stusbgi_code;
	}
	
}
