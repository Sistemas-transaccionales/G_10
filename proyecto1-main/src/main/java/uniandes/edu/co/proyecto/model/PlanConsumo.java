package uniandes.edu.co.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes_consumo")
public class PlanConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo_plan;
    private Float tasa;
    private Integer min_noches;
    private Integer max_noches;

    public PlanConsumo() {
        ;
    }

    /**
     * @param tipo_plan
     * @param tasa
     * @param min_noches
     * @param max_noches
     */
    public PlanConsumo(String tipo_plan, Float tasa, Integer min_noches, Integer max_noches) {
        this.tipo_plan = tipo_plan;
        this.tasa = tasa;
        this.min_noches = min_noches;
        this.max_noches = max_noches;
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
     * @return the tipo_plan
     */
    public String getTipo_plan() {
        return tipo_plan;
    }

    /**
     * @param tipo_plan the tipo_plan to set
     */
    public void setTipo_plan(String tipo_plan) {
        this.tipo_plan = tipo_plan;
    }

    /**
     * @return the tasa
     */
    public Float getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(Float tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the min_noches
     */
    public Integer getMin_noches() {
        return min_noches;
    }

    /**
     * @param min_noches the min_noches to set
     */
    public void setMin_noches(Integer min_noches) {
        this.min_noches = min_noches;
    }

    /**
     * @return the max_noches
     */
    public Integer getMax_noches() {
        return max_noches;
    }

    /**
     * @param max_noches the max_noches to set
     */
    public void setMax_noches(Integer max_noches) {
        this.max_noches = max_noches;
    }

}
