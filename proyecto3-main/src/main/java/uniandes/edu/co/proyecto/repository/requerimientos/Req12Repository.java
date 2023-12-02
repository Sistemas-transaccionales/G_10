package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento12;

public interface Req12Repository extends JpaRepository<Requerimiento12, String> {

    @Query(value = 
    "WITH " +
    "trimester_stays AS (" +
    "  SELECT num_doc, tipo_doc " +
    "  FROM check_ins " +
    "  GROUP BY num_doc, tipo_doc, EXTRACT(YEAR FROM fecha), TRUNC((EXTRACT(MONTH FROM fecha) - 1) / 3) " +
    "  HAVING COUNT(DISTINCT fecha) >= 1 " +
    "), " +
    "expensive_services AS (" +
    "  SELECT id_consumidor, tipo_id_consumidor " +
    "  FROM reservas_servicio " +
    "  WHERE costo > 300000 " +
    "  GROUP BY id_consumidor, tipo_id_consumidor " +
    "  HAVING COUNT(DISTINCT id_servicio) >= 1 " +
    "), " +
    "long_services AS (" +
    "  SELECT id_consumidor, tipo_id_consumidor " +
    "  FROM reservas_servicio " +
    "  JOIN servicios ON reservas_servicio.id_servicio = servicios.id " +
    "  WHERE (LOWER(nombre) LIKE '%spa%' OR LOWER(nombre) LIKE '%salones%') AND (TO_DATE(hora_fin, 'HH24:MI:SS') - TO_DATE(hora_inicio, 'HH24:MI:SS')) * 24 > 4 " +
    "  GROUP BY id_consumidor, tipo_id_consumidor " +
    "  HAVING COUNT(DISTINCT id_servicio) >= 1 " +
    ") " +
    "SELECT num_doc, tipo_doc, 'Estancia Trimestral' AS categoria " +
    "FROM trimester_stays " +
    "UNION " +
    "SELECT id_consumidor, tipo_id_consumidor, 'Servicios Costosos' " +
    "FROM expensive_services " +
    "UNION " +
    "SELECT id_consumidor, tipo_id_consumidor, 'Servicios Largo' " +
    "FROM long_services", nativeQuery = true)
    Collection<Requerimiento12> getClientesExcelentes();

}
