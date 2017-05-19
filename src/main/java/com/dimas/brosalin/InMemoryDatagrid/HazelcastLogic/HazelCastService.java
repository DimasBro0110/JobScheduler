package com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic;

import com.dimas.brosalin.InMemoryDatagrid.HazelcastDAOLayer.HazelcastDAO;
import com.dimas.brosalin.Tools.JsonMessageParser;
import com.hazelcast.core.HazelcastInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public class HazelCastService implements HazelcastDAO{

    private HazelcastInstance hazelcastInstance;
    private List<String> listOfHazelCollections;
    private JsonMessageParser jsonMessageParser;

    public HazelcastInstance getHazelcastInstance() {
        return hazelcastInstance;
    }

    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public List<String> getListOfHazelCollections() {
        return listOfHazelCollections;
    }

    public void setListOfHazelCollections(List<String> listOfHazelCollections) {
        this.listOfHazelCollections = listOfHazelCollections;
    }

    @Override
    public List<String> getMessagesFromCollection() {
        BlockingQueue<String> tempListOfWholeCollectionsBlocking;
        List<String> wholeListOfCollections;
        try{
            if(listOfHazelCollections != null && listOfHazelCollections.size() > 0){
                wholeListOfCollections = new ArrayList<>();
                for (int i=0; i<listOfHazelCollections.size(); i++){
                    String tempNameOfTopic = listOfHazelCollections.get(i);
                    tempListOfWholeCollectionsBlocking = this.getHazelcastInstance().getQueue(tempNameOfTopic);
                    int curSize = tempListOfWholeCollectionsBlocking.size();
                    while(curSize != 0){
                        wholeListOfCollections.add(
                                tempListOfWholeCollectionsBlocking
                                        .poll(100, TimeUnit.MILLISECONDS)
                        );
                        curSize -= 1;
                    }
                }
                return wholeListOfCollections;
            }
            else{
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public JsonMessageParser getJsonMessageParser() {
        return jsonMessageParser;
    }

    public void setJsonMessageParser(JsonMessageParser jsonMessageParser) {
        this.jsonMessageParser = jsonMessageParser;
    }
}
