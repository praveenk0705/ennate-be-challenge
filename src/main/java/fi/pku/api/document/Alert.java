package fi.pku.api.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Alert {
    @Id
    private long timeStamp;
    private int value;
    private String alertType;

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

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public Alert() {

    }

    public Alert(long timeStamp, int value, String alertType) {

        this.timeStamp = timeStamp;
        this.value = value;
        this.alertType = alertType;
    }
}
