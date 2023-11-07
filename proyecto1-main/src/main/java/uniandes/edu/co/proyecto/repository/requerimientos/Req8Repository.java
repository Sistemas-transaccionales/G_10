package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento8;

public interface Req8Repository extends JpaRepository<Requerimiento8, String> {

    @Query(value = "SELECT s.nombre, COUNT(rs.id_servicio) AS consumos,\r\n" + //
            "    COUNT(rs.id_servicio) / 52 AS tasa_semanal\r\n" + //
            "FROM reservas_servicio rs\r\n" + //
            "JOIN servicios s ON rs.id_servicio = s.id\r\n" + //
            "WHERE rs.fecha >= SYSDATE - INTERVAL '1' YEAR\r\n" + //
            "GROUP BY s.nombre\r\n" + //
            "HAVING COUNT(rs.id_servicio) / 52 < 3\r\n" + //
            "ORDER BY tasa_semanal", nativeQuery = true)
    Collection<Requerimiento8> servicioSinDemanda();

}
