package org.oregami.data.test;

import java.util.List;

import model.ArchivArea;
import model.ArchivHeft;
import model.ArchivPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.oregami.data.ArchivAreaDao;
import org.oregami.data.ArchivHeftDao;
import org.oregami.data.ArchivPageDao;
import org.oregami.dropwizard.KultpowerGuiceInjector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.Transactional;

public class JpaTest {

	private static Injector injector;

	@BeforeClass
	public static void initGlobal() {
		injector = KultpowerGuiceInjector.get();
		PersistService persistService = injector.getInstance(PersistService.class);
		persistService.start();
	}

	@Inject
	private ArchivHeftDao heftRepository;

	@Inject
	private ArchivAreaDao areaRepository;	

	@Inject
	private ArchivPageDao pageRepository;	
	
	@Before
	public void before() {
		injector.injectMembers(this);
		heftRepository.getEntityManager().getTransaction().begin();
	}
	
	@After
	public void after() {
		heftRepository.getEntityManager().getTransaction().commit();
	}
	
	
	@Test
	@Transactional
	public void test() {
		ArchivHeft heft = null;
		heft = heftRepository.findOne(6);
		
		Assert.assertNotNull(heft);
		Assert.assertTrue(heft.getPath().startsWith("powerplay"));
	}
	
	
	@Test
	@Transactional
	public void testHeftDao() {
		String path = "powerplay_1990-01";
		ArchivHeft heft = heftRepository.findByPath(path);
		Assert.assertNotNull(heft);
		System.out.println("Found heft id=" + heft.getId() + " / " + heft.getName() + " for " + path);
	}
	
	@Test
	@Transactional
	public void testAreaDao() {
		String path = "powerplay_1990-01";
		List<ArchivArea> list = areaRepository.findByHeftPath(path);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		System.out.println("Found " + list.size() + " areas for " + path);
	}	
	
	@Test
	@Transactional
	public void testPageDao() {
		String path = "powerplay_1989-08";
		List<ArchivPage> list = pageRepository.findByHeftPath(path);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		System.out.println("Found " + list.size() + " pages for " + path);
	}		
	
}
