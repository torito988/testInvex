package mx.com.java.prieto.persistence.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "empleado")
@Data
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceSubCategoryId")
    @SequenceGenerator(name = "SequenceSubCategoryId", sequenceName = "seq_empleado_id", allocationSize = 1)
	@Column(name = "id_empleado")
    private Integer id;
	
	@Column(name = "prime_nombre")
    private String primerNombre;
	
	@Column(name = "segundo_nombre")
    private String segundoNombre;
	
	@Column(name = "apellido_paterno")
    private String appPaterno;
	
	@Column(name = "apellido_materno")
    private String appMaterno;
	
	@Column(name = "edad")
    private Integer edad;
	
	@Column(name = "sexo")
    private String sexo;
	
	@Column(name = "fecha_nac")
    private Date fechaNac;
	
	@Column(name = "puesto")
    private String puesto;
	
	@Column(name = "visible")
    private Integer visible;

}
