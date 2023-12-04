package com.example.demo.repositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {

    Optional<Usuario> findByTipoDocAndNumDoc(String tipoDoc, int numDoc);

}
