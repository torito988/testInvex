package mx.com.java.prieto.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.java.prieto.persistence.entity.EmpleadoEntity;
import mx.com.java.prieto.persistence.repository.EmpleadoRepository;
import mx.com.java.prieto.services.EmpleadoServices;
import mx.com.java.prieto.util.exceptions.InvexException;
import mx.com.java.prieto.util.payload.EmpleadoPayload;

@Service
public class EmpleadoServicesImpl implements EmpleadoServices{
	
	private static final Logger LOGGER = LogManager.getLogger(EmpleadoServicesImpl.class);
	
	@Autowired	
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoPayload> consultarTodosEmpleados() throws InvexException {
		List<EmpleadoPayload> listaEmpleadosMapper =  new ArrayList<>();
		List<EmpleadoEntity> listaEmpleadosRepository = new ArrayList<>();
		try {
			listaEmpleadosRepository = empleadoRepository.findAllEmployeeActive();
			LOGGER.info("Extraccion de empleados");
			for (EmpleadoEntity empleadoEntity : listaEmpleadosRepository) {
				EmpleadoPayload empleadoPayload = new EmpleadoPayload();
				empleadoPayload.setIdEmpleado(empleadoEntity.getId());
				empleadoPayload.setPrimerNombre(empleadoEntity.getPrimerNombre());
				empleadoPayload.setSegundoNombre(empleadoEntity.getSegundoNombre());
				empleadoPayload.setApellidoPaterno(empleadoEntity.getAppPaterno());
				empleadoPayload.setApellidoMaterno(empleadoEntity.getAppMaterno());
				empleadoPayload.setEdad(empleadoEntity.getEdad());
				empleadoPayload.setSexo(empleadoEntity.getSexo());
				empleadoPayload.setFechaNacimiento(empleadoEntity.getFechaNac());
				empleadoPayload.setPuesto(empleadoEntity.getPuesto());
				listaEmpleadosMapper.add(empleadoPayload);
			}
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al momento de realizar el mappe del payload " + e.getMessage());
			throw new InvexException("Ocurrio un error al momento de realizar el mappe del payload " + e.getMessage(), e);
		}
		return listaEmpleadosMapper;
	}

	@Override
	public void borrarEmpleado(Integer idEmpleado) throws InvexException {
		LOGGER.info("Realizando borrado de empleado");
		try {
			EmpleadoEntity empleadoEntity = new EmpleadoEntity();
			empleadoEntity = empleadoRepository.findEmployeeActive(idEmpleado);
			LOGGER.info("Validando la existencia del empleado a borrar");
			empleadoEntity.setVisible(1);	
			empleadoRepository.save(empleadoEntity);
			LOGGER.info("Empleado borrando de manera logica");
		} catch (Exception e) {
			LOGGER.error("Empleado no encontrado " + e.getMessage());
			throw new InvexException("Empleado no encontrado " + e.getMessage(), e);
		}
		
		
	}

	@Override
	public EmpleadoPayload actualizarEmpleado(EmpleadoPayload empleadoPayload) throws InvexException {
		LOGGER.info("Realizando actualizacion de empleado");
		try {
			EmpleadoEntity empleadoEntity = new EmpleadoEntity();
			empleadoEntity = empleadoRepository.findEmployeeActive(empleadoPayload.getIdEmpleado());
			LOGGER.info("Validando la existencia del empleado a actualizar");
			empleadoEntity.setPrimerNombre(empleadoPayload.getPrimerNombre());
			empleadoEntity.setSegundoNombre(empleadoPayload.getSegundoNombre());
			empleadoEntity.setAppPaterno(empleadoPayload.getApellidoPaterno());
			empleadoEntity.setAppMaterno(empleadoPayload.getApellidoMaterno());
			empleadoEntity.setEdad(empleadoPayload.getEdad());
			empleadoEntity.setSexo(empleadoPayload.getSexo());
			empleadoEntity.setFechaNac(empleadoPayload.getFechaNacimiento());
			empleadoEntity.setPuesto(empleadoPayload.getPuesto());
			empleadoRepository.save(empleadoEntity);
			LOGGER.info("Empleado actualizado");
		} catch (Exception e) {
			LOGGER.error("Empleado no encontrado " + e.getMessage());
			throw new InvexException("Empleado no encontrado " + e.getMessage(), e);
		}
		return empleadoPayload;
	}

	@Override
	public List<EmpleadoPayload> crearEmpleado(List<EmpleadoPayload> listaEmpleadoPayload) throws InvexException {
		LOGGER.info("Realizando la inserccion de empleados(s)");
		try {
			List<EmpleadoEntity> listaEmpleadoEntity = new ArrayList<>();
			for (EmpleadoPayload empleadoPayload : listaEmpleadoPayload) {
				EmpleadoEntity empleadoEntity = new EmpleadoEntity();
				empleadoEntity.setPrimerNombre(empleadoPayload.getPrimerNombre());
				empleadoEntity.setSegundoNombre(empleadoPayload.getSegundoNombre());
				empleadoEntity.setAppPaterno(empleadoPayload.getApellidoPaterno());
				empleadoEntity.setAppMaterno(empleadoPayload.getApellidoMaterno());
				empleadoEntity.setEdad(empleadoPayload.getEdad());
				empleadoEntity.setSexo(empleadoPayload.getSexo());
				empleadoEntity.setFechaNac(empleadoPayload.getFechaNacimiento());
				empleadoEntity.setPuesto(empleadoPayload.getPuesto());
				empleadoEntity.setVisible(0);
				listaEmpleadoEntity.add(empleadoEntity);
			}
			LOGGER.info("Ejecutuando guardado");
			empleadoRepository.saveAll(listaEmpleadoEntity);
		} catch (Exception e) {
			LOGGER.error("No se puedieron realizar la o las insercciones " + e.getMessage());
			throw new InvexException("No se puedieron realizar la o las insercciones " + e.getMessage(), e);
		}
		return listaEmpleadoPayload;
	}



}
