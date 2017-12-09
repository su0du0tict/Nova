package Test_Package;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;



public class Pickup_Activity 
{

String Dev_URL="https://wcinc-dev.azurewebsites.net/api/v1/incoming";
String QA_URL="https://wcinc-dev.azurewebsites.net/api/v1/incoming";
String UAT_URL="https://dashincbeta.wcnovatestext.p.azurewebsites.net/api/v1/incoming";
String Primary_Driver="v415945";
String Secondary_Driver="54383";
String Location="PHL";
String Dev="TW9iaWxpdHlUZWFtQW1lcmlzb3VyY2VCZXJnZW4x";

	
@Test(groups="Rest_API"/*,invocationCount =10/*, threadPoolSize = 100*/)
public void Send_Pickup() throws IOException, InterruptedException 
{
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	String url = Dev_URL;
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	//add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("API_KEY", Dev);
			con.setRequestProperty("Content-Type", "application/json");

			String urlParameters = "{\r\n" + 
					"    \"job\": {\r\n" + 
					"        \"jobId\": \"T"+timeStamp+"N\",\r\n" + 
					"        \"hawb\": \"480014123\",\r\n" + 
					"        \"shipmentStatus\": \"30\",\r\n" + 
					"        \"shipmentDescription\": \"Something Nice and pricy\",\r\n" + 
					"        \"address\": [\r\n" + 
					"            {\r\n" + 
					"                \"type\": \"from\",\r\n" + 
					"                \"companyName\": \"Children's hospital of Philadelphis\",\r\n" + 
					"                \"contactName\": \"Patch Adams\",\r\n" + 
					"                \"address1\": \"3401 Civic Center Blvd\",\r\n" + 
					"                \"address2\": \"\",\r\n" + 
					"                \"city\": \"Philadelphia\",\r\n" + 
					"                \"state\": \"PA\",\r\n" + 
					"                \"zipCode\": \"19104\",\r\n" + 
					"                \"countryCode\": \"US\",\r\n" + 
					"                \"isConfidential\": false\r\n" + 
					"            },\r\n" + 
					"            {\r\n" + 
					"                \"type\": \"to\",\r\n" + 
					"                \"companyName\": \"Hogwarts Magic Health Care Centre United\",\r\n" + 
					"                \"contactName\": \"Harry Pother the 3rd and the Great\",\r\n" + 
					"                \"address1\": \"Third floor, Centurion\",\r\n" + 
					"                \"address2\": \"House, 37, Jewrey St\",\r\n" + 
					"                \"city\": \"LONDON\",\r\n" + 
					"                \"state\": \"\",\r\n" + 
					"                \"zipCode\": \"EC3N 2ER\",\r\n" + 
					"                \"countryCode\": \"GB\",\r\n" + 
					"                \"isConfidential\": false\r\n" + 
					"            }\r\n" + 
					"        ],\r\n" + 
					"        \"dispatch\": {\r\n" + 
					"            \"location\": \""+Location+"\",\r\n" + 
					"            \"activity\": {\r\n" + 
					"                \"type\": \"PU\",\r\n" + 
					"                \"pieceCount\": 2,\r\n" + 
					"                \"shipmentWeightUnitOfMeasurement\": \"LB\",\r\n" + 
					"                \"completeShipmentWeight\": 45.0,\r\n" + 
					"                \"items\": [\r\n" + 
					"                    {\r\n" + 
					"                        \"itemLineNumber\": \"1\",\r\n" + 
					"                        \"description\": \"Brand new black helmet\",\r\n" + 
					"                        \"pieceCount\": 100,\r\n" + 
					"                        \"weightUnitOfMeasure\": \"LB\",\r\n" + 
					"                        \"weight\": 45.0,\r\n" + 
					"                        \"dimensionUnitOfMeasure\": \"IN\",\r\n" + 
					"                        \"dimensionHeight\": 60.0,\r\n" + 
					"                        \"dimensionWidth\": 50.0,\r\n" + 
					"                        \"dimensionLength\": 45.0,\r\n" + 
					"                        \"dangerousGoodsDeclaration\": false,\r\n" + 
					"                        \"class\": \"Biological Substance CatB\",\r\n" + 
					"                        \"tempRange\": \"Ambient\",\r\n" + 
					"                        \"useTempMonitor\": false\r\n" + 
					"                    }\r\n" + 
					"                ],\r\n" + 
					"                \"address\": [\r\n" + 
					"                    {\r\n" + 
					"                        \"companyName\": \"Children's hospital of Philadelphis\",\r\n" + 
					"                        \"contactName\": \"Patch Adams\",\r\n" + 
					"                        \"address1\": \"3401 Civic Center Blvd\",\r\n" + 
					"                        \"address2\": \"\",\r\n" + 
					"                        \"city\": \"Philadelphia\",\r\n" + 
					"                        \"state\": \"PA\",\r\n" + 
					"                        \"zipCode\": \"19104\",\r\n" + 
					"                        \"countryCode\": \"US\",\r\n" + 
					"                        \"isConfidential\": false,\r\n" + 
					"                        \"estimatedActivityDueDateTime\": \"2017-08-01 11:30:00\"\r\n" + 
					"                    }\r\n" + 
					"                ],\r\n" + 
					"                \"driver\": [\r\n" + 
					"                    {\r\n" + 
					"                        \"driverId\": \""+Secondary_Driver+"\",\r\n" + 
					"                        \"driverName\": \""+Secondary_Driver+ "\",\r\n" + 
					"                        \"isPrimary\": false\r\n" + 
					"                    },\r\n" + 
					"                    {\r\n" + 
					"                        \"driverId\": \""+Primary_Driver+"\",\r\n" + 
					"                        \"driverName\": \""+Primary_Driver+"\",\r\n" + 
					"                        \"isPrimary\": true\r\n" + 
					"                    }\r\n" + 
					"                ],\r\n" + 
					"                \"activityInstructions\": [\r\n" + 
					"                    {\r\n" + 
					"                        \"noteType\": \"10\",\r\n" + 
					"                        \"instruction\": \"Please provide a nice selfie and autographs\"\r\n" + 
					"                    }\r\n" + 
					"                ]\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"    },\r\n" + 
					"    \"integration\": {\r\n" + 
					"        \"sourceSystem\": \"WS\",\r\n" + 
					"        \"sourceEchoFields\": [\r\n" + 
					"            {\r\n" + 
					"                \"key\": \"site\",\r\n" + 
					"                \"value\": \"PHL\"\r\n" + 
					"            },\r\n" + 
					"            {\r\n" + 
					"                \"key\": \"integid\",\r\n" + 
					"                \"value\": \"PHL20170512175416711\"\r\n" + 
					"            }\r\n" + 
					"        ]\r\n" + 
					"    }\r\n" + 
					"}";

	
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("This is the responsecode  : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			
			//print result
			
			System.out.println("The response to string is"+response.toString());
			
			Gson gson = new Gson();
			gson.toJson(response);
			
			
			String myJSONString=response.toString();
			JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
			int result = jobj.get("status").getAsInt();
			System.out.println("Value of status is "+result);
			
			if(responseCode==200 && result==1 )
			{
				System.out.print("The request was sent successfully");
				System.out.print(timeStamp);
			}
			

			Thread.sleep(10000);
			
	     
}


	

}
