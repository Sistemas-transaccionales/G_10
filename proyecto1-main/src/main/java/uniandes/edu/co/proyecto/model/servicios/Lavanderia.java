package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;

@Entity
public class Lavanderia extends Servicio {

    private String tipo_prenda;
    private Integer num_prendas;
    private Integer costo;

    public Lavanderia() {
        super();
    }

    public Lavanderia(TipoServicio tipo, String nombre, String tipo_prenda, Integer num_prendas, Integer costo) {

        super(tipo, nombre);
        this.tipo_prenda = tipo_prenda;
        this.num_prendas = num_prendas;
        this.costo = costo;
    }

    /**
     * @return the tipo_prenda
     */
    public String getTipo_prenda() {
        return tipo_prenda;
    }

    /**
     * @param tipo_prenda the tipo_prenda to set
     */
    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    /**
     * @return the num_prendas
     */
    public Integer getNum_prendas() {
        return num_prendas;
    }

    /**
     * @param num_prendas the num_prendas to set
     */
    public void setNum_prendas(Integer num_prendas) {
        this.num_prendas = num_prendas;
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

}
