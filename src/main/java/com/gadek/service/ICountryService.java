package com.gadek.service;

import java.io.IOException;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.gadek.model.Country;

@Service
public interface ICountryService {
	JSONArray readJsonFromUrl(String search) throws IOException, JSONException;
	Set<Country> listAll(JSONArray jsonArray);
}
