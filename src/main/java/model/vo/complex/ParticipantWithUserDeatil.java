package model.vo.complex;

import model.vo.Participant;
import model.vo.User;

public class ParticipantWithUserDeatil {
	Participant participant;
	User user;

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
