package uniandes.edu.co.proyecto.repository;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.CheckOut;

public interface CheckOutRepository extends JpaRepository<CheckOut, Integer> {

        // Método para listar todos los check-outs
        @Query(value = "SELECT * FROM check_outs", nativeQuery = true)
        Collection<CheckOut> listarCheckOuts();

        // Método para buscar un check-out por su check in asociado
        @Query(value = "SELECT * FROM check_outs WHERE id_check_in = :id_check_in", nativeQuery = true)
        CheckOut buscarCheckOutPorId(@Param("id_check_in") int id_check_in);

        // Método para insertar un nuevo check-out
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO check_outs (id_check_in, fecha, hora, ingresos_totales) VALUES (:id_check_in, :fecha, :hora, :ingresosTotales)", nativeQuery = true)
        void insertarCheckOut(@Param("id_check_in") int id_check_in, @Param("fecha") Date fecha,
                        @Param("hora") String horaSalida,
                        @Param("ingresosTotales") Integer ingresosTotales);

        // Método para actualizar un check-out
        @Modifying
        @Transactional
        @Query(value = "UPDATE check_outs SET fecha = :fecha, hora = :hora, ingresos_totales = :ingresosTotales WHERE id_check_in = :id_check_in", nativeQuery = true)
        void actualizarCheckOut(@Param("id_check_in") int id_check_in, @Param("fecha") Date fecha,
                        @Param("hora") String horaSalida,
                        @Param("ingresosTotales") Integer ingresosTotales);

        // Método para eliminar un check-out por su reserva de habitación asociada
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM check_outs WHERE id_check_in = :id_check_in", nativeQuery = true)
        void eliminarCheckOutPorid(@Param("id_check_in") int id_check_in);
}
