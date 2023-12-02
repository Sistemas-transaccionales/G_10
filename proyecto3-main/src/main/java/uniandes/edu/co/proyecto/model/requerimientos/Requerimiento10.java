package uniandes.edu.co.proyecto.model.requerimientos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes_no_consumidores")
public class Requerimiento10 {

    @Id
    @Column(name = "num_doc")
    private Integer numDoc;

    @Column(name = "tipo_doc")
    private String tipoDoc;

    @Column(name = "nombre")
    private String nombre;

    public Integer getNum_doc() {
        return numDoc;
    }

    public void setNum_doc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getTipo_doc() {
        return tipoDoc;
    }

    public void setTipo_doc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
