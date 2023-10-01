package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.servicios.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {

    // Método para listar todas las piscinas
    @Query(value = "SELECT * FROM piscina", nativeQuery = true)
    Collection<Piscina> listarPiscinas();

    // Método para buscar una piscina por su id
    @Query(value = "SELECT * FROM piscina WHERE id = :id", nativeQuery = true)
    Piscina buscarPiscinaPorId(@Param("id") int id);

    // Método para insertar una nueva piscina
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscina (tipo, nombre, capacidad, area, profundidad) VALUES (:tipo, :nombre, :capacidad, :area, :profundidad)", nativeQuery = true)
    void insertarPiscina(@Param("tipo") int tipo, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad,
            @Param("area") Float area, @Param("profundidad") Float profundidad);

    // Método para actualizar una piscina
    @Modifying
    @Transactional
    @Query(value = "UPDATE piscina SET nombre = :nombre, capacidad = :capacidad, area = :area, profundidad = :profundidad WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") int id, @Param("nombre") String nombre,
            @Param("capacidad") Integer capacidad, @Param("area") Float area, @Param("profundidad") Float profundidad);

    // Método para eliminar una piscina por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscina WHERE id = :id", nativeQuery = true)
    void eliminarPiscinaPorId(@Param("id") int id);
}