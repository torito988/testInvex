package mx.com.java.prieto.util.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmpleadoModel {
	
	Integer idEmpleado;
	String primerNombre;
	String segundoNombre;
	String appPaterno;
	String appMaterno;
	Integer edad;
	String sexo;
	Date fechaNac;
	String puesto;

}
