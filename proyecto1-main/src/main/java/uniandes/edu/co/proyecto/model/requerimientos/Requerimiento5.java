package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.primaryKeys.UsuarioPK;

@Entity
@Table(name = "consumos_usuario")
public class Requerimiento5 {

    @EmbeddedId
    private UsuarioPK pk;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "servicio_id")
    private int idServicio;

    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "costo")
    private int costo;

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the nombreServicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param nombreServicio the nombreServicio to set
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the costo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * @return the pk
     */
    public UsuarioPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(UsuarioPK pk) {
        this.pk = pk;
    }

}
