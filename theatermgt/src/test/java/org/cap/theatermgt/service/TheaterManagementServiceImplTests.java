package org.cap.theatermgt.service;

import org.junit.jupiter.api.function.Executable;

import javax.persistence.EntityManager;

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
	
	@Test
	public void testFindByTheaterId() {
		Executable executable = new Executable() {
			
			@Override
			public void execute() throws Throwable {
				theaterService.fetchById(111);				
			}
		};
		Assertions.assertThrows(TheaterNotFoundException.class, executable);
	}
	
}