package uniandes.edu.co.proyecto.repository.servicios_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.model.primaryKeys.SirvenPK;
import uniandes.edu.co.proyecto.model.servicios.Sirven;

public interface SirvenRepository extends JpaRepository<Sirven, SirvenPK> {

    // Método para buscar una relación Sirven por su clave compuesta
    @Query("SELECT s FROM Sirven s WHERE s.pk = :pk")
    Sirven buscarSirvenPorPK(@Param("pk") SirvenPK pk);

    // Método para insertar una nueva relación Sirven
    @Modifying
    @Transactional
    @Query("INSERT INTO Sirven (pk) VALUES (:pk)")
    void insertarSirven(@Param("pk") SirvenPK pk);

    // Método para eliminar una relación Sirven por su clave compuesta
    @Modifying
    @Transactional
    @Query("DELETE FROM Sirven s WHERE s.pk = :pk")
    void eliminarSirvenPorPK(@Param("pk") SirvenPK pk);
}
