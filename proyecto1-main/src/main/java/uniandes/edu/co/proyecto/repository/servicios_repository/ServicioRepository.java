package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    // Método para listar todos los servicios
    @Query("SELECT * FROM servicios")
    Collection<Servicio> listarServicios();

    // Método para buscar un servicio por su ID
    @Query("SELECT * FROM servicios WHERE id = :id")
    Servicio buscarServicioPorID(@Param("id") Integer id);

    // Método para insertar un nuevo servicio
    @Modifying
    @Transactional
    @Query("INSERT INTO servicios (id, tipo, nombre) VALUES (id_servicios.NEXTVAL, :tipo, :nombre)")
    void insertarServicio(@Param("tipo") int tipo, @Param("nombre") String nombre);

    // Método para actualizar un servicio
    @Modifying
    @Transactional
    @Query("UPDATE servicios SET tipo = :tipo, nombre = :nombre WHERE id = :id")
    void actualizarServicio(@Param("id") Integer id, @Param("tipo") int tipo, @Param("nombre") String nombre);

    // Método para eliminar un servicio por su ID
    @Modifying
    @Transactional
    @Query("DELETE FROM servicios WHERE id = :id")
    void eliminarServicioPorID(@Param("id") Integer id);
}
