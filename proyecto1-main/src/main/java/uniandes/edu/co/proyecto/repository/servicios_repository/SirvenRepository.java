package uniandes.edu.co.proyecto.repository.servicios_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.primaryKeys.SirvenPK;
import uniandes.edu.co.proyecto.model.servicios.Sirven;

public interface SirvenRepository extends JpaRepository<Sirven, SirvenPK> {

    // Método para buscar una relación Sirven por su clave compuesta
    @Query("SELECT * FROM sirven WHERE id_restaurante_bar = :id_restaurante_bar AND id_producto = :id_producto_menu")
    Sirven buscarSirvenPorPK(@Param("id_restaurante_bar") Integer idRestauranteBar,
            @Param("id_producto_menu") Integer idProductoMenu);

    // Método para insertar una nueva relación Sirven
    @Modifying
    @Transactional
    @Query("INSERT INTO sirven (id_restaurante_bar, id_producto) VALUES (:id_restaurante_bar, :id_producto_menu)")
    void insertarSirven(@Param("id_restaurante_bar") Integer idRestauranteBar,
            @Param("id_producto_menu") Integer idProductoMenu);

    // Método para eliminar una relación Sirven por su clave compuesta
    @Modifying
    @Transactional
    @Query("DELETE FROM sirven WHERE id_restaurante_bar = :id_restaurante_bar AND id_producto = :id_producto_menu")
    void eliminarSirvenPorPK(@Param("id_restaurante_bar") Integer idRestauranteBar,
            @Param("id_producto_menu") Integer idProductoMenu);
}
