package org.cap.theatermgt.controller;

import java.util.*;


import org.cap.theatermgt.dto.CreateTheaterRequest;
import org.cap.theatermgt.dto.TheaterDetailsDto;
import org.cap.theatermgt.entities.Theater;
import org.cap.theatermgt.exception.TheaterNotFoundException;
import org.cap.theatermgt.service.ITheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

	private static final Logger Log = LoggerFactory.getLogger(TheaterController.class);

	@Autowired
	private ITheaterService service;

	/**
	 * Adding theater
	 * @param thaeterDto
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<TheaterDetailsDto> addTheater(@RequestBody CreateTheaterRequest theaterDto) {
		Theater theater = convert(theaterDto);
		theater = service.save(theater);
		TheaterDetailsDto detailsDto = convertTheaterDetails(theater);
		ResponseEntity<TheaterDetailsDto> response = new ResponseEntity<TheaterDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	/**
	 * Fetching all theaters
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Theater>> fetchAll() {
		List<Theater> theaters = service.fetchAll();
		ResponseEntity<List<Theater>> response = new ResponseEntity<>(theaters, HttpStatus.OK);
		return response;
	}

	/**
	 * Fetching theater by theater id
	 * @param theaterId
	 * @return
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<TheaterDetailsDto> fetchById(@PathVariable("id") int theaterId) {
		Theater theater = service.fetchById(theaterId);
		TheaterDetailsDto detailsDto = convertTheaterDetails(theater);
		ResponseEntity<TheaterDetailsDto> response = new ResponseEntity<TheaterDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	/**
	 * Deleting theater by theater id
	 * @param theaterId
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTheater(@PathVariable("id") int theaterId) {
		Boolean result = service.delete(theaterId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}

	/**
	 * convert from theater: dto -> entity
	 * @param theaterDto
	 * @return
	 */
	public Theater convert(CreateTheaterRequest theaterdto) {
		Theater theater = new Theater();
		theater.setTheaterId(theaterdto.getTheaterId());
		theater.setTheaterName(theaterdto.getTheaterName());
		theater.setTheaterCity(theaterdto.getTheaterCity());
		theater.setManagerName(theaterdto.getManagerName());
		theater.setManagerContact(theaterdto.getManagerContact());
		theater.setMovieList(addMovie());
		return theater;
	}
	
	/**
	 * convert from theater: entity -> detailsdto
	 * @param app
	 * @return
	 */
	public TheaterDetailsDto convertTheaterDetails(Theater theater) {
		TheaterDetailsDto detailsDto = new TheaterDetailsDto();
		detailsDto.setTheaterId(theater.getTheaterId());
		detailsDto.setTheaterName(theater.getTheaterName());
		detailsDto.setTheaterCity(theater.getTheaterCity());
		detailsDto.setScreenList(theater.getScreenList());
		detailsDto.setMovieList(addMovie());
		detailsDto.setManagerName(theater.getManagerName());
		detailsDto.setManagerContact(theater.getManagerContact());
		return detailsDto;
	}
	
	public List<Integer> addMovie()
	{
		List<Integer> movieList = new ArrayList<Integer>();
		movieList.add(101);
		movieList.add(102);
		return movieList;
	}

	@ExceptionHandler(TheaterNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(TheaterNotFoundException ex) {
		Log.error("handleTheaterNotFound()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("handleAll()", ex);// this will get logged
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}
