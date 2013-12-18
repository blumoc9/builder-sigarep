package sigarep.modelos.data.maestros;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the banner database table.
 * 
 */
@Entity
@Table(name="banner")
public class Banner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_imagen", unique=true, nullable=false)
	private Integer idImagen;

	@Column(name="archivo_imagen", nullable=false)
	private byte[] archivoImagen;

	@Column(length=255)
	private String descripcion;

	@Column(length=255)
	private String enlace;

	@Column(nullable=false)
	private Boolean estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(length=60)
	private String titulo;

	public Banner() {
	}

	public Integer getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public byte[] getArchivoImagen() {
		return this.archivoImagen;
	}

	public void setArchivoImagen(byte[] archivoImagen) {
		this.archivoImagen = archivoImagen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}