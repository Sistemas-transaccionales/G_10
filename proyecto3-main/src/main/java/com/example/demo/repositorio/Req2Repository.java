package com.example.demo.repositorio;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Collectors;
import com.example.demo.modelo.Req2;

@Repository
public class Req2Repository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Collection<Req2> habitaciones() {
        MongoCollection<Document> collection = mongoTemplate.getCollection("reservas_habitaciones");

        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        Date dateOneYearAgo = Date.from(oneYearAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Document> pipeline = Arrays.asList(
            new Document("$match", new Document("fecha_inicio", new Document("$gte", dateOneYearAgo))),
            new Document("$group", new Document("_id", "$id_habitacion")
                .append("Dias_Ocupados", new Document("$sum", 1))),
            new Document("$project", new Document("Tasa_Ocupacion", new Document("$multiply", Arrays.asList(new Document("$divide", Arrays.asList("$Dias_Ocupados", 365.0)), 100)))),
            new Document("$sort", new Document("Tasa_Ocupacion", -1))
        );

        List<Document> results = collection.aggregate(pipeline).into(new ArrayList<>());

        return results.stream().map(document -> new Req2(
            document.getString("_id"),
            document.getInteger("Dias_Ocupados", 0),
            document.getDouble("Tasa_Ocupacion")
        )).collect(Collectors.toList());
    }
}