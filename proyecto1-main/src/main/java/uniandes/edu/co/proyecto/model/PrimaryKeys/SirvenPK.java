package uniandes.edu.co.proyecto.model.primaryKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import uniandes.edu.co.proyecto.model.servicios.ProductoMenu;
import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;

@Embeddable
public class SirvenPK implements Serializable {

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_rest_bar", referencedColumnName = "id")
    private RestauranteBar id_rest_bar;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private ProductoMenu id_producto;

    public SirvenPK() {
        super();
    }

    public SirvenPK(RestauranteBar id_restaurante_bar, ProductoMenu id_producto) {
        super();
        this.id_rest_bar = id_restaurante_bar;
        this.id_producto = id_producto;
    }

    /**
     * @return the id_restaurante_bar
     */
    public RestauranteBar getId_rest_bar() {
        return id_rest_bar;
    }

    /**
     * @param id_rest_bar the id_restaurante_bar to set
     */
    public void setId_rest_bar(RestauranteBar id_rest_bar) {
        this.id_rest_bar = id_rest_bar;
    }

    /**
     * @return the id_producto
     */
    public ProductoMenu getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(ProductoMenu id_producto) {
        this.id_producto = id_producto;
    }

}
