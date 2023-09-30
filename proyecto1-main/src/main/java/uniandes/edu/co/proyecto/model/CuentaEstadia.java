package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas_estadia")
public class CuentaEstadia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer monto;
    private Boolean abierta;

    public CuentaEstadia() {
        ;
    }

    public CuentaEstadia(Integer monto, Boolean abierta) {
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

}
