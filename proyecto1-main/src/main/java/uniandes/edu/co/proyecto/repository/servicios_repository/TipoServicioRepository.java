package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.model.servicios.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
    // Método para listar todos los tipos de servicio
    @Query(value = "SELECT * FROM tipos_servicio", nativeQuery = true)
    Collection<TipoHabitacion> listarTiposServicio();

    // Método para buscar un tipo de servicio por su nombre
    @Query("SELECT ts FROM TipoServicio ts WHERE ts.id = :id")
    TipoServicio buscarTipoServicioPorId(@Param("id") Integer id);

    // Método para insertar un nuevo tipo de servicio
    @Modifying
    @Transactional
    @Query("INSERT INTO TipoServicio (nombre) VALUES (:nombre)")
    void insertarTipoServicio(@Param("nombre") String nombre);

    // Método para actualizar un tipo de servicio por su nombre
    @Modifying
    @Transactional
    @Query("UPDATE TipoServicio ts SET ts.nombre = :nombreNuevo WHERE ts.id = :id")
    void actualizarTipoServicio(@Param("id") Integer id, @Param("nombreNuevo") String nombreNuevo);

    // Método para eliminar un tipo de servicio por su nombre
    @Modifying
    @Transactional
    @Query("DELETE FROM TipoServicio ts WHERE ts.id = :id")
    void eliminarTipoServicioPorId(@Param("id") Integer id);
}
