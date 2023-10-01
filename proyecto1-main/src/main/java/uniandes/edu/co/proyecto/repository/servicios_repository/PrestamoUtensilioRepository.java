package uniandes.edu.co.proyecto.repository.servicios_repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.servicios.PrestamoUtensilio;

public interface PrestamoUtensilioRepository extends JpaRepository<PrestamoUtensilio, Integer> {

    // Método para listar todos los préstamos de utensilios
    @Query(value = "SELECT * FROM prestamo_utensilio", nativeQuery = true)
    Collection<PrestamoUtensilio> listarPrestamosUtensilios();

    // Método para buscar un préstamo de utensilio por su id
    @Query(value = "SELECT * FROM prestamo_utensilio WHERE id = :id", nativeQuery = true)
    PrestamoUtensilio buscarPrestamoUtensilioPorId(@Param("id") int id);

    // Método para insertar un nuevo préstamo de utensilio
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamo_utensilio (tipo, nombre, utensilio, costo_danio) VALUES (:tipo, :nombre, :utensilio, :costo_danio)", nativeQuery = true)
    void insertarPrestamoUtensilio(@Param("tipo") int tipo, @Param("nombre") String nombre,
            @Param("utensilio") String utensilio, @Param("costo_danio") Integer costo_danio);

    // Método para actualizar un préstamo de utensilio
    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamo_utensilio SET nombre = :nombre, utensilio = :utensilio, costo_danio = :costo_danio WHERE id = :id", nativeQuery = true)
    void actualizarPrestamoUtensilio(@Param("id") int id, @Param("nombre") String nombre,
            @Param("utensilio") String utensilio, @Param("costo_danio") Integer costo_danio);

    // Método para eliminar un préstamo de utensilio por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamo_utensilio WHERE id = :id", nativeQuery = true)
    void eliminarPrestamoUtensilioPorId(@Param("id") int id);
}
