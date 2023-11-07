package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento6_1;

import java.sql.Date;

public interface Req6_1Repository extends JpaRepository<Requerimiento6_1, Date> {

    @Query(value = "SELECT fecha_entrada AS Fecha, COUNT(*) AS Ocupacion FROM reservas_habitacion GROUP BY fecha_entrada ORDER BY Ocupacion DESC FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    Collection<Requerimiento6_1> altaOcupacion();

    @Query(value = "SELECT fecha_entrada AS Fecha, COUNT(*) AS Ocupacion FROM reservas_habitacion GROUP BY fecha_entrada ORDER BY Ocupacion ASC FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    Collection<Requerimiento6_1> bajaOcupacion();

}