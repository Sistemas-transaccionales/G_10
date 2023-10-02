package uniandes.edu.co.proyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.model.primaryKeys.UsuarioPK;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @EmbeddedId
    private UsuarioPK pk;

    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    private TipoUsuario tipo;

    private String nombre;
    private String email;
    private String password;

    public Usuario() {
        ;
    }

    public Usuario(Integer num_doc, String tipo_doc, TipoUsuario tipo, String nombre, String email, String password) {

        this.pk = new UsuarioPK(num_doc, tipo_doc);
        this.tipo = tipo;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the pk
     */
    public UsuarioPK getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(UsuarioPK pk) {
        this.pk = pk;
    }

    /**
     * @return the tipo
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}