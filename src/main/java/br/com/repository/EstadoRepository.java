package br.com.repository;

import br.com.model.Estado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface EstadoRepository extends MongoRepository<Estado, String> {
}
