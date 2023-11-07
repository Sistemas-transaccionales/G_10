package uniandes.edu.co.proyecto.repository.requerimientos;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento9;

public interface Req9Repository extends JpaRepository<Requerimiento9, String> {

    @Query(value = "SELECT u.num_doc, u.tipo_doc, u.nombre, r.fecha, COUNT(*) as cantidad FROM usuarios u JOIN reservas_servicio r ON u.num_doc = r.id_consumidor AND u.tipo_doc = r.tipo_id_consumidor WHERE r.id_servicio = :service_id AND r.fecha BETWEEN :start_date AND :end_date GROUP BY u.num_doc, u.tipo_doc, u.nombre, r.fecha ORDER BY :order_by", nativeQuery = true)
    Collection<Requerimiento9> findConsumoByServiceAndDate(@Param("service_id") String service_id, @Param("start_date") Date start_date, @Param("end_date") Date end_date, @Param("order_by") String order_by);

}