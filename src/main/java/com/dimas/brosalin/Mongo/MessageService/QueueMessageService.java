package com.dimas.brosalin.Mongo.MessageService;

import com.dimas.brosalin.Mongo.MessageDAOLayer.MessageDAO;
import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public class QueueMessageService implements MessageDAO {

    private MongoTemplate mongoTemplate;

    @Override
    public void persistMessageToDisc(Object object) {
        System.out.println("Saving object");
        System.out.println(object);
        mongoTemplate.insert(object);
        System.out.println("Object saved");
    }

    @Override
    public void persistMessageToDisc(List<Object> listOfObjets) {
        mongoTemplate.insertAll(listOfObjets);
    }

    @Override
    public List<Object> getBatchOfMessagesFromDisc() {
        return null;
    }

    @Override
    public int updateMessagesOnDisc(Timestamp timeIntervalMessages) {
        return 0;
    }

    @Override
    public int updateMessageOnDisc(String uniqueId) {
        return 0;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
