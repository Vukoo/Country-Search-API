package com.gadek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.gadek.model.Country;

public class JsonRead {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
  public static JSONArray  readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONArray jsonArray = new JSONArray(jsonText);
      return jsonArray;
    } finally {
      is.close();
    }
  }
  
  public static void main(String[] args) throws IOException, JSONException {
	  
    JSONArray jsonArray = readJsonFromUrl("https://restcountries.eu/rest/v2/name/po");
    JSONObject jsonObject = new JSONObject();
    JSONObject jsonCurrObj = new JSONObject();

for (int i = 0; i < jsonArray.length(); i++)
{
	jsonObject = (JSONObject) jsonArray.get(i); 
    jsonCurrObj = (JSONObject) jsonObject.getJSONArray("currencies").getJSONObject(0);

    System.out.println("Country: " + jsonObject.getString("name"));
    System.out.println("Capital city:" + jsonObject.getString("capital"));
    System.out.println("Flag: " + jsonObject.getString("flag"));
    System.out.println("Currency name: " + jsonCurrObj.getString("name") );
    System.out.println("--------------------");
 Country firstcountry = new Country();
 firstcountry.setCapital(jsonObject.getString("capital"));
 firstcountry.setFlag(jsonObject.getString("flag"));
 firstcountry.setCurrency(jsonCurrObj.getString("currency"));
 firstcountry.setCountry(jsonObject.getString("name"));
 
}
  }
}