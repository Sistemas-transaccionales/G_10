package uniandes.edu.co.proyecto.repository.requerimientos;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.model.servicios.Servicio;

public interface Req2 extends JpaRepository<Servicio, Integer> {

    /*
     * MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
     * Los que fueron más consumidos en un período de tiempo dado.
     */
    // @Query(value = "SELECT * FROM servicios ORDER BY num_consumos DESC LIMIT 20",
    // nativeQuery = true)

}
