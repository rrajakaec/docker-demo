package com.example.dockerdemo.api;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {
	
	@Value("${bonita.env}")
	private String bonita;
	
	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("Welcome to My App == env ==> " + bonita, OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<String>> getAllUsers() {
		final List<String> users = asList("Alan", "Jeroen", "Jose");
		return new ResponseEntity<>(users, OK);
	}

}
