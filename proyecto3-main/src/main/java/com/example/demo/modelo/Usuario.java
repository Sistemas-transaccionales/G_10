package com.example.demo.modelo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private ObjectId id;

    @Field("tipo_doc")
    private String tipoDoc;

    @Field("num_doc")
    private int numDoc;

    @Field("tipo")
    private String tipo;

    @Field("nombre")
    private String nombre;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("reservas_habitaciones")
    private List<ObjectId> reservasHabitaciones;

    @Field("reservas_servicios")
    private List<ObjectId> reservasServicios;

    public Usuario() {
    }

    public Usuario(ObjectId id, String tipo_doc, int num_doc, String tipo, String nombre, String email,
            String password, List<ObjectId> reservasHabitaciones,
            List<ObjectId> reservasServicios) {
        this.id = id;
        this.tipoDoc = tipo_doc;
        this.numDoc = num_doc;
        this.tipo = tipo;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.reservasHabitaciones = reservasHabitaciones;
        this.reservasServicios = reservasServicios;
    }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the tipo_doc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipo_doc the tipo_doc to set
     */
    public void setTipoDoc(String tipo_doc) {
        this.tipoDoc = tipo_doc;
    }

    /**
     * @return the num_doc
     */
    public int getNumDoc() {
        return numDoc;
    }

    /**
     * @param num_doc the num_doc to set
     */
    public void setNumDoc(int num_doc) {
        this.numDoc = num_doc;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
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

    /**
     * @return the reservasHabitaciones
     */
    public List<ObjectId> getReservasHabitaciones() {
        return reservasHabitaciones;
    }

    /**
     * @param reservasHabitaciones the reservasHabitaciones to set
     */
    public void setReservasHabitaciones(List<ObjectId> reservasHabitaciones) {
        this.reservasHabitaciones = reservasHabitaciones;
    }

    /**
     * @return the reservasServicios
     */
    public List<ObjectId> getReservasServicios() {
        return reservasServicios;
    }

    /**
     * @param reservasServicios the reservasServicios to set
     */
    public void setReservasServicios(List<ObjectId> reservasServicios) {
        this.reservasServicios = reservasServicios;
    }

}
