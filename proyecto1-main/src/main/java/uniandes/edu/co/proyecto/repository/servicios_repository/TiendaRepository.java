package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT * FROM tiendas")
    Collection<Tienda> listarTiendas();

    // Método para buscar una tienda por su nombre
    @Query("SELECT * FROM tiendas WHERE id = :id")
    Tienda buscarTiendaPorId(@Param("id") int nombre);

    // Método para insertar una nueva tienda
    @Modifying
    @Transactional
    @Query("INSERT INTO servicios (id, tipo, nombre) VALUES (id_servicios.NEXTVAL, :tipo, :nombre); INSERT INTO tiendas (id, tipo_productos) VALUES (id_servicios.CURRVAL, :tipo_productos)")
    void insertarTienda(@Param("tipo") int tipo, @Param("nombre") String nombre,
            @Param("tipo_productos") String tipo_productos);

    // Método para actualizar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("UPDATE servicios SET nombre = :nombre WHERE id = :id; UPDATE tiendas SET tipo_productos = :tipo_productos WHERE id = :id")
    void actualizarTienda(@Param("id") int id, @Param("nombre") String nombre,
            @Param("tipo_productos") String tipo_productos);

    // Método para eliminar una tienda por su nombre
    @Modifying
    @Transactional
    @Query("DELETE FROM tiendas WHERE id = :id")
    void eliminarTiendaPorId(@Param("id") int id);
}
