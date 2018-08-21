package com.sap.config;

import org.springframework.context.annotation.Profile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Profile("cloud")
public class DataSourceConfiguration {

	@Bean
	public javax.sql.DataSource dataSource() {
	    @SuppressWarnings("rawtypes")
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	    JSONObject obj = new JSONObject(System.getenv("VCAP_SERVICES"));
	    JSONArray arr = obj.getJSONArray("hana");
	    String schema = arr.getJSONObject(0).getJSONObject("credentials").getString("schema");
	    String host = arr.getJSONObject(0).getJSONObject("credentials").getString("host");
	    String port = arr.getJSONObject(0).getJSONObject("credentials").getString("port");
	    String username = arr.getJSONObject(0).getJSONObject("credentials").getString("user");
	    String password = arr.getJSONObject(0).getJSONObject("credentials").getString("password");
	    String connection_url = "jdbc:sap://" + host + ":" + port + "/?currentschema=" + schema; 
	        dataSourceBuilder.url(connection_url);
	        dataSourceBuilder.username(username);
	        dataSourceBuilder.password(password);
	        return dataSourceBuilder.build();   
	}

}