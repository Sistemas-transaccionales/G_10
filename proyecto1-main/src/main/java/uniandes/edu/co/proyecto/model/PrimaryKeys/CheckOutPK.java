package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import uniandes.edu.co.proyecto.model.CheckIn;

@Embeddable
public class CheckOutPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_check_in", referencedColumnName = "id")
    private CheckIn id_check_in;

    public CheckOutPK() {
        super();
    }

    public CheckOutPK(CheckIn id_check_in) {

        super();
        this.id_check_in = id_check_in;
    }

    /**
     * @return the id_check_in
     */
    public CheckIn getId_check_in() {
        return id_check_in;
    }

    /**
     * @param id_check_in the id_check_in to set
     */
    public void setId_check_in(CheckIn id_check_in) {
        this.id_check_in = id_check_in;
    }

}
