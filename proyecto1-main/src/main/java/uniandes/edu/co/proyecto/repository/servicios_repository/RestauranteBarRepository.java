package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;

public interface RestauranteBarRepository extends JpaRepository<RestauranteBar, Integer> {

        // Método para listar todos los restaurantes/bares
        @Query("SELECT * FROM RestauranteBar")
        Collection<RestauranteBar> listarRestaurantesBares();

        // Método para buscar un restaurante/bar por su ID
        @Query("SELECT * FROM RestauranteBar WHERE id = :id")
        RestauranteBar buscarRestauranteBarPorID(@Param("id") Integer id);

        // Método para insertar un nuevo restaurante/bar
        @Modifying
        @Transactional
        @Query("INSERT INTO RestauranteBar (id, tipo, estilo, es_bar, horario, capacidad) VALUES (:id, :tipo, :estilo, :esBar, :horario, :capacidad)")
        void insertarRestauranteBar(@Param("id") int id, @Param("tipo") int tipo, @Param("nombre") String nombre,
                        @Param("estilo") String estilo, @Param("esBar") int esBar, @Param("horario") String horario,
                        @Param("capacidad") Integer capacidad);

        // Método para actualizar un restaurante/bar
        @Modifying
        @Transactional
        @Query("UPDATE RestauranteBar SET nombre = :nombre, estilo = :estilo, es_bar = :esBar, horario = :horario, capacidad = :capacidad WHERE id = :id")
        void actualizarRestauranteBar(@Param("id") Integer id, @Param("nombre") String nombre,
                        @Param("estilo") String estilo, @Param("esBar") int esBar,
                        @Param("horario") String horario, @Param("capacidad") Integer capacidad);

        // Método para eliminar un restaurante/bar por su ID
        @Modifying
        @Transactional
        @Query("DELETE FROM RestauranteBar WHERE id = :id")
        void eliminarRestauranteBarPorID(@Param("id") Integer id);
}
