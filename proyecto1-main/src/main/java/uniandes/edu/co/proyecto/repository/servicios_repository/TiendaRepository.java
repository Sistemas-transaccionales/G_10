package uniandes.edu.co.proyecto.repository.servicios_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    // Método para buscar una tienda por su nombre
    @Query("SELECT t FROM Tienda t WHERE t.nombre = :nombre")
    Tienda buscarTiendaPorNombre(@Param("nombre") String nombre);

    // Método para insertar una nueva tienda
    @Modifying
    @Transactional
    @Query("INSERT INTO Tienda (nombre, tipo_productos) VALUES (:nombre, :tipo_productos)")
    void insertarTienda(@Param("nombre") String nombre, @Param("tipo_productos") String tipo_productos);

    // Método para actualizar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("UPDATE Tienda t SET t.tipo_productos = :tipo_productos WHERE t.nombre = :nombre")
    void actualizarTienda(@Param("nombre") String nombre, @Param("tipo_productos") String tipo_productos);

    // Método para eliminar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("DELETE FROM Tienda t WHERE t.nombre = :nombre")
    void eliminarTiendaPorNombre(@Param("nombre") String nombre);
}
