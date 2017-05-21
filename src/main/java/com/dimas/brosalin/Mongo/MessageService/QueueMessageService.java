package com.dimas.brosalin.Mongo.MessageService;

import com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic.HazelCastService;
import com.dimas.brosalin.Mongo.MessageDAOLayer.MessageDAO;
import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import com.dimas.brosalin.Tools.JsonMessageParser;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public class QueueMessageService implements MessageDAO {

    private MongoTemplate mongoTemplate;
    private JsonMessageParser jsonMessageParser;
    private Logger logger = Logger.getLogger(QueueMessageService.class.getName());

    @Override
    public void persistMessageToDisc(Object object) {
        logger.log(Level.INFO, "Saving Object");
        logger.log(Level.INFO, "Object is: " + object);
        mongoTemplate.insert(object);
        logger.log(Level.INFO, "Object persisted");
    }

    @Override
    public void persistMessageToDisc(Object object, String topicName) {
        logger.log(Level.INFO, "Saving Object");
        logger.log(Level.INFO, "Object is: " + object);
        mongoTemplate.insert(object, topicName);
        logger.log(Level.INFO, "Object persisted");
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
