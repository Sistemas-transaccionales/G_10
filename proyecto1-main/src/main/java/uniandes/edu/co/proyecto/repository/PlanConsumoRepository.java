package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer> {

    // Método para listar todos los planes de consumo
    @Query(value = "SELECT * FROM planconsumo", nativeQuery = true)
    Collection<PlanConsumo> listarPlanesConsumo();

    // Método para buscar un plan de consumo por su id
    @Query(value = "SELECT * FROM planconsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo buscarPlanConsumoPorId(@Param("id") int id);

    // Método para insertar un nuevo plan de consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planconsumo (tipoplan, tasa, min_noches, max_noches) VALUES (:tipoPlan, :tasa, :minNoches, :maxNoches)", nativeQuery = true)
    void insertarPlanConsumo(@Param("tipoPlan") String tipoPlan, @Param("tasa") float tasa, @Param("minNoches") int minNoches, @Param("maxNoches") int maxNoches);

    // Método para actualizar un plan de consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE planconsumo SET tipoplan = :tipoPlan, tasa = :tasa, min_noches = :minNoches, max_noches = :maxNoches WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") int id, @Param("tipoPlan") String tipoPlan, @Param("tasa") float tasa, @Param("minNoches") int minNoches, @Param("maxNoches") int maxNoches);

    // Método para eliminar un plan de consumo por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planconsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumoPorId(@Param("id") int id);
}
