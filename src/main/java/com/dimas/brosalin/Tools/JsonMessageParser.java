package com.dimas.brosalin.Tools;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by DmitriyBrosalin on 20/05/2017.
 */
public class JsonMessageParser {

    private JSONParser jsonParser;

    public JSONObject parseIncomingString(String incomingString){
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(incomingString);
            return jsonObject;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public JSONParser getJsonParser(){
        return this.jsonParser;
    }

    public void setJsonParser(JSONParser jsonParser) {
        this.jsonParser = jsonParser;
    }
}
