package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.sql.Time;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.servicios.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

    // Método para listar todos los gimnasios
    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> listarGimnasios();

    // Método para buscar un gimnasio por su id
    @Query(value = "SELECT * FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio buscarGimnasioPorId(@Param("id") int id);

    // Método para insertar un nuevo gimnasio
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (tipo, nombre, hora_apertura, hora_clausura, capacidad) VALUES (:tipo, :nombre, :horaApertura, :horaClausura, :capacidad)", nativeQuery = true)
    void insertarGimnasio(@Param("tipo") int tipo, @Param("nombre") String nombre,
            @Param("horaApertura") Time horaApertura, @Param("horaClausura") Time horaClausura,
            @Param("capacidad") Integer capacidad);

    // Método para actualizar un gimnasio
    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET tipo = :tipo, nombre = :nombre, hora_apertura = :horaApertura, hora_clausura = :horaClausura, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") int id, @Param("tipo") String tipo, @Param("nombre") String nombre,
            @Param("horaApertura") Time horaApertura, @Param("horaClausura") Time horaClausura,
            @Param("capacidad") Integer capacidad);

    // Método para eliminar un gimnasio por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id", nativeQuery = true)
    void eliminarGimnasioPorId(@Param("id") int id);
}
