package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT * FROM tienda")
    Collection<Tienda> listarTiendas();

    // Método para buscar una tienda por su nombre
    @Query("SELECT t FROM Tienda t WHERE t.id = :id")
    Tienda buscarTiendaPorId(@Param("id") int nombre);

    // Método para insertar una nueva tienda
    @Modifying
    @Transactional
    @Query("INSERT INTO Tienda (nombre, tipo_productos) VALUES (:nombre, :tipo_productos)")
    void insertarTienda(@Param("nombre") String nombre, @Param("tipo_productos") String tipo_productos);

    // Método para actualizar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("UPDATE Tienda t SET t.tipo_productos = :tipo_productos, t.nombre = :nombre WHERE t.id = :id")
    void actualizarTienda(@Param("id") int id, @Param("nombre") String nombre,
            @Param("tipo_productos") String tipo_productos);

    // Método para eliminar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("DELETE FROM Tienda t WHERE t.id = :id")
    void eliminarTiendaPorId(@Param("id") int id);
}
