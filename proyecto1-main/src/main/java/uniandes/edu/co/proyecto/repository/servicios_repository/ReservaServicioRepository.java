package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.primaryKeys.ReservaServicioPK;
import uniandes.edu.co.proyecto.model.servicios.ReservaServicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, ReservaServicioPK> {

        // Método para listar todas las reservas de servicio
        @Query(value = "SELECT * FROM reservas_servicio", nativeQuery = true)
        Collection<ReservaServicio> listarReservasServicio();

        // Método para buscar una reserva de servicio por su clave primaria (pk)
        @Query(value = "SELECT * FROM reservas_servicio WHERE id_habitacion = :idHabitacion AND id_servicio = :idServicio AND fecha = :fecha AND hora_inicio = :horaInicio AND hora_fin = :horaFin AND costo = :costo", nativeQuery = true)
        ReservaServicio buscarReservaServicioPorPK(@Param("idHabitacion") int idHabitacion,
                        @Param("idServicio") int idServicio, @Param("fecha") Date fecha,
                        @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin, @Param("costo") int costo);

        // Método para insertar una nueva reserva de servicio
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservas_servicio (id_habitacion, id_servicio, fecha, hora_inicio, hora_fin, costo) VALUES (:idHabitacion, :idServicio, :fecha, :horaInicio, :horaFin, :costo)", nativeQuery = true)
        void insertarReservaServicio(@Param("idHabitacion") int idHabitacion, @Param("idServicio") int idServicio,
                        @Param("fecha") Date fecha, @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin, @Param("costo") int costo);

        // Método para actualizar una reserva de servicio
        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas_servicio SET fecha = :fecha, hora_inicio = :horaInicio, hora_fin = :horaFin, costo = :costo WHERE id_habitacion = :idHabitacion AND id_servicio = :idServicio AND fecha = :fecha, hora_inicio = :horaInicio, hora_fin = :horaFin", nativeQuery = true)
        void actualizarReservaServicio(@Param("idHabitacion") int idHabitacion, @Param("idServicio") int idServicio,
                        @Param("fecha") Date fecha, @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin,
                        @Param("costo") int costo);

        // Método para eliminar una reserva de servicio por su clave primaria (pk)
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservas_servicio WHERE id_habitacion = :idHabitacion AND id_servicio = :idServicio AND fecha = :fecha AND hora_inicio = :horaInicio AND hora_fin = :horaFin AND costo = :costo", nativeQuery = true)
        void eliminarReservaServicioPorPK(@Param("idHabitacion") int idHabitacion, @Param("idServicio") int idServicio,
                        @Param("fecha") Date fecha, @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin, @Param("costo") int costo);
}
