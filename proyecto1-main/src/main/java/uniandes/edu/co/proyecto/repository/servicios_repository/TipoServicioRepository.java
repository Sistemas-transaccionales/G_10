package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
    // Método para listar todos los tipos de servicio
    @Query(value = "SELECT * FROM tipos_servicio", nativeQuery = true)
    Collection<TipoServicio> listarTiposServicio();

    // Método para buscar un tipo de servicio por su nombre
    @Query(value = "SELECT * FROM tipos_servicio WHERE id = :id", nativeQuery = true)
    TipoServicio buscarTipoServicioPorId(@Param("id") Integer id);

    // Método para insertar un nuevo tipo de servicio
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipos_servicio (id, nombre) VALUES (:id, :nombre)", nativeQuery = true)
    void insertarTipoServicio(@Param("id") int id, @Param("nombre") String nombre);

    // Método para actualizar un tipo de servicio por su nombre
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipos_servicio SET nombre = :new_name WHERE id = :id", nativeQuery = true)
    void actualizarTipoServicio(@Param("id") Integer id, @Param("new_name") String new_name);

    // Método para eliminar un tipo de servicio por su nombre
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipos_servicio WHERE id = :id", nativeQuery = true)
    void eliminarTipoServicioPorId(@Param("id") Integer id);
}
