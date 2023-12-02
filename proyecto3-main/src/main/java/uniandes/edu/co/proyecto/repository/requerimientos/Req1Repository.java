package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento1;

public interface Req1Repository extends JpaRepository<Requerimiento1, String> {

    @Query(value = "SELECT reservas_servicio.id_habitacion AS id_habitacion, servicios.nombre AS nombre_servicio, "
            +
            "SUM(reservas_servicio.costo) AS Total_Ganancia " +
            "FROM reservas_servicio " +
            "INNER JOIN servicios ON servicios.id = reservas_servicio.id_servicio " +
            "WHERE EXTRACT(YEAR FROM reservas_servicio.fecha) = 2023 " +
            "GROUP BY reservas_servicio.id_habitacion, servicios.nombre " +
            "ORDER BY reservas_servicio.id_habitacion", nativeQuery = true)
    Collection<Requerimiento1> dinero_recolectado();
}