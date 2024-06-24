package model.vo.complex;

import model.vo.Event;
import model.vo.Gym;

public class EventWithDetail {
	Event event;
	Gym gym;
	boolean joined;
	double dday;	
	
	
	
	public double getDday() {
		return dday;
	}

	public void setDday(double dday) {
		this.dday = dday;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}


}
