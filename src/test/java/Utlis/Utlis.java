package Utlis;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utlis {
    public static void  saveUser(String firstname,String lastname,String username,String password) throws IOException, ParseException {
        String filelocation="./src/test/resources/User.json";
        JSONParser parser=new JSONParser();
        JSONArray emparray= (JSONArray) parser.parse(new FileReader(filelocation));
        JSONObject obj=new JSONObject();
        obj.put("firstname",firstname);
        obj.put("lastname",lastname);
        obj.put("username",username);
        obj.put("password",password);
        emparray.add(obj);

        FileWriter writer=new FileWriter(filelocation);
        writer.write(emparray.toJSONString());
        writer.flush();
        writer.close();


    }
}
