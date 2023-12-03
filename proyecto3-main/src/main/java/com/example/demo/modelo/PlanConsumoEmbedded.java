package com.example.demo.modelo;

public class PlanConsumoEmbedded {

    private String nombre;
    private float tasa;
    private int minNoches;
    private int maxNoches;

    public PlanConsumoEmbedded() {
    }

    public PlanConsumoEmbedded(String nombre, float tasa, int minNoches, int maxNoches) {

        this.nombre = nombre;
        this.tasa = tasa;
        this.minNoches = minNoches;
        this.maxNoches = maxNoches;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tasa
     */
    public float getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the minNoches
     */
    public int getMinNoches() {
        return minNoches;
    }

    /**
     * @param minNoches the minNoches to set
     */
    public void setMinNoches(int minNoches) {
        this.minNoches = minNoches;
    }

    /**
     * @return the maxNoches
     */
    public int getMaxNoches() {
        return maxNoches;
    }

    /**
     * @param maxNoches the maxNoches to set
     */
    public void setMaxNoches(int maxNoches) {
        this.maxNoches = maxNoches;
    }

}
