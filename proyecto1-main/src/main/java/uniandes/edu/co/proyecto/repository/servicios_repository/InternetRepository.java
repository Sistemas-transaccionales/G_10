package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.servicios.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {

        // Método para listar todos los servicios de Internet
        @Query(value = "SELECT * FROM internet", nativeQuery = true)
        Collection<Internet> listarServiciosInternet();

        // Método para buscar un servicio de Internet por su id
        @Query(value = "SELECT * FROM internet WHERE id = :id", nativeQuery = true)
        Internet buscarServicioInternetPorId(@Param("id") int id);

        // Método para insertar un nuevo servicio de Internet
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO servicios (id, tipo, nombre) VALUES (id_servicios.NEXTVAL, :tipo, :nombre); INSERT INTO internet (id, capacidad) VALUES (id_servicios.CURRVAL, :capacidad)", nativeQuery = true)
        void insertarServicioInternet(@Param("tipo") int tipo, @Param("nombre") String nombre,
                        @Param("capacidad") Integer capacidad);

        // Método para actualizar un servicio de Internet
        @Modifying
        @Transactional
        @Query(value = "UPDATE servicios SET nombre = :nombre WHERE id = :id; UPDATE internet SET nombre = :nombre, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
        void actualizarServicioInternet(@Param("id") int id, @Param("nombre") String nombre,
                        @Param("capacidad") Integer capacidad);

        // Método para eliminar un servicio de Internet por su id
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM internet WHERE id = :id", nativeQuery = true)
        void eliminarServicioInternetPorId(@Param("id") int id);
}
