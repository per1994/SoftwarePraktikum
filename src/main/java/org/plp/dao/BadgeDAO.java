package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Badge;
import org.plp.benutzer.Benutzer;

public interface BadgeDAO {
	
	public void add(Badge badge);
	public List<Badge> listBadges();
	public void löschen(int badge_id);
	public boolean update(int badge_id);
	public Badge getBadge(int badge_id);

}
