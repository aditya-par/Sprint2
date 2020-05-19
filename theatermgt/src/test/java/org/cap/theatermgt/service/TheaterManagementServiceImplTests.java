package org.cap.theatermgt.service;

import org.junit.jupiter.api.function.Executable;


import java.util.*;

import javax.persistence.EntityManager;

import org.cap.theatermgt.entities.Screen;
import org.cap.theatermgt.entities.Theater;
import org.cap.theatermgt.exception.TheaterNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(TheaterServiceImpl.class)
public class TheaterManagementServiceImplTests {

	@Autowired
	private ITheaterService theaterService;
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * case when theater exists , verifying theater is correctly fetched
	 * precondition : theater exists in database
	 */
	@Test
	public void testFindByTheaterId_1() {
			int theaterId = 101;
			String theaterName = "PVR";
			String theaterCity = "New Delhi";
			List<Integer> movieList = null;
			List<Screen> screenList = null;
			String managerName = "Aditya";
			String managerContact ="345675869";
			Theater theater = new Theater();
			theater.setTheaterId(theaterId);
			theater.setTheaterName(theaterName);
			theater.setTheaterCity(theaterCity);
			theater.setMovieList(movieList);
			theater.setScreenList(screenList);
			theater.setManagerName(managerName);
			theater.setManagerContact(managerContact);
			
			theater = entityManager.merge(theater);
			int tId = theater.getTheaterId();
			Theater result = theaterService.fetchById(tId);
			
			Assertions.assertEquals(theater, result);
			Assertions.assertEquals(theaterName, theater.getTheaterName());
			Assertions.assertEquals(theaterCity, theater.getTheaterCity());
			Assertions.assertEquals(movieList, theater.getMovieList());
			Assertions.assertEquals(screenList, theater.getScreenList());
			Assertions.assertEquals(managerName, theater.getManagerName());
			Assertions.assertEquals(managerContact, theater.getManagerContact());
			
		}

		/**
		 * case when theater doesn't exist, verifying TheaterNotFound exception is thrown
		 */
		@Test
		public void testFindByTheaterId_2(){
			int id = 101;
			Executable executable = () -> theaterService.fetchById(id); 
			Assertions.assertThrows(TheaterNotFoundException.class, executable);
		}
		
		@Test
		public Theater addTheater() {
			Theater theater = new Theater();
			theater.setTheaterId(12);
			theater.setTheaterName("Cinepolis");
			List<Integer> movieList = new ArrayList<>();
			movieList.add(101);
			movieList.add(102);
			theater.setScreenList(addScreen());
			theater.setManagerName("Aditya Parashrai");
			theater.setManagerContact("837657890");
			theater = entityManager.merge(theater);
			return theater;
		}
		
		public List<Screen> addScreen() {
			List<Screen> screenList = new ArrayList<>();
			Screen screen = new Screen();
			screen.setScreenId(222);
			screen.setTheaterId(12);
			List<Integer> showList = new ArrayList<>();
			showList.add(101);
			showList.add(102);
			screen.setShowList(showList);
			screen.setRows(22);
			screen.setColumns(12);
			screenList.add(screen);
			return screenList;
		}
		
		/**
		 * case when theater doesn't exist while deleting, verifying TheaterNotFound exception is thrown
		 */
		@Test
		public void deleteTheater_1() {
			Executable executable = () -> theaterService.delete(12);
			Assertions.assertThrows(TheaterNotFoundException.class, executable);
		}
		
		/**
		 * case when theater exists , verifying theater is correctly deleted
		 * precondition : theater exists in database
		 */
		@Test
		public void deleteTheater_2() {
			Theater theater = addTheater();
			Boolean result = theaterService.delete(theater.getTheaterId());
			Boolean expected=true;
			Assertions.assertEquals(result, expected);
		}
		
}
