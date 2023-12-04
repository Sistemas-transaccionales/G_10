package com.example.demo.repositorio;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import com.example.demo.modelo.Req1;

@Repository
public class Req1Repository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Collection<Req1> dinero_recolectado() {
        MongoCollection<Document> collection = mongoTemplate.getCollection("reservas_servicios");

        Date oneYearAgo = new Date(System.currentTimeMillis() - 365L * 24 * 60 * 60 * 1000);

        List<Document> pipeline = Arrays.asList(
            new Document("$match", new Document("fecha", new Document("$gte", oneYearAgo))
                .append("id_servicio", new Document("$type", "objectId"))
                .append("id_reserva_habitacion", new Document("$type", "objectId"))
                .append("usuario", new Document("$type", "object"))
                .append("costo", new Document("$type", "number"))),
            new Document("$lookup", new Document("from", "servicios")
                .append("localField", "id_servicio")
                .append("foreignField", "_id")
                .append("as", "servicio_info")),
            new Document("$lookup", new Document("from", "reservas_habitaciones")
                .append("localField", "id_reserva_habitacion")
                .append("foreignField", "_id")
                .append("as", "reserva_info")),
            new Document("$unwind", "$servicio_info"),
            new Document("$unwind", "$reserva_info"),
            new Document("$group", new Document("_id", new Document("id_habitacion", "$reserva_info.id_habitacion").append("nombre_servicio", "$servicio_info.nombre"))
                .append("Total_Ganancia", new Document("$sum", "$costo"))),
            new Document("$sort", new Document("_id.id_habitacion", 1))
        );

        List<Document> results = collection.aggregate(pipeline).into(new ArrayList<>());

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);

        return results.stream().map(document -> {
            Object totalGananciaObj = document.get("Total_Ganancia");
            Double totalGanancia;
            if (totalGananciaObj instanceof Integer) {
                totalGanancia = ((Integer) totalGananciaObj).doubleValue();
            } else {
                totalGanancia = (Double) totalGananciaObj;
            }
            String totalGananciaStr = df.format(totalGanancia);
            return new Req1(
                ((Document) document.get("_id")).getString("id_habitacion"),
                ((Document) document.get("_id")).getString("nombre_servicio"),
                totalGananciaStr
            );
        }).collect(Collectors.toList());
    }
}