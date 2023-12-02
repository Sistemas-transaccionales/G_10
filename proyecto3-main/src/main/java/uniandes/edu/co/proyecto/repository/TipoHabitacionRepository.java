package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

        // Método para listar todos los tipos de habitación
        @Query(value = "SELECT * FROM tipos_habitacion", nativeQuery = true)
        Collection<TipoHabitacion> listarTiposHabitacion();

        // Método para buscar un tipo de habitación por su id
        @Query(value = "SELECT * FROM tipos_habitacion WHERE id = :id", nativeQuery = true)
        TipoHabitacion buscarTipoHabitacionPorId(@Param("id") int id);

        // Método para insertar un nuevo tipo de habitación
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO tipos_habitacion (id, nombre, costo_por_noche, capacidad) VALUES (:id, :nombre, :costo_por_noche, :capacidad)", nativeQuery = true)
        void insertarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre,
                        @Param("costo_por_noche") int costo_por_noche,
                        @Param("capacidad") int capacidad);

        // Método para actualizar un tipo de habitación
        @Modifying
        @Transactional
        @Query(value = "UPDATE tipos_habitacion SET nombre = :nombre, costo_por_noche = :costo_por_noche, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
        void actualizarTipoHabitacion(@Param("id") int id, @Param("nombre") String nombre,
                        @Param("costo_por_noche") int costoPorNoche, @Param("capacidad") int capacidad);

        // Método para eliminar un tipo de habitación por su id
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM tipos_habitacion WHERE id = :id", nativeQuery = true)
        void eliminarTipoHabitacionPorId(@Param("id") int id);
}