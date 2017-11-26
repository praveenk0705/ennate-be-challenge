package fi.pku.api.repository;

import fi.pku.api.document.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository extends MongoRepository<Alert,Integer>{
}
