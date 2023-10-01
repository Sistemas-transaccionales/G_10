package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.CuentaEstadia;

public interface CuentaEstadiaRepository extends JpaRepository<CuentaEstadia, Integer> {

    // Método para listar todas las cuentas de estadía
    @Query(value = "SELECT * FROM cuentasestadia", nativeQuery = true)
    Collection<CuentaEstadia> listarCuentasEstadia();

    // Método para buscar una cuenta de estadía por su id
    @Query(value = "SELECT * FROM cuentasestadia WHERE id = :id", nativeQuery = true)
    CuentaEstadia buscarCuentaEstadiaPorId(@Param("id") int id);

    // Método para insertar una nueva cuenta de estadía
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentasestadia (monto, abierta) VALUES (:monto, :abierta)", nativeQuery = true)
    void insertarCuentaEstadia(@Param("monto") int monto, @Param("abierta") boolean abierta);

    // Método para actualizar una cuenta de estadía
    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentasestadia SET monto = :monto, abierta = :abierta WHERE id = :id", nativeQuery = true)
    void actualizarCuentaEstadia(@Param("id") int id, @Param("monto") int monto, @Param("abierta") boolean abierta);

    // Método para eliminar una cuenta de estadía por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentasestadia WHERE id = :id", nativeQuery = true)
    void eliminarCuentaEstadiaPorId(@Param("id") int id);
}
