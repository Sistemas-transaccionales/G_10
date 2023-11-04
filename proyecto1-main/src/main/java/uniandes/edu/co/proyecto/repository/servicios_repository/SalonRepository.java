package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

        // Método para listar todos los salones
        @Query("SELECT * FROM salones")
        Collection<Salon> listarSalones();

        // Método para buscar un salón por su ID
        @Query("SELECT * FROM salones WHERE id = :id")
        Salon buscarSalonPorID(@Param("id") Integer id);

        // Método para insertar un nuevo salón
        @Modifying
        @Transactional
        @Query("INSERT INTO servicios (id, tipo, nombre) VALUES (:id, :tipo, :nombre); INSERT INTO salones (id, tipo_salon, capacidad, costo_por_hora, costo_extra) "
                        + "VALUES (:id, :tipoSalon, :capacidad, :costoPorHora, :costoExtra)")
        void insertarSalon(@Param("id") int id, @Param("tipo") int tipo, @Param("nombre") String nombre,
                        @Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad,
                        @Param("costoPorHora") Integer costoPorHora, @Param("costoExtra") Integer costoExtra);

        // Método para actualizar un salón
        @Modifying
        @Transactional
        @Query("UPDATE servicios SET nombre = :nombre WHERE id = :id; UPDATE salones SET tipo_salon = :tipoSalon, capacidad = :capacidad, costo_por_hora = :costoPorHora, costo_extra = :costoExtra WHERE id = :id")
        void actualizarSalon(@Param("id") int id, @Param("nombre") String nombre,
                        @Param("tipoSalon") String tipoSalon, @Param("capacidad") Integer capacidad,
                        @Param("costoPorHora") Integer costoPorHora, @Param("costoExtra") Integer costoExtra);

        // Método para eliminar un salón por su ID
        @Modifying
        @Transactional
        @Query("DELETE FROM salones WHERE id = :id")
        void eliminarSalonPorID(@Param("id") int id);
}
