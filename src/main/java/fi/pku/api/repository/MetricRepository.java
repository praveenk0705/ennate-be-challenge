package fi.pku.api.repository;

import fi.pku.api.document.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetricRepository extends MongoRepository<Metric,Integer> {
}
