package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.Dotacion;

public interface DotacionRepository extends JpaRepository<Dotacion, Integer> {

    @Query(value = "SELECT * FROM dotaciones", nativeQuery = true)
    Collection<Dotacion> darDotaciones();

    @Query(value = "SELECT * FROM dotaciones WHERE id= :id", nativeQuery = true)
    Dotacion darDotacion(@Param("id") int id);

    // Método para insertar una dotación:
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO dotaciones (id, nombre) VALUES(:id, :nombre)", nativeQuery = true)
    void insertarDotacion(@Param("id") int id, @Param("nombre") String nombre);

    // Método para actualizar una dotación:
    @Modifying
    @Transactional
    @Query(value = "UPDATE dotaciones SET nombre= :nombre WHERE id= :id", nativeQuery = true)
    void actualizarDotacion(@Param("id") int id, @Param("nombre") String nombre);

    // Método para eliminar una dotación:
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM dotaciones WHERE id =:id", nativeQuery = true)
    void actualizarDotacion(@Param("id") int id);

}