package fi.pku.api.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Metric {
    @Id
    private long timeStamp;
    private int value;


    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Metric() {

    }

    public Metric(long timeStamp, int value) {


        this.timeStamp = timeStamp;
        this.value = value;
    }
}
