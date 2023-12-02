package uniandes.edu.co.proyecto.repository.requerimientos;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento4;

public interface Req4Repository extends JpaRepository<Requerimiento4, String> {

    @Query(value = "SELECT servicios.nombre, " +
            "COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) AS capacidad_total, " +
            "CASE " +
            "    WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo " +
            "    WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio " +
            "    WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora " +
            "    WHEN spas.costo IS NOT NULL THEN spas.costo " +
            "    ELSE 0 " +
            "END AS costo_del_servicio " +
            "FROM servicios " +
            "LEFT JOIN gimnasios ON gimnasios.id = servicios.id " +
            "LEFT JOIN piscinas ON piscinas.id = servicios.id " +
            "LEFT JOIN salones ON salones.id = servicios.id " +
            "LEFT JOIN restaurantes_bares ON restaurantes_bares.id = servicios.id " +
            "LEFT JOIN lavanderias ON lavanderias.id = servicios.id " +
            "LEFT JOIN prestamos_utensilios ON prestamos_utensilios.id = servicios.id " +
            "LEFT JOIN spas ON spas.id = servicios.id " +
            "WHERE (CASE " +
            "        WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo " +
            "        WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio " +
            "        WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora " +
            "        WHEN spas.costo IS NOT NULL THEN spas.costo " +
            "        ELSE 0 " +
            "    END >= :costoMinimo AND " +
            "    CASE " +
            "        WHEN lavanderias.costo IS NOT NULL THEN lavanderias.costo " +
            "        WHEN prestamos_utensilios.costo_danio IS NOT NULL THEN prestamos_utensilios.costo_danio " +
            "        WHEN salones.costo_por_hora IS NOT NULL THEN salones.costo_por_hora " +
            "        WHEN spas.costo IS NOT NULL THEN spas.costo " +
            "        ELSE 0 " +
            "    END <= :costoMaximo) " +
            "OR " +
            "(COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) >= :capacidadMinima AND " +
            "COALESCE(gimnasios.capacidad, piscinas.capacidad, salones.capacidad, restaurantes_bares.capacidad) <= :capacidadMaxima)",
            nativeQuery = true)
    Collection<Requerimiento4> serviciosFiltrados(@Param("costoMinimo") BigDecimal costoMinimo, @Param("costoMaximo") BigDecimal costoMaximo, @Param("capacidadMinima") int capacidadMinima, @Param("capacidadMaxima") int capacidadMaxima);
}
