package mx.com.java.prieto.util.payload;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name="Empleado", description="Atributos de los Empleados")
@Data
public class EmpleadoPayload {
	
	@JsonInclude(Include.NON_NULL)
	Integer idEmpleado;
	@Schema(example = "Juan")
	String primerNombre;
	@Schema(example = "Manuel")
	String segundoNombre;
	@Schema(example = "Trencillo")
	String apellidoPaterno;
	@Schema(example = "Samudio")
	String apellidoMaterno;
	@Schema(example = "34")
	Integer edad;
	@Schema(example = "H")
	String sexo;
	@Schema(example = "10-10-1987")
	@JsonFormat(pattern = "dd-MM-yyyy", locale = "es-MX", timezone = "America/Mexico_City")
	Date fechaNacimiento;
	@Schema(example = "Developer Jr")
	String puesto;

}
