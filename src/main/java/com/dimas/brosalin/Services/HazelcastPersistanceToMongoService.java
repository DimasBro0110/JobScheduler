package com.dimas.brosalin.Services;

import com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic.HazelCastService;
import com.dimas.brosalin.Mongo.MessageService.QueueMessageService;
import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import com.dimas.brosalin.Tools.JsonMessageParser;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DmitriyBrosalin on 20/05/2017.
 */
public class HazelcastPersistanceToMongoService {

    private HazelCastService hazelCastService;
    private QueueMessageService queueMessageService;
    private Logger logger = Logger.getLogger(HazelCastService.class.getName());

    public void doPersistanceJob(){
        logger.log(Level.INFO, "Started persistence job");
        List<MessageToQueue> lstOfMessagesFromAllCollectionsJson = hazelCastService.getMessagesFromCollection();
        if(lstOfMessagesFromAllCollectionsJson != null
                && lstOfMessagesFromAllCollectionsJson.size() > 0) {
            lstOfMessagesFromAllCollectionsJson.forEach(this::persistOnDisc);
            logger.log(Level.INFO, "Persistence job completed");
        }else {
            logger.log(Level.INFO, "Queues are empty");
        }
    }

    private void persistOnDisc(MessageToQueue messageToQueue){
        queueMessageService.persistMessageToDisc(messageToQueue, messageToQueue.getTopicName());
    }

    public HazelCastService getHazelCastService() {
        return hazelCastService;
    }

    public void setHazelCastService(HazelCastService hazelCastService) {
        this.hazelCastService = hazelCastService;
    }

    public QueueMessageService getQueueMessageService() {
        return queueMessageService;
    }

    public void setQueueMessageService(QueueMessageService queueMessageService) {
        this.queueMessageService = queueMessageService;
    }
}
