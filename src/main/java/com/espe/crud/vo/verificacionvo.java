package com.espe.crud.vo;

public class verificacionvo {
	private Boolean  uzmtverireq_estado;
	//private String uzmtrequisito_detalle;
	private String nombre;
	private String uzmtverireq_id;
	/**
	 * @return the uzmtverireq_estado
	 */

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the uzmtverireq_estado
	 */
	public Boolean getUzmtverireq_estado() {
		return uzmtverireq_estado;
	}
	/**
	 * @param uzmtverireq_estado the uzmtverireq_estado to set
	 */
	public void setUzmtverireq_estado(Boolean uzmtverireq_estado) {
		this.uzmtverireq_estado = uzmtverireq_estado;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the uzmtverireq_id
	 */
	public String getUzmtverireq_id() {
		return uzmtverireq_id;
	}
	/**
	 * @param uzmtverireq_id the uzmtverireq_id to set
	 */
	public void setUzmtverireq_id(String uzmtverireq_id) {
		this.uzmtverireq_id = uzmtverireq_id;
	}
}
