package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Badge;

public interface BadgeDAO {
	public void add(Badge badge);

	public List<Badge> listBadge();

	public void löschen(int badge_id);

	public void update(Badge badge);

	public Badge getBadge(int badge_id);

	public boolean vorhanden(int badge_id);

}
