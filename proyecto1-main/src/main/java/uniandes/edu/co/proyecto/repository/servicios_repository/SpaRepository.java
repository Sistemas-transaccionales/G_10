package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Internet;
import uniandes.edu.co.proyecto.model.servicios.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {

    @Query(value = "SELECT * FROM spa", nativeQuery = true)
    Collection<Spa> listarSpas();

    // Método para buscar un servicio de Spa por su nombre
    @Query("SELECT s FROM Spa s WHERE s.id = :id")
    Spa buscarSpaPorId(@Param("id") int id);

    // Método para insertar un nuevo servicio de Spa
    @Modifying
    @Transactional
    @Query("INSERT INTO Spa (nombre, costo, duracion) VALUES (:nombre, :costo, :duracion)")
    void insertarSpa(@Param("nombre") String nombre, @Param("costo") Integer costo, @Param("duracion") String duracion);

    // Método para actualizar un servicio de Spa por su nombre
    @Modifying
    @Transactional
    @Query("UPDATE Spa s SET s.nombre = :nombre, s.costo = :costo, s.duracion = :duracion WHERE s.id = :id")
    void actualizarSpa(@Param("id") int id, @Param("nombre") String nombre, @Param("costo") Integer costo,
            @Param("duracion") String duracion);

    // Método para eliminar un servicio de Spa por su nombre
    @Modifying
    @Transactional
    @Query("DELETE FROM Spa s WHERE s.id = :id")
    void eliminarSpaPorId(@Param("id") int id);
}
