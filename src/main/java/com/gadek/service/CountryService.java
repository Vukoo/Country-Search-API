package com.gadek.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.gadek.model.Country;

@Service
public class CountryService implements ICountryService {
	
		public static String url="https://restcountries.eu/rest/v2/name/";
  		JSONObject jsonObject = new JSONObject();
  		JSONObject jsonCurrObj = new JSONObject();
  		Set<Country> allCountry = new HashSet<> ();
	
	  
	  	@Override
		  public JSONArray  readJsonFromUrl(String search) throws IOException, JSONException {
	  		String newUrl = url + search; 
		    InputStream is = new URL(newUrl).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray jsonArray = new JSONArray(jsonText);
		      return jsonArray;
		    } finally {
		      is.close();
		    }
		  }
	  	
	  	@Override
	  	public Set<Country> listAll(JSONArray jsonArray){
	  		allCountry.clear();
	  		for (int i = 0; i < jsonArray.length(); i++)
	  		{
	  			Country country = new Country();
	  			jsonObject = (JSONObject) jsonArray.get(i); 
	  		    jsonCurrObj = (JSONObject) jsonObject.getJSONArray("currencies").getJSONObject(0);

	  		 country.setCapital(jsonObject.getString("capital"));
	  		 country.setFlag(jsonObject.getString("flag"));
	  		 country.setCurrency(jsonCurrObj.getString("name"));
	  		 country.setCountry(jsonObject.getString("name"));
	  		 allCountry.add(country);
	  		}
	  		return allCountry;
	  	}
	  	
	  	 private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }
	  	
}
