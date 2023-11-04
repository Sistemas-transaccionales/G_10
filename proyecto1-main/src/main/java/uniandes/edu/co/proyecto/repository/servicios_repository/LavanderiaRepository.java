package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.servicios.Lavanderia;

public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {

        // Método para listar todos los servicios de lavandería
        @Query(value = "SELECT * FROM lavanderias", nativeQuery = true)
        Collection<Lavanderia> listarServiciosLavanderia();

        // Método para buscar un servicio de lavandería por su id
        @Query(value = "SELECT * FROM lavanderias WHERE id = :id", nativeQuery = true)
        Lavanderia buscarServicioLavanderiaPorId(@Param("id") int id);

        // Método para insertar un nuevo servicio de lavandería
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO servicios (id, tipo, nombre) VALUES (:id, :tipo, :nombre); INSERT INTO lavanderias (id, tipo_prenda, num_prendas, costo) VALUES (:id, :tipoPrenda, :numPrendas, :costo)", nativeQuery = true)
        void insertarServicioLavanderia(@Param("id") int id, @Param("tipo") int tipo, @Param("nombre") String nombre,
                        @Param("tipoPrenda") String tipoPrenda, @Param("numPrendas") Integer numPrendas,
                        @Param("costo") Integer costo);

        // Método para actualizar un servicio de lavandería
        @Modifying
        @Transactional
        @Query(value = "UPDATE servicios SET nombre = :nombre WHERE id = :id; UPDATE lavanderias SET tipo_prenda = :tipoPrenda, num_prendas = :numPrendas, costo = :costo WHERE id = :id", nativeQuery = true)
        void actualizarServicioLavanderia(@Param("id") int id, @Param("nombre") String nombre,
                        @Param("tipoPrenda") String tipoPrenda, @Param("numPrendas") Integer numPrendas,
                        @Param("costo") Integer costo);

        // Método para eliminar un servicio de lavandería por su id
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM lavanderias WHERE id = :id", nativeQuery = true)
        void eliminarServicioLavanderiaPorId(@Param("id") int id);
}