package uniandes.edu.co.proyecto.repository;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.CheckIn;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;

public interface CheckInRepository extends JpaRepository<CheckIn, ReservaHabitacion> {

    // Método para listar todos los check-ins
    @Query(value = "SELECT * FROM check_ins", nativeQuery = true)
    Collection<CheckIn> listarCheckIns();

    // Método para buscar un check-in por su reserva de habitación asociada
    @Query(value = "SELECT * FROM check_ins WHERE id = :id", nativeQuery = true)
    CheckIn buscarCheckInPorId(@Param("id") int id);

    // Método para insertar un nuevo check-in
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO check_ins (id, id_habitacion, num_doc, tipo_doc, fecha, hora) VALUES (id_check_ins.NEXTVAL, :id_habitacion, :num_doc, :tipo_doc, :fecha, :hora)", nativeQuery = true)
    public void insertarCheckIn(@Param("id_habitacion") int idHabitacion, @Param("num_doc") int numDoc,
            @Param("tipo_doc") String tipoDoc, @Param("fecha") Date fecha, @Param("hora") String hora);

    // Método para actualizar un check-in
    @Modifying
    @Transactional
    @Query(value = "UPDATE check_ins SET fecha = :fecha, hora = :horaLlegada WHERE id = :id", nativeQuery = true)
    void actualizarCheckIn(@Param("id") int id, @Param("fecha") Date fecha, @Param("horaLlegada") String horaLlegada);

    // Método para eliminar un check-in por su reserva de habitación asociada
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM check_ins WHERE id = :id", nativeQuery = true)
    void eliminarCheckInPorId(@Param("id") int id);
}
