package APITesting.restassured;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class ReusableMethods {
	
	Properties prop=new Properties();
	
	public  void readpropertyfile() throws Exception
	{
			FileInputStream fis=new FileInputStream("C:\\APITesting\\restassured\\src\\test\\java\\APITesting\\restassured\\Reusable.properties");
			prop.load(fis);
	}
	
	public static String GenerateStringFRomResource(String Path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(Path)));
	}
	
	public static JsonPath rawtoJSON(Response res)
	{
		String x=res.asString();
		JsonPath json=new JsonPath(x);
		return json;
	}
}
