package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Salon;
import uniandes.edu.co.proyecto.model.servicios.TipoServicio;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

    // Método para listar todos los salones
    @Query("SELECT s FROM Salon s")
    Collection<Salon> listarSalones();

    // Método para buscar un salón por su ID
    @Query("SELECT s FROM Salon s WHERE s.id = :id")
    Salon buscarSalonPorID(@Param("id") Integer id);

    // Método para insertar un nuevo salón
    @Modifying
    @Transactional
    @Query("INSERT INTO Salon (tipo, nombre, tipo_salon, capacidad, costo_por_hora, costo_extra) "
            + "VALUES (:tipo, :nombre, :tipoSalon, :capacidad, :costoPorHora, :costoExtra)")
    void insertarSalon(@Param("tipo") TipoServicio tipo, @Param("nombre") String nombre,
            @Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad,
            @Param("costoPorHora") Integer costoPorHora, @Param("costoExtra") Integer costoExtra);

    // Método para actualizar un salón
    @Modifying
    @Transactional
    @Query("UPDATE Salon s SET s.tipo = :tipo, s.nombre = :nombre, s.tipo_salon = :tipoSalon, "
            + "s.capacidad = :capacidad, s.costo_por_hora = :costoPorHora, s.costo_extra = :costoExtra "
            + "WHERE s.id = :id")
    void actualizarSalon(@Param("id") Integer id, @Param("tipo") TipoServicio tipo, @Param("nombre") String nombre,
            @Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad,
            @Param("costoPorHora") Integer costoPorHora, @Param("costoExtra") Integer costoExtra);

    // Método para eliminar un salón por su ID
    @Modifying
    @Transactional
    @Query("DELETE FROM Salon s WHERE s.id = :id")
    void eliminarSalonPorID(@Param("id") Integer id);
}
