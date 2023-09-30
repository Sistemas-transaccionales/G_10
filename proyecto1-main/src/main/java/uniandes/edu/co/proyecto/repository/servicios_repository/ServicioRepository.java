package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Servicio;
import uniandes.edu.co.proyecto.model.servicios.TipoServicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    // Método para listar todos los servicios
    @Query("SELECT s FROM Servicio s")
    Collection<Servicio> listarServicios();

    // Método para buscar un servicio por su ID
    @Query("SELECT s FROM Servicio s WHERE s.id = :id")
    Servicio buscarServicioPorID(@Param("id") Integer id);

    // Método para insertar un nuevo servicio
    @Modifying
    @Transactional
    @Query("INSERT INTO Servicio (tipo, nombre) VALUES (:tipo, :nombre)")
    void insertarServicio(@Param("tipo") TipoServicio tipo, @Param("nombre") String nombre);

    // Método para actualizar un servicio
    @Modifying
    @Transactional
    @Query("UPDATE Servicio s SET s.tipo = :tipo, s.nombre = :nombre WHERE s.id = :id")
    void actualizarServicio(@Param("id") Integer id, @Param("tipo") TipoServicio tipo, @Param("nombre") String nombre);

    // Método para eliminar un servicio por su ID
    @Modifying
    @Transactional
    @Query("DELETE FROM Servicio s WHERE s.id = :id")
    void eliminarServicioPorID(@Param("id") Integer id);
}
