package uniandes.edu.co.proyecto.model;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.primaryKeys.ReservaHabitacionPK;

@Entity
@Table(name = "reservas_habitacion")
public class ReservaHabitacion {

    @EmbeddedId
    private ReservaHabitacionPK pk;

    @ManyToOne
    @JoinColumn(name = "plan_consumo", referencedColumnName = "id")
    private PlanConsumo plan_consumo;

    private Integer num_personas;
    private Integer costo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_estadia", referencedColumnName = "id")
    private CuentaEstadia id_cuenta_estadia;

    public ReservaHabitacion() {
        ;
    }

    public ReservaHabitacion(Habitacion id_habitacion, Usuario id_usuario, Date fecha_entrada, Date fecha_salida,
            PlanConsumo plan_consumo, Integer num_personas, Integer costo, CuentaEstadia id_cuenta_estadia) {

        this.pk = new ReservaHabitacionPK(id_habitacion, id_usuario, fecha_entrada, fecha_salida);

        this.plan_consumo = plan_consumo;
        this.num_personas = num_personas;
        this.costo = costo;
        this.id_cuenta_estadia = id_cuenta_estadia;
    }

    /**
     * @return the pk
     */
    public ReservaHabitacionPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(ReservaHabitacionPK pk) {
        this.pk = pk;
    }

    /**
     * @return the plan_consumo
     */
    public PlanConsumo getPlan_consumo() {
        return plan_consumo;
    }

    /**
     * @param plan_consumo the plan_consumo to set
     */
    public void setPlan_consumo(PlanConsumo plan_consumo) {
        this.plan_consumo = plan_consumo;
    }

    /**
     * @return the num_personas
     */
    public Integer getNum_personas() {
        return num_personas;
    }

    /**
     * @param num_personas the num_personas to set
     */
    public void setNum_personas(Integer num_personas) {
        this.num_personas = num_personas;
    }

    /**
     * @return the costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    /**
     * @return the id_cuenta_estadia
     */
    public CuentaEstadia getId_cuenta_estadia() {
        return id_cuenta_estadia;
    }

    /**
     * @param id_cuenta_estadia the id_cuenta_estadia to set
     */
    public void setId_cuenta_estadia(CuentaEstadia id_cuenta_estadia) {
        this.id_cuenta_estadia = id_cuenta_estadia;
    }

}
