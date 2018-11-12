package APITesting.restassured;

public class Resources {
	
	public static String postRes()
	{
		String a="/maps/api/place/add/json";
		return a;
	}
	
	public static String deleteRes()
	{
		String b="/maps/api/place/delete/json";
		return b;
	}

}
