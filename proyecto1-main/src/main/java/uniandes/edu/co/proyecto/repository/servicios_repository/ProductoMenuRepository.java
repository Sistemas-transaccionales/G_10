package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.ProductoMenu;

public interface ProductoMenuRepository extends JpaRepository<ProductoMenu, Integer> {

    // Método para listar todos los productos del menú
    @Query(value = "SELECT * FROM productos_menu", nativeQuery = true)
    Collection<ProductoMenu> listarProductosMenu();

    // Método para buscar un producto del menú por su id
    @Query(value = "SELECT * FROM productos_menu WHERE id = :id", nativeQuery = true)
    ProductoMenu buscarProductoMenuPorId(@Param("id") int id);

    // Método para insertar un nuevo producto del menú
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos_menu (id, nombre, costo) VALUES (id_productos_menu.NEXTVAL, :nombre, :costo)", nativeQuery = true)
    void insertarProductoMenu(@Param("nombre") String nombre, @Param("costo") String costo);

    // Método para actualizar un producto del menú
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos_menu SET nombre = :nombre, costo = :costo WHERE id = :id", nativeQuery = true)
    void actualizarProductoMenu(@Param("id") int id, @Param("nombre") String nombre, @Param("costo") String costo);

    // Método para eliminar un producto del menú por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos_menu WHERE id = :id", nativeQuery = true)
    void eliminarProductoMenuPorId(@Param("id") int id);
}
