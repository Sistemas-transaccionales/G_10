package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;
import uniandes.edu.co.proyecto.model.servicios.TipoServicio;

public interface RestauranteBarRepository extends JpaRepository<RestauranteBar, Integer> {

    // Método para listar todos los restaurantes/bares
    @Query("SELECT rb FROM RestauranteBar rb")
    Collection<RestauranteBar> listarRestaurantesBares();

    // Método para buscar un restaurante/bar por su ID
    @Query("SELECT rb FROM RestauranteBar rb WHERE rb.id = :id")
    RestauranteBar buscarRestauranteBarPorID(@Param("id") Integer id);

    // Método para insertar un nuevo restaurante/bar
    @Modifying
    @Transactional
    @Query("INSERT INTO RestauranteBar (tipo, nombre, estilo, es_bar, horario, capacidad) "
            + "VALUES (:tipo, :nombre, :estilo, :esBar, :horario, :capacidad)")
    void insertarRestauranteBar(@Param("tipo") TipoServicio tipo, @Param("nombre") String nombre,
            @Param("estilo") String estilo, @Param("esBar") Boolean esBar, @Param("horario") String horario,
            @Param("capacidad") Integer capacidad);

    // Método para actualizar un restaurante/bar
    @Modifying
    @Transactional
    @Query("UPDATE RestauranteBar rb SET rb.tipo = :tipo, rb.nombre = :nombre, rb.estilo = :estilo, "
            + "rb.es_bar = :esBar, rb.horario = :horario, rb.capacidad = :capacidad WHERE rb.id = :id")
    void actualizarRestauranteBar(@Param("id") Integer id, @Param("tipo") TipoServicio tipo,
            @Param("nombre") String nombre, @Param("estilo") String estilo, @Param("esBar") Boolean esBar,
            @Param("horario") String horario, @Param("capacidad") Integer capacidad);

    // Método para eliminar un restaurante/bar por su ID
    @Modifying
    @Transactional
    @Query("DELETE FROM RestauranteBar rb WHERE rb.id = :id")
    void eliminarRestauranteBarPorID(@Param("id") Integer id);
}
