package sigarep.viewmodels.maestros;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;


import sigarep.herramientas.MensajesAlUsuario;
import sigarep.modelos.data.maestros.InstanciaApelada;
import sigarep.modelos.data.maestros.SancionMaestro;
import sigarep.modelos.data.maestros.TipoMotivo;
import sigarep.modelos.data.maestros.TipoMotivoFiltros;
import sigarep.modelos.servicio.maestros.ServicioTipoMotivo;

/**
 * TipoMotivo UCLA DCYT Sistemas de Informacion.
 * 
 * @author Equipo : Builder-Sigarep Lapso 2013-2
 * @version 1.0
 * @since 22/01/14
 */

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class VMTipoMotivo {
	@WireVariable ServicioTipoMotivo serviciotipomotivo;
//	private Integer idTipoMotivo;
	private String nombreTipoMotivo,nombreTipoMotivofiltro;
	private String descripcion,descripcionfiltro;
	private Integer idTipoMotivo;
	private Boolean estatus;
	private List<TipoMotivo> listaTipoMotivo;
	private TipoMotivo tiposeleccionado;
	private TipoMotivoFiltros filtros = new TipoMotivoFiltros();
	@Wire Textbox txtnombreTipoMotivo;
    @Wire Window winTipoMotivo;
    MensajesAlUsuario mensajeAlUsuario = new MensajesAlUsuario();
	
    //Metodos set y get

    public String getNombreTipoMotivo() {
		return nombreTipoMotivo;
	}
    public String getDescripcion() {
		return descripcion;
	}
    public Boolean getEstatus() {
		return estatus;
	}
    public String getNombreTipoMotivofiltro() {
		return nombreTipoMotivofiltro;
	}
    public String getDescripcionfiltro() {
		return descripcionfiltro;
	}
    public List<TipoMotivo> getListaTipoMotivo() {
		return listaTipoMotivo;
	}
    public TipoMotivo getTiposeleccionado() {
		return tiposeleccionado;
	}
	public void setNombreTipoMotivofiltro(String nombreTipoMotivofiltro) {
		this.nombreTipoMotivofiltro = nombreTipoMotivofiltro;
	}
	
	public void setDescripcionfiltro(String descripcionfiltro) {
		this.descripcionfiltro = descripcionfiltro;
	}
	public TipoMotivoFiltros getFiltros() {
		return filtros;
	}

	public void setFiltros(TipoMotivoFiltros filtros) {
		this.filtros = filtros;
	}
	public void setNombreTipoMotivo(String nombreTipoMotivo) {
		this.nombreTipoMotivo = nombreTipoMotivo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public void setListaTipoMotivo(List<TipoMotivo> ListaTipoMotivo) {
		this.listaTipoMotivo = ListaTipoMotivo;
	}
	public void setTiposeleccionado(TipoMotivo tiposeleccionado) {
		this.tiposeleccionado = tiposeleccionado;
	}

    public Integer getIdTipoMotivo() {
		return idTipoMotivo;
	}
	public void setIdTipoMotivo(Integer idTipoMotivo) {
		this.idTipoMotivo = idTipoMotivo;
	}
	//Fin de los metodod gets y sets
   
	//----------- OTROS METODOS
    @Init
    public void init(){
      	listadoTipoMotivo();
      	
    } 
    
    /**
	 * guardarTipoMotivo
	 * 
	 * @param idTipoMotivo
	 *            , nombreTipoMotivo, descripcion, listaTipoMotivo
	 * @return No devuelve ningun valor
	 * @throws No
	 *             debe haber campos en blanco
	 */
    @Command
	@NotifyChange({"idTipoMotivo","nombreTipoMotivo", "descripcion","estatus","listaTipoMotivo"})//el notifychange le  avisa a que parametros en la pantalla se van a cambiar, en este caso es nombre,apellido,email,sexo se va a colocar en blanco al guardar!!
	public void guardarTipoMotivo(){
    	if (nombreTipoMotivo == null || nombreTipoMotivo.equals("") || descripcion.equals("") || descripcion == null) {
			mensajeAlUsuario.advertenciaLlenarCampos();
		} else {
			TipoMotivo tipo = new TipoMotivo(idTipoMotivo, descripcion, true, nombreTipoMotivo, false);
			serviciotipomotivo.guardarTipoMotivo(tipo);
			mensajeAlUsuario.informacionRegistroCorrecto();
			limpiar();
		}
	}
    	
	/**
	 * listaTipoMotivo
	 * 
	 * @param listaTipoMotivo
	 * @return No devuelve ningun valor
	 * @throws No
	 *             dispara ninguna excepci�n
	 */

 	@Command
 	@NotifyChange({ "listaTipoMotivo" })
 	public void listadoTipoMotivo() {
 		listaTipoMotivo = serviciotipomotivo.listadoTipoMotivo();
 	}	

 	/**
	 * limpiar
	 * 
	 * @param idTipoMotivo
	 *            , nombreTipoMotivo, descripcion, listaTipoMotivo, estatus
	 * @return No devuelve ningun valor
	 * @throws No
	 *             dispara ninguna excepci�n
	 */
    @Command
	@NotifyChange({"listaTipoMotivo","idTipoMotivo","nombreTipoMotivo", "estatus","descripcion"})
	public void limpiar(){
    	idTipoMotivo= null;
    	nombreTipoMotivo = "";
		descripcion="";
		listadoTipoMotivo();
	}
    
    
    /**
	 * eliminarTipoMotivo
	 * 
	 * @param idTipoMotivo
	 *            , nombreTipoMotivo, estatus, descripcion, listaTipoMotivo
	 * @return No devuelve ningun valor
	 * @throws Debe
	 *             seleccionar un registro para poder eliminarlo
	 */
  	@Command
  	@NotifyChange({"listaTipoMotivo","nombreTipoMotivo", "descripcion"})
  	public void eliminarTipoMotivo(){
  		if (nombreTipoMotivo==null || nombreTipoMotivo.equals("") || descripcion==null || descripcion.equals("") ){
  			mensajeAlUsuario.advertenciaSeleccionarParaEliminar();
		}
		else{
  		serviciotipomotivo.eliminarTipoMotivo(getTiposeleccionado().getIdTipoMotivo());
  		mensajeAlUsuario.informacionEliminarCorrecto();
  		limpiar();
  	}
  	}
  	
  	
  	/**
	 * mostrarSeleccionado
	 * 
	 * @param idTipoMotivo
	 *            , nombreTipoMotivo, estatus, descripcion
	 * @return No devuelve ningun valor
	 * @throws No
	 *             dispara ninguna excepci�n
	 */
    @Command
	@NotifyChange({"idTipoMotivo","nombreTipoMotivo", "descripcion","estatus"})
	public void mostrarSeleccionado(){
    	idTipoMotivo=getTiposeleccionado().getIdTipoMotivo();
		nombreTipoMotivo= getTiposeleccionado().getNombreTipoMotivo();
		descripcion=getTiposeleccionado().getDescripcion();	
	}
    
    
    
    
    // M�todo que busca y filtra las sanciones
 	@Command
 	@NotifyChange({ "listaTipoMotivo" })
 	public void filtros() {
 		listaTipoMotivo = serviciotipomotivo.buscarTipoMotivo(filtros);
 	}
}
