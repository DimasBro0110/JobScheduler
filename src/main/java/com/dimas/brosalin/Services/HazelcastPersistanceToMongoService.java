package com.dimas.brosalin.Services;

import com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic.HazelCastService;
import com.dimas.brosalin.Mongo.MessageService.QueueMessageService;
import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import com.dimas.brosalin.Tools.JsonMessageParser;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by DmitriyBrosalin on 20/05/2017.
 */
public class HazelcastPersistanceToMongoService {

    private HazelCastService hazelCastService;
    private QueueMessageService queueMessageService;

    public void makePersistanceJob(){
        List<MessageToQueue> lstOfMessagesFromAllCollectionsJson = hazelCastService.getMessagesFromCollection();

    }

    private void persistOnDisc(){

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
