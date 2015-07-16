package org.plp.dao;

import java.util.List;

import org.plp.benutzer.Avatar;
import org.plp.benutzer.Benutzer;

public interface AvatarDAO {
	
	public void add(Avatar avatar);
	public List<Avatar> listAvatars();
	public void l�schen(int avatar_id);
	public boolean update(int avatar_id);
	public Avatar getAvatar(int avatar_id);

}
