import com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic.HazelCastService;
import com.dimas.brosalin.Mongo.MessageDAOLayer.MessageDAO;
import com.dimas.brosalin.Mongo.MessageService.QueueMessageService;
import com.dimas.brosalin.Mongo.MessageTemplate.MessageToQueue;
import com.dimas.brosalin.Services.HazelcastPersistanceToMongoService;
import com.dimas.brosalin.Tools.JsonMessageParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by DmitriyBrosalin on 17/05/2017.
 */


public class Main {

    public static String parseIncomingString(String incomingString){
        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(incomingString);
            return (String) jsonObject.get("key");
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws ParseException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
//        HazelcastPersistanceToMongoService persistanceToMongoService =
//                (HazelcastPersistanceToMongoService) context.getBean("persistMessagesHazelcastToMongo");
//        persistanceToMongoService.doPersistanceJob();

    }

}
