package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q4;

public interface Req11Q4Repository extends JpaRepository<Requerimiento11Q4, Integer> {

    @Query(value = "SELECT semana,\r\n" + //
            "    id AS habitacion_menos_solicitada,\r\n" + //
            "    reservaciones\r\n" + //
            "FROM (\r\n" + //
            "    SELECT TO_CHAR(rh.fecha_entrada, 'IW') AS semana,\r\n" + //
            "           h.id,\r\n" + //
            "           COUNT(*) AS reservaciones,\r\n" + //
            "           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rh.fecha_entrada, 'IW') ORDER BY COUNT(*)) AS rn\r\n" + //
            "    FROM reservas_habitacion rh\r\n" + //
            "    JOIN habitaciones h ON rh.id_habitacion = h.id\r\n" + //
            "    WHERE rh.fecha_entrada BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)\r\n" + //
            "    GROUP BY TO_CHAR(rh.fecha_entrada, 'IW'), h.id\r\n" + //
            ")\r\n" + //
            "WHERE rn = 1", nativeQuery = true)
    Collection<Requerimiento11Q4> habitacionesMenosSolicitadas();

}
