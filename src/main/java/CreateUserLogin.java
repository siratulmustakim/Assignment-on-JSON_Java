import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// make json file empty[] before new run

public class CreateUserLogin {
    public static void main(String[] args) throws IOException, ParseException {
        String filePath = "./src/main/resources/users.json";

        //read and parse
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

//        Scanner n = new Scanner(System.in);
//        String m = n.nextLine();    // nextline die sentence input nei. next() die only one word
        // add data to this jsonArray
        JSONObject adminObject = new JSONObject();
        adminObject.put("username", "admin");
        adminObject.put("password", "1234");
        adminObject.put("role", "admin");

        JSONObject studentObject = new JSONObject();
        studentObject.put("username", "salman");
        studentObject.put("password", "1234");
        studentObject.put("role", "student");

        jsonArray.add(adminObject);
        jsonArray.add(studentObject);

        // write in json file
        FileWriter fw = new FileWriter(filePath);
        fw.write(jsonArray.toJSONString());   // must string convert korte hbe
        fw.flush(); // save file
        fw.close();

    }
}


















