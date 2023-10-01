package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas_estadia")
public class CuentaEstadia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;
    private Integer monto;
    private Boolean abierta;

    public CuentaEstadia() {
        ;
    }

    public CuentaEstadia(Habitacion id_habitacion, Integer monto, Boolean abierta) {
        this.id_habitacion = id_habitacion;
        this.monto = monto;
        this.abierta = abierta;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the monto
     */
    public Integer getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    /**
     * @return the abierta
     */
    public Boolean getAbierta() {
        return abierta;
    }

    /**
     * @param abierta the abierta to set
     */
    public void setAbierta(Boolean abierta) {
        this.abierta = abierta;
    }

    /**
     * @return the id_habitacion
     */
    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    /**
     * @param id_habitacion the id_habitacion to set
     */
    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

}
