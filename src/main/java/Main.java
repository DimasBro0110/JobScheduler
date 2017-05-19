import com.dimas.brosalin.InMemoryDatagrid.HazelcastLogic.HazelCastService;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by DmitriyBrosalin on 17/05/2017.
 */


public class Main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoTemplate");
        HazelCastService hazelCastService = (HazelCastService) context.getBean("hazelcastService");
        System.out.println(hazelCastService.getMessagesFromCollection());

    }

}
