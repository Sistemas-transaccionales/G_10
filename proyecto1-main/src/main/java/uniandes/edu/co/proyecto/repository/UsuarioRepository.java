package uniandes.edu.co.proyecto.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.model.primaryKeys.UsuarioPK;

public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPK> {

        // Método para listar todos los usuarios
        @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
        Collection<Usuario> listarUsuarios();

        // Método para buscar un usuario por su id (llave primaria compuesta)
        @Query(value = "SELECT * FROM usuarios WHERE num_doc = :num_doc AND tipo_doc = :tipo_doc", nativeQuery = true)
        Usuario buscarUsuarioPorId(@Param("num_doc") Integer num_doc, @Param("tipo_doc") String tipo_doc);

        // Método para insertar un nuevo usuario
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO usuarios (num_doc, tipo_doc, tipo_id, nombre, email, contrasenia) VALUES (:num_doc, :tipo_doc, :tipo, :nombre, :email, :contrasenia)", nativeQuery = true)
        void insertarUsuario(@Param("num_doc") Integer numDoc, @Param("tipo_doc") String tipoDoc,
                        @Param("tipo") Integer tipoId, @Param("nombre") String nombre, @Param("email") String email,
                        @Param("contrasenia") String contrasenia);

        // Método para actualizar un usuario
        @Modifying
        @Transactional
        @Query(value = "UPDATE usuarios SET tipo = :tipo, nombre = :nombre, email = :email, contrasenia = :contrasenia WHERE num_doc = :num_doc AND tipo_doc = :tipo_doc", nativeQuery = true)
        void actualizarUsuario(@Param("num_doc") Integer num_doc, @Param("tipo_doc") String tipo_doc,
                        @Param("tipo") Integer tipo, @Param("nombre") String nombre, @Param("email") String email,
                        @Param("contrasenia") String contrasenia);

        // Método para eliminar un usuario por su id (clave primaria compuesta)
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM usuarios WHERE num_doc = :num_doc AND tipo_doc = :tipo_doc", nativeQuery = true)
        void eliminarUsuarioPorId(@Param("num_doc") Integer numDoc, @Param("tipo_doc") String tipo_doc);
}