package com.dimas.brosalin.Mongo.MessageService;

import com.dimas.brosalin.Mongo.MessageDAOLayer.MessageDAO;
import org.springframework.data.mongodb.core.MongoOperations;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public class QueueMessageService implements MessageDAO {

    private MongoOperations mongoTemplate;

    @Override
    public void persistMessageToDisc(Object object) {

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

    public MongoOperations getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
