package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, String> {

    // Método para listar todas las habitaciones
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> listarHabitaciones();

    // Método para buscar una habitación por su id
    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion buscarHabitacionPorId(@Param("id") String id);

    // Método para insertar una nueva habitación
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, tipo) VALUES (:id, :tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("id") String id, @Param("tipo") int tipo);

    // Método para actualizar una habitación
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") String id, @Param("tipo") int tipo);

    // Método para eliminar una habitación por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacionPorId(@Param("id") String id);
}