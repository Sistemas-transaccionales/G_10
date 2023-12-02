package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento3;

public interface Req3Repository extends JpaRepository<Requerimiento3, String> {

    @Query(value = "SELECT r.id_habitacion AS ID_Habitacion, COUNT(DISTINCT r.fecha_entrada) AS Dias_Ocupados, (COUNT(DISTINCT r.fecha_entrada) / 365.0) * 100 AS Tasa_Ocupacion FROM reservas_habitacion r WHERE r.fecha_entrada BETWEEN SYSDATE - INTERVAL '1' YEAR AND SYSDATE GROUP BY r.id_habitacion ORDER BY Tasa_Ocupacion DESC", nativeQuery = true)
    Collection<Requerimiento3> habitaciones();

}