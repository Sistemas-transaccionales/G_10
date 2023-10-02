package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Embeddable
public class UsuarioPK implements Serializable {

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "num_doc", referencedColumnName = "id")
    private Integer num_doc;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "tipo_doc", referencedColumnName = "id")
    private String tipo_doc;

    public UsuarioPK() {
        super();
    }

    public UsuarioPK(Integer num_doc, String tipo_doc) {

        super();
        this.num_doc = num_doc;
        this.tipo_doc = tipo_doc;
    }

    /**
     * @return the num_doc
     */
    public Integer getNum_doc() {
        return num_doc;
    }

    /**
     * @param num_doc the num_doc to set
     */
    public void setNum_doc(Integer num_doc) {
        this.num_doc = num_doc;
    }

    /**
     * @return the tipo_doc
     */
    public String getTipo_doc() {
        return tipo_doc;
    }

    /**
     * @param tipo_doc the tipo_doc to set
     */
    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

}
