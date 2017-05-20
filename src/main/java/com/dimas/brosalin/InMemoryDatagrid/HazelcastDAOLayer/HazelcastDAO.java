package com.dimas.brosalin.InMemoryDatagrid.HazelcastDAOLayer;

import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public interface HazelcastDAO {

    List<MessageToQueue> getMessagesFromCollection();

}
