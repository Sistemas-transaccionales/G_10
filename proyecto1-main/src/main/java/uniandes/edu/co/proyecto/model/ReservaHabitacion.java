package uniandes.edu.co.proyecto.model;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id")
    private CuentaEstadia id_cuenta;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id", insertable = false, updatable = false)
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name = "tipo_doc", referencedColumnName = "tipo_doc", insertable = false, updatable = false)
    @JoinColumn(name = "num_doc", referencedColumnName = "num_doc", insertable = false, updatable = false)
    private Usuario usuario; // new field

    public ReservaHabitacion() {
        ;
    }

    public ReservaHabitacion(Habitacion id_habitacion, Usuario usuario, Date fecha_entrada, Date fecha_salida,
            PlanConsumo plan_consumo, Integer num_personas, Integer costo, CuentaEstadia id_cuenta_estadia) {

        this.pk = new ReservaHabitacionPK(id_habitacion, usuario, fecha_entrada, fecha_salida);
        this.id_habitacion = id_habitacion;
        this.usuario = usuario; // set the new field
        this.plan_consumo = plan_consumo;
        this.num_personas = num_personas;
        this.costo = costo;
        this.id_cuenta = id_cuenta_estadia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ReservaHabitacionPK getPk() {
        return pk;
    }

    public void setPk(ReservaHabitacionPK pk) {
        this.pk = pk;
    }

    public PlanConsumo getPlan_consumo() {
        return plan_consumo;
    }

    public void setPlan_consumo(PlanConsumo plan_consumo) {
        this.plan_consumo = plan_consumo;
    }

    public Integer getNum_personas() {
        return num_personas;
    }

    public void setNum_personas(Integer num_personas) {
        this.num_personas = num_personas;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public CuentaEstadia getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(CuentaEstadia id_cuenta_estadia) {
        this.id_cuenta = id_cuenta_estadia;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Date getFecha_entrada() {
        return this.pk.getFecha_entrada();
    }
    
    public Date getFecha_salida() {
        return this.pk.getFecha_salida();
    }
}
