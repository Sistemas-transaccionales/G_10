package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.model.PrimaryKeys.UsuarioPK;

public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPK> {

    // Método para listar todos los usuarios
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> listarUsuarios();

    // Método para buscar un usuario por su id (clave primaria compuesta)
    @Query(value = "SELECT * FROM usuarios WHERE num_doc = :numDoc AND tipo_doc = :tipoDoc", nativeQuery = true)
    Usuario buscarUsuarioPorId(@Param("numDoc") Integer numDoc, @Param("tipoDoc") String tipoDoc);

    // Método para insertar un nuevo usuario
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (num_doc, tipo_doc, tipo_id, nombre, email, password) VALUES (:numDoc, :tipoDoc, :tipoId, :nombre, :email, :password)", nativeQuery = true)
    void insertarUsuario(@Param("numDoc") Integer numDoc, @Param("tipoDoc") String tipoDoc, @Param("tipoId") Integer tipoId, @Param("nombre") String nombre, @Param("email") String email, @Param("password") String password);

    // Método para actualizar un usuario
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET tipo_id = :tipoId, nombre = :nombre, email = :email, password = :password WHERE num_doc = :numDoc AND tipo_doc = :tipoDoc", nativeQuery = true)
    void actualizarUsuario(@Param("numDoc") Integer numDoc, @Param("tipoDoc") String tipoDoc, @Param("tipoId") Integer tipoId, @Param("nombre") String nombre, @Param("email") String email, @Param("password") String password);

    // Método para eliminar un usuario por su id (clave primaria compuesta)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE num_doc = :numDoc AND tipo_doc = :tipoDoc", nativeQuery = true)
    void eliminarUsuarioPorId(@Param("numDoc") Integer numDoc, @Param("tipoDoc") String tipoDoc);
}