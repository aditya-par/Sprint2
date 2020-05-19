package org.cap.theatermgt.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.cap.theatermgt.entities.Screen;
import org.cap.theatermgt.exception.ScreenNotFoundException;
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
public class ScreenManagementTests {
	
	@Autowired
	private IScreenService service;
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * case when screen exists , verifying screen is correctly fetched
	 * precondition : screen exists in database
	 */
	@Test
	public void testFindByTheaterId_1() {
			int screenId = 101;
			String screenName = "HD";
			int theaterId = 12;
			List<Integer> showList = new ArrayList<>();
			showList.add(101);
			showList.add(102);
			int rows = 22;
			int columns = 12;
			Screen screen = new Screen();
			screen.setScreenId(screenId);
			screen.setTheaterId(theaterId);
			screen.setShowList(showList);
			screen.setRows(rows);
			screen.setColumns(columns);
			screen = entityManager.merge(screen);
			int sId = screen.getScreenId();
			Screen result = service.fetchScreenById(sId);
			
			Assertions.assertEquals(screen, result);
			Assertions.assertEquals(screenName, screen.getScreenName());
			Assertions.assertEquals(theaterId, screen.getTheaterId());
			Assertions.assertEquals(showList, screen.getShowList());
			Assertions.assertEquals(rows, screen.getRows());
			Assertions.assertEquals(columns, screen.getColumns());
		}
	
	/**
	 * case when screen doesn't exist, verifying ScreenNotFound exception is thrown
	 */
	@Test
	public void testFindByTheaterId_2(){
		int id = 101;
		Executable executable = () -> service.fetchScreenById(id); 
		Assertions.assertThrows(ScreenNotFoundException.class, executable);
	}
	
	public Screen addScreen() {
		Screen screen = new Screen();
		screen.setScreenId(222);
		screen.setTheaterId(12);
		List<Integer> showList = new ArrayList<>();
		showList.add(101);
		showList.add(102);
		screen.setShowList(showList);
		screen.setRows(22);
		screen.setColumns(12);
		return screen;
	}
	
	/**
	 * case when screen doesn't exist while deleting, verifying ScreenNotFoundException exception is thrown
	 */
	@Test
	public void deleteScreen_1() {
		Executable executable = () -> service.delete(12);
		Assertions.assertThrows(ScreenNotFoundException.class, executable);
	}
	
	/**
	 * case when screen exists , verifying screen is correctly deleted
	 * precondition : screen exists in database
	 */
	@Test
	public void deleteTheater_2() {
		Screen screen = addScreen();
		Boolean result = service.delete(screen.getScreenId());
		Boolean expected=true;
		Assertions.assertEquals(result, expected);
	}

}
