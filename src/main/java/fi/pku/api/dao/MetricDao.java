package fi.pku.api.dao;

import fi.pku.api.document.Metric;
import fi.pku.api.morphia.config.MorphiaContext;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MetricDao {
    private Datastore datastore;

    MetricDao() {
        datastore = MorphiaContext.getMorphiaContext().getDatastore();
    }

    public Key<Metric> create(Metric metric) {
        return datastore.save(metric);
    }

    public List<Metric> read() {
        Query<Metric> query = datastore.createQuery(Metric.class);
        return query.asList();
    }

    public List<Metric> rangeRead(long startTime, long endTime) {
        Query<Metric> query = datastore.createQuery(Metric.class)
                .filter("timeStamp >=", startTime).filter("timeStamp <=", endTime);

        return query.asList();
    }
}
