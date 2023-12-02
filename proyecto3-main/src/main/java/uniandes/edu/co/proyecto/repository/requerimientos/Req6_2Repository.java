package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento6_2;

import java.sql.Date;

public interface Req6_2Repository extends JpaRepository<Requerimiento6_2, Date> {

    @Query(value = "SELECT fecha as Fecha, SUM(costo) AS Ingresos FROM reservas_servicio GROUP BY fecha ORDER BY Ingresos DESC FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    Collection<Requerimiento6_2> demandaIngresos();
}