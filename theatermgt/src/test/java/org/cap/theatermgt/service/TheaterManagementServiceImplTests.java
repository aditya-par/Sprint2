package org.cap.theatermgt.service;

import java.util.*;

import javax.persistence.EntityManager;
import org.cap.theatermgt.entities.Theater;
import org.cap.theatermgt.exception.TheaterNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
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
	
	 @Test
	 public void testSaveTheater_1() {
		 Theater theater = new Theater();
		 theater.setTheaterName("PVR");
	     theater.setTheaterCity("New Delhi");
		 List<Integer> movieList = new ArrayList<Integer>();
		 movieList.add(101);
		 movieList.add(102);
		 theater.setMovieList(movieList);
		 theater.setManagerName("Aditya Parashari");
		 theater.setManagerContact("6325473687");
		 Theater result = theaterService.save(theater);
		 List<Theater> fetched = entityManager.createQuery("from Theater").getResultList();
		 Theater expected = fetched.get(0);
		 Assertions.assertEquals(expected, result);
	 }
	
	@Test
	public void fetchTheater_1() {
		Executable executable = () -> theaterService.fetchById(12);
		Assertions.assertThrows(TheaterNotFoundException.class, executable);
	}

	
	@Test
	public void fetchTheater_2() {
		Theater theater = new Theater();
		theater.setTheaterName("PVR");
		theater.setTheaterCity("New Delhi");
		List<Integer> movieList = new ArrayList<Integer>();
		movieList.add(101);
		movieList.add(102);
		theater.setMovieList(movieList);
		theater.setScreenList(null);
		theater.setManagerName("Aditya Parashari");
		theater.setManagerContact("6325473687");
		theater = entityManager.merge(theater);
		int theaterId = theater.getTheaterId();	
		Theater result = theaterService.fetchById(theaterId);
		Assertions.assertEquals(theater, result);
	}

	
	@Test
	public void deleteTheater_1() {
		Executable executable = () -> theaterService.delete(12);
		Assertions.assertThrows(TheaterNotFoundException.class, executable);
	}
	
	@Test
	public void deleteTheater_2() {
		Theater theater = new Theater();
		theater.setTheaterName("PVR");
		theater.setTheaterCity("New Delhi");
		List<Integer> movieList = new ArrayList<Integer>();
		movieList.add(101);
		movieList.add(102);
		theater.setMovieList(movieList);
		theater.setScreenList(null);
		theater.setManagerName("Aditya Parashari");
		theater.setManagerContact("6325473687");
		theater = entityManager.merge(theater);
		int theaterId = theater.getTheaterId();
		Boolean result = theaterService.delete(theaterId);
		Boolean expected = true;
		Assertions.assertEquals(result, expected);
	}

}
