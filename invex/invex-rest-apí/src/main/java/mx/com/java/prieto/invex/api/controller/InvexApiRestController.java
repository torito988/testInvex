package mx.com.java.prieto.invex.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.com.java.prieto.services.EmpleadoServices;
import mx.com.java.prieto.util.exceptions.InvexException;
import mx.com.java.prieto.util.payload.EmpleadoPayload;

@Tag(name="Empleados", description="Endpoints para la gestion de empleados")
@RestController
@RequestMapping("/api/empleados")
public class InvexApiRestController {
	
	private static final Logger LOGGER = LogManager.getLogger(InvexApiRestController.class);
	
	@Autowired
	private EmpleadoServices empleadoServices;
	
	@Operation(summary="En lista los empleados", description="En lista todos los empleados")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Consulta satisfactoria", content = { @Content(schema = @Schema(implementation = EmpleadoPayload.class), mediaType = "application/json") }), 
	        @ApiResponse(responseCode = "500", description = "Consulta no satisfactoria por motivo de errores")
	    })
	@GetMapping(value = "/getEmpleados")
	public ResponseEntity<Object> consultarEmpleados() {
		LOGGER.info("Consultando todos los empleados");
		try {
			return new ResponseEntity<>(empleadoServices.consultarTodosEmpleados(), HttpStatus.OK);
		} catch (InvexException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary="Borrado de un empleado en particular", description="Borra a un empleado en particular mediante su Id")
	@PutMapping(value = "/borrar/{idEmpleado}")
	public ResponseEntity<Object> borrarEmpleado(@PathVariable Integer idEmpleado){
		LOGGER.info("Realizando boorado de empleado por Id");
		try {
			empleadoServices.borrarEmpleado(idEmpleado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (InvexException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary="Actualizacion de un empleado en particular", description="Actualiza a un empleado en particular mediante su Id")
	@PutMapping(value = "/update")
	public ResponseEntity<Object> actualizarEmpleado(@RequestBody EmpleadoPayload empleadoPayload){
		LOGGER.info("Realizando actualizacion de empleado");
		try {
			return new ResponseEntity<>(empleadoServices.actualizarEmpleado(empleadoPayload), HttpStatus.OK);
		} catch (InvexException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary="Generacion de uno o mas empleados", description="Genera uno o mas empleados de acuerdo a la peticion que reciba")
	@PostMapping(value = "/create")
	public ResponseEntity<Object> creaerEmpleado(@RequestBody List<EmpleadoPayload> listaEmpleadoPayload){
		LOGGER.info("Realizando insercion de empleado(s)");
		try {
			return new ResponseEntity<>(empleadoServices.crearEmpleado(listaEmpleadoPayload), HttpStatus.CREATED);
		} catch (InvexException e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
