package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import java.sql.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.CheckOut;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;

public interface CheckOutRepository extends JpaRepository<CheckOut, ReservaHabitacion> {

    // Método para listar todos los check-outs
    @Query(value = "SELECT * FROM check_outs", nativeQuery = true)
    Collection<CheckOut> listarCheckOuts();

    // Método para buscar un check-out por su reserva de habitación asociada
    @Query(value = "SELECT * FROM check_outs WHERE id_reserva = :reserva", nativeQuery = true)
    CheckOut buscarCheckOutPorReserva(@Param("reserva") ReservaHabitacion reserva);

    // Método para insertar un nuevo check-out
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO check_outs (id_reserva, hora_salida, ingresos_totales) VALUES (:reserva, :horaSalida, :ingresosTotales)", nativeQuery = true)
    void insertarCheckOut(@Param("reserva") ReservaHabitacion reserva, @Param("horaSalida") Time horaSalida, @Param("ingresosTotales") Integer ingresosTotales);

    // Método para actualizar un check-out
    @Modifying
    @Transactional
    @Query(value = "UPDATE check_outs SET hora_salida = :horaSalida, ingresos_totales = :ingresosTotales WHERE id_reserva = :reserva", nativeQuery = true)
    void actualizarCheckOut(@Param("reserva") ReservaHabitacion reserva, @Param("horaSalida") Time horaSalida, @Param("ingresosTotales") Integer ingresosTotales);

    // Método para eliminar un check-out por su reserva de habitación asociada
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM check_outs WHERE id_reserva = :reserva", nativeQuery = true)
    void eliminarCheckOutPorReserva(@Param("reserva") ReservaHabitacion reserva);
}
