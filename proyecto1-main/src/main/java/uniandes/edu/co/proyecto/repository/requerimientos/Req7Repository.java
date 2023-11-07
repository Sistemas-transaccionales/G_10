package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento7;

public interface Req7Repository extends JpaRepository<Requerimiento7, String> {

    @Query(value = "WITH DatosCliente AS (" +
            "SELECT " +
            "usuarios.num_doc AS num_documento, " +
            "usuarios.nombre AS clientes_buenos, " +
            "SUM(rh.fecha_salida - rh.fecha_entrada) AS dias_hospedado, " +
            "SUM(COALESCE(rh.costo, 0) + COALESCE(rs.costo, 0)) AS costo_total " +
            "FROM usuarios " +
            "LEFT JOIN reservas_habitacion rh ON usuarios.num_doc = rh.num_doc " +
            "LEFT JOIN reservas_servicio rs ON usuarios.num_doc = rs.id_consumidor " +
            "WHERE EXTRACT(YEAR FROM rh.fecha_salida) = 2023 OR EXTRACT(YEAR FROM rs.fecha) = 2023 " +
            "GROUP BY usuarios.num_doc, usuarios.nombre" +
            ")" +
            "SELECT num_documento, clientes_buenos, dias_hospedado, costo_total " +
            "FROM DatosCliente " +
            "WHERE costo_total > 15000000 OR dias_hospedado > 14 " +
            "ORDER BY costo_total DESC", nativeQuery = true)
    Collection<Requerimiento7> clientesBuenos();
}