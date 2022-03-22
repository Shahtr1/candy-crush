package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.App;
import com.example.demo.entity.Developer;
import com.example.demo.entity.Genre;
import com.example.demo.repository.AppRepository;
import com.example.demo.repository.DeveloperRepository;
import com.example.demo.repository.GenreRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
public class DataController {
	
	@Autowired
	AppRepository appRepository;
	

	@Autowired
	DeveloperRepository developerRepository;
	

	@Autowired
	GenreRepository genreRepository;
	
	
	@GetMapping("/apps/{id}")
	public String index(@PathVariable("id") int id, Model model) {
		
		App app = appRepository.getById(new Long(id));
				
		model.addAttribute("app",app);
		return "hello";
	}
		
	public void processApiData() {
		String uri = "https://storeapi.acmo.in/appstore.php?package=553834731";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			
			App app = new App(node.get("id").asLong(),node.get("appId").textValue(),
					node.get("title").textValue(),node.get("url").textValue(),
					node.get("description").textValue(),
					node.get("icon").textValue(),node.get("contentRating").textValue(),
					node.get("size").textValue(),
					node.get("version").textValue(),node.get("free").asBoolean());
			
			
			
			appRepository.save(app);
			
			Genre appGenre = genreRepository.getById(node.get("primaryGenreId").asLong());
			
			
			
			Developer developer = new Developer(node.get("developerId").asLong(),
					node.get("developer").textValue(), 
					node.get("developerUrl").textValue(),
					node.get("developerWebsite").textValue());

			developerRepository.save(developer);
			
			List<Genre> genres = new ArrayList<>();
			Iterator<JsonNode> itr = node.get("genreIds").iterator();
						
			for (final JsonNode objNode : node.get("genres")) {
				Genre genre = new Genre(itr.next().asLong(),objNode.textValue() );
		        genres.add(genre);
		    }
			
			for(Genre genre: genres) {
				genreRepository.save(genre);
			}
			
			
			Developer appDeveloper = developerRepository.getById(node.get("developerId").asLong());
			
			app.setDeveloper(appDeveloper);
			
			app.setGenre(appGenre);
			
			appRepository.save(app);
			
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	

	
	
}
