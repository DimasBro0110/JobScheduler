package com.dimas.brosalin.Mongo.MessageDAOLayer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public interface MessageDAO {

    void persistMessageToDisc(Object object);
    List<Object> getBatchOfMessagesFromDisc();
    int updateMessagesOnDisc(Timestamp timeIntervalMessages);
    int updateMessageOnDisc(String uniqueId);

}
