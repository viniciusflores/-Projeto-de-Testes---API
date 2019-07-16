package core;

import io.restassured.http.ContentType;

public interface Constants {
	String APP_BASE_URL = "";
	Integer APP_PORT = 0;
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L;
}
