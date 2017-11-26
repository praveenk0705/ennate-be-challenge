package fi.pku.api.dao;

import fi.pku.api.document.Alert;
import fi.pku.api.morphia.config.MorphiaContext;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AlertDao {
    private Datastore datastore;

    AlertDao() {
        datastore = MorphiaContext.getMorphiaContext().getDatastore();
    }

    public Key<Alert> create(Alert alert) {
        return datastore.save(alert);
    }

    public List<Alert> read() {
        Query<Alert> query = datastore.createQuery(Alert.class);
        return query.asList();
    }

    public List<Alert> rangeRead(long startTime, long endTime) {
        Query<Alert> query = datastore.createQuery(Alert.class)
                .filter("timeStamp >=", startTime).filter("timeStamp <=", endTime);

        return query.asList();
    }
}
