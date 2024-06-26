package mx.com.java.prieto.services;

import java.util.List;

import mx.com.java.prieto.util.exceptions.InvexException;
import mx.com.java.prieto.util.payload.EmpleadoPayload;

public interface EmpleadoServices {
	
	List<EmpleadoPayload> consultarTodosEmpleados() throws InvexException; 
	void borrarEmpleado(Integer idEmpleado) throws InvexException;
	EmpleadoPayload actualizarEmpleado(EmpleadoPayload empleadoPayload) throws InvexException;
	List<EmpleadoPayload> crearEmpleado(List<EmpleadoPayload> listaEmpleadoPayload) throws InvexException;

}
