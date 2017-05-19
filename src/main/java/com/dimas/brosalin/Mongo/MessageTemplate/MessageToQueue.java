package com.dimas.brosalin.Mongo.MessageTemplate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */

@Document(collection = "BirdQueue")
public class MessageToQueue {

    @Id
    private String id;
    private String messagePlot;
    private String topicName;
    private Timestamp messageTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessagePlot() {
        return messagePlot;
    }

    public void setMessagePlot(String messagePlot) {
        this.messagePlot = messagePlot;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
