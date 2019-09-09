package com.espe.crud.model;

import java.sql.Date;

import javax.persistence.Column;

public class Persona {

	@Column(name = "PAR_PIDM")
	private Long par_pdm;
	
	@Column(name = "ID_BANNER")
	private String id_banner;
	
	@Column(name = "NUMERO_DOCUMENTO")
	private Long numero_documento;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "PREFIJO")
	private String prefijo;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fecha_nacimiento;
	
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "TIPO_SANGRE")
	private String tipo_sangre;
	
	@Column(name = "TIPO_DISC")
	private String tipo_discap;
	
	@Column(name = "TIPO_EMPLEADO")
	private String tipo_empleado;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "SECCION")
	private String seccion;
	
	@Column(name = "UBICACION")
	private String ubicacion;
	
	@Column(name = "DEPARTAMENTO")
	private String departamento;
	
	@Column(name = "DEDICACION")
	private String dedicacion;

	public Persona() {

	}

	public Persona(Long par_pdm, String id_banner, Long numero_documento, String apellido, String nombres,
			String prefijo, Date fecha_nacimiento, String nacionalidad, String sexo, String tipo_sangre,
			String tipo_discap, String tipo_empleado, String status, String seccion, String ubicacion,
			String departamento, String dedicacion) {
		super();
		this.par_pdm = par_pdm;
		this.id_banner = id_banner;
		this.numero_documento = numero_documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.prefijo = prefijo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.tipo_sangre = tipo_sangre;
		this.tipo_discap = tipo_discap;
		this.tipo_empleado = tipo_empleado;
		this.status = status;
		this.seccion = seccion;
		this.ubicacion = ubicacion;
		this.departamento = departamento;
		this.dedicacion = dedicacion;
	}

	public Long getPar_pdm() {
		return par_pdm;
	}

	public void setPar_pdm(Long par_pdm) {
		this.par_pdm = par_pdm;
	}

	public String getId_banner() {
		return id_banner;
	}

	public void setId_banner(String id_banner) {
		this.id_banner = id_banner;
	}

	public Long getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Long numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipo_sangre() {
		return tipo_sangre;
	}

	public void setTipo_sangre(String tipo_sangre) {
		this.tipo_sangre = tipo_sangre;
	}

	public String getTipo_discap() {
		return tipo_discap;
	}

	public void setTipo_discap(String tipo_discap) {
		this.tipo_discap = tipo_discap;
	}

	public String getTipo_empleado() {
		return tipo_empleado;
	}

	public void setTipo_empleado(String tipo_empleado) {
		this.tipo_empleado = tipo_empleado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	@Override
	public String toString() {
		return "Persona [par_pdm=" + par_pdm + ", id_banner=" + id_banner + ", numero_documento=" + numero_documento
				+ ", apellido=" + apellido + ", nombres=" + nombres + ", prefijo=" + prefijo + ", fecha_nacimiento="
				+ fecha_nacimiento + ", nacionalidad=" + nacionalidad + ", sexo=" + sexo + ", tipo_sangre="
				+ tipo_sangre + ", tipo_discap=" + tipo_discap + ", tipo_empleado=" + tipo_empleado + ", status="
				+ status + ", seccion=" + seccion + ", ubicacion=" + ubicacion + ", departamento=" + departamento
				+ ", dedicacion=" + dedicacion + "]";
	}

	
	
}
