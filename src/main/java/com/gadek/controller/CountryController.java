package com.gadek.controller;


import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.gadek.model.Country;
import com.gadek.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CountryController {
	
		@Autowired
		CountryService countryService;
		
	  	@GetMapping(value = "/home")//, produces = "application/json")
		//@ResponseBody
	    public String home(Model model) {
		  return "home";
	    }

	  //	@ResponseBody
	  //	@Produces(MediaType.APPLICATION_JSON)
	  	@PostMapping(value = "/home/{search}")
	  	public String countryList(@PathVariable String search, Model model ) throws JSONException, IOException {

	  		    JSONArray jsonArray = countryService.readJsonFromUrl(search);
	  		    Set<Country> allCountry = countryService.listAll(jsonArray);
	 	        model.addAttribute("allCountry", allCountry);
	 	  		return "home"; 
	 	  		}
}
