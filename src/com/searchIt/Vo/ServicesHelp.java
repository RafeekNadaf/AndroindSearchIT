package com.searchIt.Vo;

import java.util.ArrayList;
import java.util.List;

public class ServicesHelp {
	
	private List<Services> service_provides;
	private List<States>  states;
	private ArrayList<Districts> districs;

	public List<Services> getService_provides() {
		return service_provides;
	}

	public void setService_provides(List<Services> service_provides) {
		this.service_provides = service_provides;
	}

	public ArrayList<Districts> getDistrics() {
		return districs;
	}

	public void setDistrics(ArrayList<Districts> districs) {
		this.districs = districs;
	}

	public List<States> getStates() {
		return states;
	}

	public void setStates(List<States> states) {
		this.states = states;
	}

	
	

}
