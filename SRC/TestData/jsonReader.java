//package SRC.TestData;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class jsonReader {
//
//    public String phoneNumber;
//    public String password;
//
//    public void jsonReader() throws IOException, ParseException {
//        String jsonPath = System.getProperty("user.dir") + "/SRC/TestData/userData.json";
//        File srcFile = new File(jsonPath);
//        JSONParser parser = new JSONParser();
//        JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));
//
//        JSONObject person;
//        for(Iterator var2 = jarray.iterator(); var2.hasNext();
//             {
//            Object jsonObj = var2.next();
//            person = (JSONObject)jsonObj;
//            this.phoneNumber = (String)person.get("phoneNumber");
//            this.password = (String)person.get("password");
//        }
//
//    }
//
//
//
//
//
//
//}
