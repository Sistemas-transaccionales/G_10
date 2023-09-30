package uniandes.edu.co.proyecto.repository;

import java.sql.Time;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.CheckIn;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;
import uniandes.edu.co.proyecto.model.CuentaEstadia;

public interface CheckInRepository extends JpaRepository<CheckIn, ReservaHabitacion> {

    // Método para listar todos los check-ins
    @Query(value = "SELECT * FROM check_ins", nativeQuery = true)
    Collection<CheckIn> listarCheckIns();

    // Método para buscar un check-in por su reserva de habitación asociada
    @Query(value = "SELECT * FROM check_ins WHERE id_reserva = :reserva", nativeQuery = true)
    CheckIn buscarCheckInPorReserva(@Param("reserva") ReservaHabitacion reserva);

    // Método para insertar un nuevo check-in
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO check_ins (id_reserva, hora_llegada, id_cuenta) VALUES (:reserva, :horaLlegada, :cuenta)", nativeQuery = true)
    void insertarCheckIn(@Param("reserva") ReservaHabitacion reserva, @Param("horaLlegada") Time horaLlegada, @Param("cuenta") CuentaEstadia cuenta);

    // Método para actualizar un check-in
    @Modifying
    @Transactional
    @Query(value = "UPDATE check_ins SET hora_llegada = :horaLlegada, id_cuenta = :cuenta WHERE id_reserva = :reserva", nativeQuery = true)
    void actualizarCheckIn(@Param("reserva") ReservaHabitacion reserva, @Param("horaLlegada") Time horaLlegada, @Param("cuenta") CuentaEstadia cuenta);

    // Método para eliminar un check-in por su reserva de habitación asociada
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM check_ins WHERE id_reserva = :reserva", nativeQuery = true)
    void eliminarCheckInPorReserva(@Param("reserva") ReservaHabitacion reserva);
}
