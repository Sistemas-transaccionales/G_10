package uniandes.edu.co.proyecto.repository.requerimientos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.model.primaryKeys.UsuarioPK;

public interface Req7Repository extends JpaRepository<Usuario, UsuarioPK> {

    /*
     * MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
     * Los que fueron más consumidos en un período de tiempo dado.
     */
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> usuarios();

}
