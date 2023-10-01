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
    @Query(value = "SELECT * FROM planes_consumo", nativeQuery = true)
    Collection<PlanConsumo> listarPlanesConsumo();

    // Método para buscar un plan de consumo por su id
    @Query(value = "SELECT * FROM planes_consumo WHERE id = :id", nativeQuery = true)
    PlanConsumo buscarPlanConsumoPorId(@Param("id") int id);

    // Método para insertar un nuevo plan de consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_consumo (id, tipo_plan, tasa, min_noches, max_noches) VALUES (id_planes_consumo.NEXTVAL, :tipo_plan, :tasa, :min_noches, :max_noches)", nativeQuery = true)
    void insertarPlanConsumo(@Param("tipo_plan") String tipo_plan, @Param("tasa") float tasa,
            @Param("min_noches") int min_noches, @Param("max_noches") int max_noches);

    // Método para actualizar un plan de consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE planes_consumo SET tipo_plan = :tipo_plan, tasa = :tasa, min_noches = :min_noches, max_noches = :max_noches WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") int id, @Param("tipo_plan") String tipo_plan, @Param("tasa") float tasa,
            @Param("min_noches") int min_noches, @Param("max_noches") int max_noches);

    // Método para eliminar un plan de consumo por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_consumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumoPorId(@Param("id") int id);
}
