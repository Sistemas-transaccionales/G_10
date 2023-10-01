package uniandes.edu.co.proyecto.model.servicios;

import jakarta.persistence.Entity;

@Entity
public class Gimnasio extends Servicio {

    private String hora_apertura;
    private String hora_clausura;
    private Integer capacidad;

    public Gimnasio() {
        super();
    }

    public Gimnasio(TipoServicio tipo, String nombre, String hora_apertura, String hora_clausura, Integer capacidad) {

        super(tipo, nombre);
        this.hora_apertura = hora_apertura;
        this.hora_clausura = hora_clausura;
        this.capacidad = capacidad;
    }

    /**
     * @return the hora_apertura
     */
    public String getHora_apertura() {
        return hora_apertura;
    }

    /**
     * @param hora_apertura the hora_apertura to set
     */
    public void setHora_apertura(String hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    /**
     * @return the hora_clausura
     */
    public String getHora_clausura() {
        return hora_clausura;
    }

    /**
     * @param hora_clausura the hora_clausura to set
     */
    public void setHora_clausura(String hora_clausura) {
        this.hora_clausura = hora_clausura;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
