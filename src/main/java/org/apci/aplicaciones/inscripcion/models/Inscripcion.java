package org.apci.aplicaciones.inscripcion.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inscripcion {
	private int InscripcionId;
	private String NombreInstitucion;
	private String Departamento;
	private String Provincia;
	private String Distrito;	
	private String DireccionInstitucion;
	private int NumeroRegistroAPCI;
	private String TelefonoInstitucion;
	private String EmailInstitucion;
	private String DirectivoNombre;
	private String DirectivoCargo;
	private String DirectivoDNI;
	private String DirectivoTelefono;
	private String DirectivoCelular;
	private String DirectivoEmail;
	private String ContactoNombre;
	private String ContactoCargo;
	private String ContactoDNI;
	private String ContactoTelefono;
	private String ContactoCelular;
	private String ContactoEmail;
	private String Usuario;
	private String Hash;
	private int InstitucionId;
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getDistrito() {
		return Distrito;
	}
	public void setDistrito(String distrito) {
		Distrito = distrito;
	}
	public String getDepartamento() {
		return Departamento;
	}
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
	public int getInscripcionId() {
		return InscripcionId;
	}
	public void setInscripcionId(int inscripcionId) {
		InscripcionId = inscripcionId;
	}
	public String getNombreInstitucion() {
		return NombreInstitucion;
	}
	public void setNombreInstitucion(String nombreInstitucion) {
		NombreInstitucion = nombreInstitucion;
	}
	public String getDireccionInstitucion() {
		return DireccionInstitucion;
	}
	public void setDireccionInstitucion(String direccionInstitucion) {
		DireccionInstitucion = direccionInstitucion;
	}
	public int getNumeroRegistroAPCI() {
		return NumeroRegistroAPCI;
	}
	public void setNumeroRegistroAPCI(int numeroRegistroAPCI) {
		NumeroRegistroAPCI = numeroRegistroAPCI;
	}
	public String getTelefonoInstitucion() {
		return TelefonoInstitucion;
	}
	public void setTelefonoInstitucion(String telefonoInstitucion) {
		TelefonoInstitucion = telefonoInstitucion;
	}
	public String getEmailInstitucion() {
		return EmailInstitucion;
	}
	public void setEmailInstitucion(String emailInstitucion) {
		EmailInstitucion = emailInstitucion;
	}
	public String getDirectivoNombre() {
		return DirectivoNombre;
	}
	public void setDirectivoNombre(String directivoNombre) {
		DirectivoNombre = directivoNombre;
	}
	public String getDirectivoCargo() {
		return DirectivoCargo;
	}
	public void setDirectivoCargo(String directivoCargo) {
		DirectivoCargo = directivoCargo;
	}
	public String getDirectivoDNI() {
		return DirectivoDNI;
	}
	public void setDirectivoDNI(String directivoDNI) {
		DirectivoDNI = directivoDNI;
	}
	public String getDirectivoTelefono() {
		return DirectivoTelefono;
	}
	public void setDirectivoTelefono(String directivoTelefono) {
		DirectivoTelefono = directivoTelefono;
	}
	public String getDirectivoCelular() {
		return DirectivoCelular;
	}
	public void setDirectivoCelular(String directivoCelular) {
		DirectivoCelular = directivoCelular;
	}
	public String getDirectivoEmail() {
		return DirectivoEmail;
	}
	public void setDirectivoEmail(String directivoEmail) {
		DirectivoEmail = directivoEmail;
	}
	public String getContactoNombre() {
		return ContactoNombre;
	}
	public void setContactoNombre(String contactoNombre) {
		ContactoNombre = contactoNombre;
	}
	public String getContactoCargo() {
		return ContactoCargo;
	}
	public void setContactoCargo(String contactoCargo) {
		ContactoCargo = contactoCargo;
	}
	public String getContactoDNI() {
		return ContactoDNI;
	}
	public void setContactoDNI(String contactoDNI) {
		ContactoDNI = contactoDNI;
	}
	public String getContactoTelefono() {
		return ContactoTelefono;
	}
	public void setContactoTelefono(String contactoTelefono) {
		ContactoTelefono = contactoTelefono;
	}
	public String getContactoCelular() {
		return ContactoCelular;
	}
	public void setContactoCelular(String contactoCelular) {
		ContactoCelular = contactoCelular;
	}
	public String getContactoEmail() {
		return ContactoEmail;
	}
	public void setContactoEmail(String contactoEmail) {
		ContactoEmail = contactoEmail;
	}
	public String getHash() {
		return Hash;
	}
	public void setHash(String hash) {
		Hash = hash;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public int getInstitucionId() {
		return InstitucionId;
	}
	public void setInstitucionId(int institucionId) {
		InstitucionId = institucionId;
	}
}
