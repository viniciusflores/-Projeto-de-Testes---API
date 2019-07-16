package core;

import io.restassured.http.ContentType;

public interface Constants {
	String APP_BASE_URL = "https://gateway.marvel.com";
	Integer APP_PORT = 443;
	String APP_BASE_PATH = "/v1/public";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L;
}
