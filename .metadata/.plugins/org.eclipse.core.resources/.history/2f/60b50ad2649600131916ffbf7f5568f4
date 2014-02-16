package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import main.PhoneRemote;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhoneSocketServer {
	public PhoneSocketServer(PhoneRemote controller) {
		ServerSocket myService = null;
		Socket phoneSocket = null;
		BufferedReader phoneData = null;
		try {
			myService = new ServerSocket(3000);
			phoneSocket = myService.accept();
			phoneData = new BufferedReader(new InputStreamReader(
					phoneSocket.getInputStream()));

			while (true) {
				String line = null;
				JSONObject input = null;

				line = phoneData.readLine();
				input = new JSONObject(line);

				int vectorType = input.getInt("type");
				
				if (vectorType == 0) {
					JSONArray array = input.getJSONArray("data");
					double[] vals = new double[3];
					for (int i = 0; i < 3; i++)
						vals[i] = array.getDouble(i);
					controller.updateOrientation(vals);
				}
				else if (vectorType == 1) {
					JSONArray array = input.getJSONArray("data");
					double[] vals = new double[3];
					for (int i = 0; i < 3; i++)
						vals[i] = array.getDouble(i);
					controller.updateAcceleration(vals);
				}
				else if (vectorType == 2) {
					controller.calibrate();
				}
					
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
