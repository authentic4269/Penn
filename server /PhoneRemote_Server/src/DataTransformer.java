import java.awt.*;
import org.json.*;

//An instance uses relevant sensor data to update the mouse's position on the screen
public class DataTransformer {
	private Robot R2;
	private JSONArray rotation;
	private JSONArray acceleration;
	
	public DataTransformer() throws AWTException{
		R2= new Robot();
		setRotation(new JSONArray());
		setAcceleration(new JSONArray());
		}
	
	public void refresh(){
		
	}

	public JSONArray getRotation() {
		return rotation;
	}

	public void setRotation(JSONArray rotation) {
		this.rotation = rotation;
	}

	public JSONArray getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(JSONArray acceleration) {
		this.acceleration = acceleration;
	}
}
