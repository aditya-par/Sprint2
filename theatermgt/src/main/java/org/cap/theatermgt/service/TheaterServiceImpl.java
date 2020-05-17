package org.cap.theatermgt.service;

import java.util.List;




import java.util.Optional;

import javax.transaction.Transactional;
import org.cap.theatermgt.service.IScreenService;
import org.cap.theatermgt.dao.TheaterDao;
import org.cap.theatermgt.entities.Screen;
import org.cap.theatermgt.entities.Theater;
import org.cap.theatermgt.exception.TheaterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TheaterServiceImpl implements ITheaterService {

	@Autowired
	private TheaterDao dao;
	
	@Autowired
	private IScreenService service;
	
	@Override
	public Theater save(Theater t) {
		Theater theater = dao.save(t);
		return theater;
	}

	@Override
	public List<Theater> fetchAll() {
		List<Theater> theaters = dao.findAll();
		return theaters;
	}

	@Override
	public Theater fetchById(int theaterId) {
		Optional<Theater> optional = dao.findById(theaterId);
				if(optional.isPresent()) {
					Theater th = optional.get();
					return th;
					}
		throw new TheaterNotFoundException("theater not found for id="+theaterId);
	}

	@Override
	public Boolean delete(int theaterId) {
		Theater theater = fetchById(theaterId);
	    List<Screen> screenList = theater.getScreenList();
	    for (Screen screen : screenList) {
			int screenId = screen.getScreenId();
			service.delete(screenId);
		}
	    dao.delete(theater);
		return true;
	}

	/*
	 * @Override public Screen addScreen(Screen screen) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
