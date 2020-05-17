package org.cap.theatermgt.controller;

import java.util.*;

import org.cap.theatermgt.dto.CreateScreenRequest;
import org.cap.theatermgt.dto.ScreenDetailsDto;
import org.cap.theatermgt.entities.Screen;
import org.cap.theatermgt.exception.ScreenNotFoundException;
import org.cap.theatermgt.service.IScreenService;
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
@RequestMapping("/screens")
public class ScreenController {
	
	private static final Logger Log = LoggerFactory.getLogger(ScreenController.class);
	
	@Autowired
	private IScreenService screenService;
	
	
	@PostMapping("/add")
	public ResponseEntity<ScreenDetailsDto> addScreen(@RequestBody CreateScreenRequest screenDto){
		Screen screen = convertScreen(screenDto);
		Screen newScreen = screenService.addScreen(screen, screen.getTheaterId());
		ScreenDetailsDto detailsDto = convertScreenDetails(newScreen);
		ResponseEntity<ScreenDetailsDto> response = new ResponseEntity<ScreenDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	@GetMapping
	public ResponseEntity<List<Screen>> fetchAll()
	{
		List<Screen> screenList = screenService.fetchAll();
		ResponseEntity<List<Screen>> response = new ResponseEntity<List<Screen>>(screenList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ScreenDetailsDto> fetchScreens(@PathVariable("id") int screenId) {
		Screen screen = screenService.fetchScreenById(screenId);
		ScreenDetailsDto detailsDto = convertScreenDetails(screen);
		ResponseEntity<ScreenDetailsDto> response = new ResponseEntity<ScreenDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteScreen(@PathVariable("id") int screenId){
		Boolean result = screenService.delete(screenId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}
	
	public Screen convertScreen(CreateScreenRequest screenDto)
	{
		Screen screen = new Screen();
		screen.setColumns(screenDto.getColumns());
		screen.setRows(screenDto.getRows());
		screen.setScreenName(screenDto.getScreenName());
		screen.setTheaterId(screenDto.getTheaterId());
		return screen;
	}
	
	public ScreenDetailsDto convertScreenDetails(Screen screen) {
		ScreenDetailsDto detailsDto = new ScreenDetailsDto();
		detailsDto.setScreenId(screen.getScreenId());
		detailsDto.setTheaterId(screen.getTheaterId());
		detailsDto.setScreenName(screen.getScreenName());
		detailsDto.setRows(screen.getRows());
		detailsDto.setColumns(screen.getColumns());
		detailsDto.setShowList(addShow());
		return detailsDto;
	}
	
	private List<Integer> addShow(){
		List<Integer> showList = new ArrayList<Integer>();
		showList.add(101);
		showList.add(102);
		return showList;
	}
	
	@ExceptionHandler(ScreenNotFoundException.class)
	private ResponseEntity<String> handleTheaterNotFound(ScreenNotFoundException ex){
		Log.error("handleScreenNotFound()",ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatus.OK);
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
