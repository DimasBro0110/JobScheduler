package com.dimas.brosalin.Tools;

import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sun.plugin2.message.Message;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DmitriyBrosalin on 20/05/2017.
 */
public class JsonMessageParser {

    public JSONObject parseIncomingString(String incomingString){
        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(incomingString);
            return jsonObject;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public MessageToQueue parseJsonObjectToMessage(JSONObject object){
        MessageToQueue messageToQueue = new MessageToQueue();
        messageToQueue.setTopicName((String)object.get("topicName"));
        messageToQueue.setId((String)object.get("Id"));
        messageToQueue.setMessageTime(new Timestamp(Long.parseLong((String)object.get("messageTime"))));
        messageToQueue.setMessagePlot((String)object.get("messagePlot"));
        return messageToQueue;
    }

    public List<MessageToQueue> parseJsonObjectList(List<JSONObject> lstOfJsons){
        try{
            if(lstOfJsons != null && lstOfJsons.size() > 0){
                List<MessageToQueue> listOfMessages =
                        lstOfJsons.stream()
                                .map(this::parseJsonObjectToMessage)
                                .collect(Collectors.toList());
                return listOfMessages;
            }else{
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<MessageToQueue> sortByTimeMarker(List<MessageToQueue> listToSort){
        try {
            if (listToSort != null && listToSort.size() > 0) {
                listToSort.sort(Comparator.comparing(MessageToQueue::getMessageTime));
                return listToSort;
            } else {
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
