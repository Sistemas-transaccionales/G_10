package uniandes.edu.co.proyecto.repository.requerimientos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento10;

import java.util.Collection;
import java.sql.Date;

public interface Req10Repository extends JpaRepository<Requerimiento10, Integer> {

    @Query(value = "SELECT u.num_doc, u.tipo_doc, u.nombre " +
            "FROM usuarios u " +
            "WHERE (u.num_doc, u.tipo_doc) NOT IN ( " +
            "   SELECT r.id_consumidor, r.tipo_id_consumidor " +
            "   FROM reservas_servicio r " +
            "   WHERE r.id_servicio = :service_id " +
            "   AND r.fecha BETWEEN :start_date AND :end_date " +
            ") " +
            "ORDER BY :order_by", nativeQuery = true)
    Collection<Requerimiento10> findClientesNoConsumidores(@Param("service_id") String service_id, @Param("start_date") Date start_date, @Param("end_date") Date end_date, @Param("order_by") String order_by);
    
}
