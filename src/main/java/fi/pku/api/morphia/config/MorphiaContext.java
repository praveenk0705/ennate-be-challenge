package fi.pku.api.morphia.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaContext {
    private static MorphiaContext morphiaContext = new MorphiaContext();

    private Datastore datastore;

    public MorphiaContext() {
        Morphia morphia = new Morphia();
        datastore = morphia.createDatastore(new MongoClient(), "morphiaDb");
        datastore.ensureIndexes();
    }

    public static MorphiaContext getMorphiaContext() {
        return morphiaContext;
    }

    public static void setMorphiaContext(MorphiaContext morphiaContext) {
        MorphiaContext.morphiaContext = morphiaContext;
    }

    public Datastore getDatastore() {
        return datastore;
    }
}
