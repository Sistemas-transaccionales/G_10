package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento2;

public interface Req2Repository extends JpaRepository<Requerimiento2, Integer> {

        /*
         * MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
         * Los que fueron más consumidos en un período de tiempo dado.
         */
        // @Query(value = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY'",
        // nativeQuery = true)
        // void setDateFormat();

        @Query(value = "SELECT rs.id_servicio, s.nombre AS nombre_servicio, COUNT(rs.id_servicio) AS consumos FROM reservas_servicio rs JOIN servicios s ON rs.id_servicio = s.id WHERE rs.fecha BETWEEN TO_DATE(:fechaInicial, 'DD/MM/YYYY') AND TO_DATE(:fechaFinal, 'DD/MM/YYYY') GROUP BY rs.id_servicio, s.nombre ORDER BY consumos DESC FETCH FIRST 20 ROWS ONLY", nativeQuery = true)

        Collection<Requerimiento2> mostarServiciosPopulares(@Param("fechaInicial") String fechaInicial,
                        @Param("fechaFinal") String fechaFinal);

}
