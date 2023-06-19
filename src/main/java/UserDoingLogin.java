import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserDoingLogin {
    public static void main(String[] args) throws IOException, ParseException {
        String filePath = "./src/main/resources/users.json";
        String username, password;
        Boolean flag = false;

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter your username ");
        username = input.next().toLowerCase();   // make lowercase
        System.out.println("Enter password ");
        password = input.next();

        // read and parse
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

//        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
//        System.out.println(jsonObject.get("username"));


        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (username.equals(jsonObject.get("username").toString())){
//                System.out.println("name ok");
                if (password.equals(jsonObject.get("password").toString())){
                    flag = true;
//                    System.out.println("pass ok");
                    break;
                }
                else {System.out.println("\nWrong password");
                    break;}
            }
            else if(i == jsonArray.size() - 1){
                System.out.println("\nWrong username");
                }

        }
        if (flag == true){
            if (username.equals("admin")){
                System.out.println("Welcome admin! Please create new questions in the question bank.");

                CreatingQuizAdmin cQuiz = new CreatingQuizAdmin();
                cQuiz.createQuiz();
            }
            else {
                    StudentAttendingQuiz aQuiz = new StudentAttendingQuiz();
                    aQuiz.attendQuiz(username);
            }
        }

    }
}
