package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;
import uniandes.edu.co.proyecto.model.primaryKeys.ReservaHabitacionPK;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, ReservaHabitacionPK> {

        // Método para listar todas las reservas de habitaciones
        @Query(value = "SELECT * FROM reservas_habitacion", nativeQuery = true)
        Collection<ReservaHabitacion> listarReservasHabitacion();

        // Método para buscar una reserva de habitación por su clave primaria compuesta
        @Query(value = "SELECT * FROM reservas_habitacion WHERE id_habitacion = :idHabitacion AND numDoc = :numDoc AND tipoDoc = :tipoDoc AND fecha_entrada = :fechaEntrada AND fecha_salida = :fechaSalida", nativeQuery = true)
        ReservaHabitacion buscarReservaHabitacionPorPK(@Param("idHabitacion") String idHabitacion,
                        @Param("numDoc") int numDoc,
                        @Param("tipoDoc") String tipoDoc, @Param("fechaEntrada") Date fechaEntrada,
                        @Param("fechaSalida") Date fechaSalida);

        // Método para insertar una nueva reserva de habitación
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reservas_habitacion (id_habitacion, num_doc, tipo_doc, fecha_entrada, fecha_salida, plan_consumo, num_personas, costo, id_cuenta) VALUES (:idHabitacion, :numDoc, :tipoDoc :fechaEntrada, :fechaSalida, :planConsumoId, :numPersonas, :costo, :idCuenta)", nativeQuery = true)
        void insertarReservaHabitacion(@Param("idHabitacion") String idHabitacion, @Param("numDoc") int numDoc,
                        @Param("tipoDoc") String tipoDoc,
                        @Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida,
                        @Param("planConsumoId") int planConsumoId, @Param("numPersonas") int numPersonas,
                        @Param("costo") int costo, @Param("idCuenta") int idCuenta);

        // Método para actualizar una reserva de habitación
        @Modifying
        @Transactional
        @Query(value = "UPDATE reservas_habitacion SET plan_consumo = :planConsumoId, num_personas = :numPersonas, costo = :costo WHERE id_habitacion = :idHabitacion AND numDoc = :numDoc AND tipoDoc = :tipoDoc AND fecha_entrada = :fechaEntrada AND fecha_salida = :fechaSalida", nativeQuery = true)
        void actualizarReservaHabitacion(@Param("idHabitacion") String idHabitacion, @Param("numDoc") int numDoc,
                        @Param("tipoDoc") String tipoDoc,
                        @Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida,
                        @Param("planConsumoId") int planConsumoId, @Param("numPersonas") int numPersonas,
                        @Param("costo") int costo);

        // Método para eliminar una reserva de habitación por su clave primaria
        // compuesta
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reservas_habitacion WHERE id_habitacion = :idHabitacion AND numDoc = :numDoc AND tipoDoc = :tipoDoc AND fecha_entrada = :fechaEntrada AND fecha_salida = :fechaSalida", nativeQuery = true)
        void eliminarReservaHabitacionPorPK(@Param("idHabitacion") String idHabitacion, @Param("numDoc") int numDoc,
                        @Param("tipoDoc") String tipoDoc,
                        @Param("fechaEntrada") Date fechaEntrada, @Param("fechaSalida") Date fechaSalida);
}
