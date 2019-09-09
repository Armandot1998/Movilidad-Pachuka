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
@Table(name = "UZMTCRONG")
public class Cronograma {

	    @SequenceGenerator(name = "SEQ_UZMTCRONG", sequenceName = "SEQ_UZMTCRONG", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UZMTCRONG")
		@Id
		@Column(name = "UZMTCRONOG_ID")
		private Long id;
		
		@Column(name = "UZMTEXTERNO_ID")
		private Long id_externo;
		
		@Column(name = "UZMTCRONG_LUGAR")
	    private String lugar;
		
		@Column(name = "UZMTCRONG_FECHA")
	    private Date fecha;
		
		@Column(name = "UZMTCRONG_ACTIV")
	    private String activ;

		@Column(name = "UZMTCRONG_USUARIO_CREA")
	    private String usuario_crea ;
		

		@Column(name = "UZMTCRONG_FECHA_CREA")
	    private Date fecha_crea;
		
		@Column(name = "UZMTCRONG_USUARIO_MOD")
	    private String usuario_mod;
		
		@Column(name = "UZMTCRONG_FECHA_MOD")
	    private Date fecha_mod;

		public Long getId() {
			return id;
		}

		public Long getId_externo() {
			return id_externo;
		}

		public void setId_externo(Long id_externo) {
			this.id_externo = id_externo;
		}

		public String getLugar() {
			return lugar;
		}

		public void setLugar(String lugar) {
			this.lugar = lugar;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public String getActiv() {
			return activ;
		}

		public void setActiv(String activ) {
			this.activ = activ;
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

		public Cronograma() {
		
		}

		public Cronograma(Long id, Long id_externo, String lugar, Date fecha, String activ, String usuario_crea,
				Date fecha_crea, String usuario_mod, Date fecha_mod) {
			super();
			this.id = id;
			this.id_externo = id_externo;
			this.lugar = lugar;
			this.fecha = fecha;
			this.activ = activ;
			this.usuario_crea = usuario_crea;
			this.fecha_crea = fecha_crea;
			this.usuario_mod = usuario_mod;
			this.fecha_mod = fecha_mod;
		}

		
}
	
