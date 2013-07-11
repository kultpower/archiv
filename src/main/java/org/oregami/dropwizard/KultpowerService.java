package org.oregami.dropwizard;

import org.oregami.resources.HefteResource;

import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class KultpowerService extends Service<KultpowerConfiguration> {

	private GuiceBundle<KultpowerConfiguration> guiceBundle;
	
	public static void main(String[] args) throws Exception {
		new KultpowerService().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<KultpowerConfiguration> bootstrap) {
		bootstrap.setName("hello-world");
		bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
		
		guiceBundle = GuiceBundle.<KultpowerConfiguration>newBuilder()
				.addModule(new KultpowerGuiceModule())
				.addModule(new JpaPersistModule("data"))
				.enableAutoConfig("org.oregami")
				.setConfigClass(KultpowerConfiguration.class)
				.build();
		bootstrap.addBundle(guiceBundle);
				
	}

	
	@Override
	public void run(KultpowerConfiguration config, Environment environment)
			throws Exception {
		
		PersistService persistService = guiceBundle.getInjector().getInstance(PersistService.class);
		persistService.start();
		
		environment.addResource(guiceBundle.getInjector().getInstance(HefteResource.class));
	}



}
