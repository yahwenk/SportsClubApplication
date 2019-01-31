package nus.iss.team2.controller;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import nus.iss.team2.model.Booking;
import nus.iss.team2.model.Facility;
import nus.iss.team2.model.User;


@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	private String sessionId = null;
	private User user = null;
	private Facility fac = null;
	private Booking trans = null;
	private Date bDate = null;
	
	
	
	
	public Facility getFac() {
		return fac;
	}

	public void setFac(Facility fac) {
		this.fac = fac;
	}

	public Booking getTrans() {
		return trans;
	}

	public void setTrans(Booking trans) {
		this.trans = trans;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	
	
	public UserSession() {
		
	}

	public UserSession(String sessionId, User user) {
		super();
		this.sessionId = sessionId;
		this.user = user;
	}

	public UserSession(String sessionId, User user, Facility fac, Booking trans, Date bDate) {
		super();
		this.sessionId = sessionId;
		this.user = user;
		this.fac = fac;
		this.trans = trans;
		this.bDate = bDate;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

	
}
