package mx.com.java.prieto.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.java.prieto.persistence.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository  extends JpaRepository<EmpleadoEntity, Integer> {
	
	@Query("SELECT e FROM EmpleadoEntity e WHERE e.visible=0")
	List<EmpleadoEntity> findAllEmployeeActive();
	
	@Query("SELECT e FROM EmpleadoEntity e WHERE e.visible=0 AND e.id = :id")
	EmpleadoEntity findEmployeeActive(@Param("id") Integer id);

}
