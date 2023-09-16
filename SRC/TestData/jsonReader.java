package SRC.TestData;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReader {

    public String phoneNumber;
    public String password;
    public String fullName;
    public String mobileNumber;
    public String streetName;
    public String buildingNumber;
    public String city;
    public String district;
    public String landmark;

    public String pricePerItem;

    public void jsonFileReader() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("SRC/TestData/userData.json"));

        phoneNumber = (String) jsonObject.get("phoneNumber");
        password = (String) jsonObject.get("password");
        fullName = (String) jsonObject.get("addressFullName");
        mobileNumber = (String) jsonObject.get("addressMobileNumber");
        streetName = (String) jsonObject.get("addNewAddressStreetName");
        buildingNumber = (String) jsonObject.get("addNewAddressBuildingNumber");
        city = (String) jsonObject.get("addNewAddressCity");
        district = (String) jsonObject.get("addNewAddressDistrict");
        landmark = (String) jsonObject.get("addNewAddressLandmark");
        pricePerItem = (String) jsonObject.get("itemPrice");

    }


}
