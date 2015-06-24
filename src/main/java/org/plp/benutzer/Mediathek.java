package org.plp.benutzer;

import java.util.Set;

public class Mediathek<T> {

	private Set<T> date;

	public Set<T> getDate() {
		return date;
	}

	public void setDate(Set<T> date) {
		this.date = date;
	}
}
