import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import org.json.*;


//This class contains the main method which reads in data from the 
public class DataParser {
	private static DataTransformer Optimus;
	
	public static void main(String[] args) throws AWTException, JSONException{
		ServerSocket myService = null;
		Socket phoneSocket = null;
		BufferedReader phoneData = null;
		try{
			myService = new ServerSocket(2000);
			phoneSocket = myService.accept();
			phoneData = new BufferedReader(new InputStreamReader(phoneSocket.getInputStream()));
		}
			
		catch (IOException e){
			System.out.println(e);
		}
		
		Optimus = new DataTransformer();
		
		while(true){
			String line = null;
			JSONObject input = null;
			try {
				line = phoneData.readLine();
				input = new JSONObject(line);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int vectorType = input.getInt("type");
			if(vectorType == 0){
				Optimus.setRotation(input.getJSONArray("data"));
			}
			
			
			
			
		 
			
			
			
			
			
			
			
		}
		
	
		
	}

		
		
		
		
		
	}


