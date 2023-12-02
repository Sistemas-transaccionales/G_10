package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.Dotadas;

public interface DotadasRepository extends JpaRepository<Dotadas, Integer> {

    // Método para listar todas las relaciones Dotadas
    @Query(value = "SELECT * FROM dotadas", nativeQuery = true)
    Collection<Dotadas> listarDotadas();

    // Método para buscar una relación Dotadas por su id
    @Query(value = "SELECT * FROM dotadas WHERE id_tipo_habitacion = :id_tipo_habitacion AND id_dotacion = :id_dotacion", nativeQuery = true)
    Dotadas buscarDotadasPorId(@Param("id_tipo_habitacion") int id_tipo_habitacion,
            @Param("id_dotacion") int id_dotacion);

    // Método para insertar una relación Dotadas
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO dotadas (id_tipo_habitacion, id_dotacion) VALUES (:id_tipo_habitacion, :id_dotacion)", nativeQuery = true)
    void insertarDotadas(@Param("id_tipo_habitacion") int id_tipo_habitacion, @Param("id_dotacion") int id_dotacion);

    // // Método para actualizar una relación Dotadas
    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE dotadas SET id_habitacion = :id_habitacion,
    // id_dotacion = :id_dotacion WHERE id = :id", nativeQuery = true)
    // void actualizarDotadas(@Param("id") int id, @Param("id_habitacion") int
    // idHabitacion,
    // @Param("id_dotacion") int idDotacion);

    // Método para eliminar una relación Dotadas por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM dotadas WHERE id_tipo_habitacion = :id_tipo_habitacion AND id_dotacion = :id_dotacion", nativeQuery = true)
    void eliminarDotadasPorId(@Param("id_tipo_habitacion") int id_tipo_habitacion,
            @Param("id_dotacion") int id_dotacion);
}