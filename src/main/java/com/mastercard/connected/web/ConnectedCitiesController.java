package com.mastercard.connected.web;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.connectedcities.service.GraphService;

@RestController
public class ConnectedCitiesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectedCitiesController.class);

	@RequestMapping("/connected")
	public ResponseEntity<String> greeting(@RequestParam(value = "origin") String origin,
			@RequestParam(value = "destination") String destination) {

		GraphService service = new GraphService();

		String response = "no";
		try {
			response = service.doWork(origin, destination);
			LOGGER.info("response={}", response);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}