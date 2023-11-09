package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.primaryKeys.Req1PK;

@Entity
@Table(name = "recoleccion")
public class Requerimiento1 {

    @EmbeddedId
    private Req1PK pk;

    @Column(name = "Total_Ganancia")
    private int totalGanancia;

    /**
     * @return the pk
     */
    public Req1PK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(Req1PK pk) {
        this.pk = pk;
    }

    /**
     * @return the totalGanancia
     */
    public int getTotalGanancia() {
        return totalGanancia;
    }

    /**
     * @param totalGanancia the totalGanancia to set
     */
    public void setTotalGanancia(int totalGanancia) {
        this.totalGanancia = totalGanancia;
    }

}