package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    // Método para listar todos los tipos de usuario
    @Query(value = "SELECT * FROM tipos_usuario", nativeQuery = true)
    Collection<TipoUsuario> listarTiposUsuario();

    // Método para buscar un tipo de usuario por su id
    @Query(value = "SELECT * FROM tipos_usuario WHERE id = :id", nativeQuery = true)
    TipoUsuario buscarTipoUsuarioPorId(@Param("id") int id);

    // Método para insertar un nuevo tipo de usuario
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipos_usuario (id, nombre) VALUES (id_tipos_usuario.NEXTVAL, :nombre)", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre);

    // Método para actualizar un tipo de usuario
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipos_usuario SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") int id, @Param("nombre") String nombre);

    // Método para eliminar un tipo de usuario por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipos_usuario WHERE id = :id", nativeQuery = true)
    void eliminarTipoUsuarioPorId(@Param("id") int id);
}