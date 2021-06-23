package org.equinoxosgi.toast.dev.emergency;

import org.equinoxosgi.toast.dev.airbag.Airbag;
import org.equinoxosgi.toast.dev.gps.Gps;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(immediate = true) 
public class EmergencyService {
	
	private Gps gps;
	private Airbag airbag;
	private EmergencyMonitor monitor;
	
	@Activate
	void activate() {
		System.out.println("Launching");
		gps = new Gps();
		airbag = new Airbag();
		monitor = new EmergencyMonitor();
		monitor.setGps(gps);
		monitor.setAirbag(airbag);
		monitor.startup();
		airbag.deploy();
	}
	
	@Deactivate
	void deactivate() {
		monitor.shutdown();
		System.out.println("Terminating");
	}
}
