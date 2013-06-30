package org.oregami.data.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.oregami.data.GameDao;
import org.oregami.dropwizard.OregamiGuiceInjector;
import org.oregami.entities.Game;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.Transactional;

public class JpaTest {

	private static Injector injector;

	@BeforeClass
	public static void initGlobal() {
		injector = OregamiGuiceInjector.get();
		PersistService persistService = injector.getInstance(PersistService.class);
		persistService.start();
	}

	@Inject
	private GameDao gameRepository;

	@Before
	public void before() {
		injector.injectMembers(this);
		gameRepository.getEntityManager().getTransaction().begin();
	}
	
	@After
	public void after() {
		gameRepository.getEntityManager().getTransaction().commit();
	}
	
	
	@Test
	@Transactional
	public void test() {
		Game game = null;
		game = gameRepository.findOne(1L);
		if (game==null) {
			game = new org.oregami.entities.Game();
			game.setTagLineDescription("Monkey Island");
			gameRepository.save(game);
		}
		game.setTagLineDescription(game.getTagLineDescription() + " rnd" + Math.random());
		gameRepository.update(game);
		
		Game loadedGame = gameRepository.findOne(1L);
		Assert.assertNotNull(loadedGame);
		Assert.assertTrue(loadedGame.getTagLineDescription().startsWith("Monkey Island"));
	}
	
}
