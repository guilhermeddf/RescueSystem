package br.ufrn.extension.gatinhos.rescuesystem.adoption;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends MongoRepository<Adoption, String> {
}
