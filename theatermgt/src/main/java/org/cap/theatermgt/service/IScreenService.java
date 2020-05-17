package org.cap.theatermgt.service;

import org.cap.theatermgt.entities.Screen;
import java.util.*;

public interface IScreenService {

	Screen save(Screen screen);
	
	Screen addScreen(Screen screen, int theaterId);
	
	List<Screen> fetchAll();
	
	Screen fetchScreenById(int screenId);
	
	Boolean delete(int screenId);
}
