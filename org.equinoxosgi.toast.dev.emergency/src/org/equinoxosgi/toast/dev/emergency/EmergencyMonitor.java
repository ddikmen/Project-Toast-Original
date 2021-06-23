package org.equinoxosgi.toast.dev.emergency;

import org.equinoxosgi.toast.dev.airbag.Airbag;
import org.equinoxosgi.toast.dev.airbag.IAirbagListener;
import org.equinoxosgi.toast.dev.gps.Gps;

public class EmergencyMonitor implements IAirbagListener {
	
	private Airbag airbag;
	private Gps gps;

	@Override
	public void deployed() {
		// TODO Auto-generated method stub
		System.out.println("Emergency occured at lat=" + gps.getLatitude() +
				" lon=" + gps.getLongitude() +
				" heading="+ gps.getHeading() +
				" speed=" + gps.getSpeed());
	}
	
	public void setAirbag(Airbag value) {
		airbag = value;
	}
	
	public void setGps(Gps value) {
		gps = value;
	}
	
	public void shutdown() {
		airbag.removeListener(this);
	}
	
	public void startup() {
		airbag.addListener(this);
	}

}
