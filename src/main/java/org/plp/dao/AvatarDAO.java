package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Avatar;

public interface AvatarDAO {
	public void add(Avatar avatar);

	public List<Avatar> listAvatar();

	public void löschen(int avatar_id);

	public void update(Avatar avatar);

	public Avatar getAvatar(int avatar_id);

	public boolean vorhanden(int avatar_id);

}
