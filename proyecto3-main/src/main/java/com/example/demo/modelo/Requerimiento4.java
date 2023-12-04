package com.example.demo.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "consumo")
public class Requerimiento4 {

    @Id
    private ObjectId id;

    private String id_habitacion;
    private Usuario usuario;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int num_personas;
    private PlanConsumoEmbedded plan_consumo;
    private double costo_reserva;
    private int costo_consumos;
    private boolean cuenta_abierta;
    private Date fecha_check_in;
    private Date fecha_check_out;

    // Constructor, getters, and setters

}
