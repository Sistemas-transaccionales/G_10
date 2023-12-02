package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q2;

public interface Req11Q2Repository extends JpaRepository<Requerimiento11Q2, Integer> {

    @Query(value = "SELECT semana,\r\n" + //
            "    nombre AS servicio_menos_consumido,\r\n" + //
            "    consumos\r\n" + //
            "FROM (\r\n" + //
            "    SELECT TO_CHAR(rs.fecha, 'IW') AS semana,\r\n" + //
            "           s.nombre,\r\n" + //
            "           COUNT(*) AS consumos,\r\n" + //
            "           ROW_NUMBER() OVER (PARTITION BY TO_CHAR(rs.fecha, 'IW') ORDER BY COUNT(*)) AS rn\r\n" + //
            "    FROM reservas_servicio rs\r\n" + //
            "    JOIN servicios s ON rs.id_servicio = s.id\r\n" + //
            "    WHERE rs.fecha BETWEEN TRUNC(SYSDATE, 'YEAR') - INTERVAL '1' YEAR AND TRUNC(SYSDATE)\r\n" + //
            "    GROUP BY TO_CHAR(rs.fecha, 'IW'), s.nombre\r\n" + //
            ")\r\n" + //
            "WHERE rn = 1", nativeQuery = true)
    Collection<Requerimiento11Q2> serviciosMenosConsumidos();
}
