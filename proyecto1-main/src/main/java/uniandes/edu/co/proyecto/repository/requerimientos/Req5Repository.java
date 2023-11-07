package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento5;

public interface Req5Repository extends JpaRepository<Requerimiento5, Integer> {

        /*
         * RF5: MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE
         * FECHAS INDICADO.
         * Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
         */

        @Query(value = "SELECT u.num_doc, u.tipo_doc, u.nombre AS nombre_cliente, s.id AS servicio_id, s.nombre AS nombre_servicio, rs.fecha, rs.costo\r\n"
                        + //
                        "FROM reservas_servicio rs\r\n" + //
                        "JOIN habitaciones h ON rs.id_habitacion = h.id\r\n" + //
                        "JOIN reservas_habitacion rh ON h.id = rh.id_habitacion\r\n" + //
                        "JOIN usuarios u ON rh.num_doc = u.num_doc AND rh.tipo_doc = u.tipo_doc\r\n" + //
                        "JOIN servicios s ON rs.id_servicio = s.id\r\n" + //
                        "WHERE u.num_doc = :num_doc \r\n" + //
                        "    AND u.tipo_doc = :tipo_doc\r\n" + //
                        "    AND rs.fecha BETWEEN TO_DATE(:fecha_inicial, 'DD/MM/YYYY') AND TO_DATE(:fecha_final, 'DD/MM/YYYY')\r\n"
                        + //
                        "ORDER BY rs.fecha, rs.hora_inicio", nativeQuery = true)
        Collection<Requerimiento5> consumosDeUsuario(@Param("num_doc") int numDoc, @Param("tipo_doc") String tipoDoc,
                        @Param("fecha_inicial") String fechaInicial, @Param("fecha_final") String fechaFinal);
}
