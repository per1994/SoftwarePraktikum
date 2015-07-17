package org.plp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.plp.benutzer.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

	@Autowired
	private AvatarDAO avatarDAO;

	@Transactional
	public void addNewAvatar() {

		Avatar b = new Avatar();
		avatarDAO.add(b);

	}

	@Transactional
	public List<Avatar> listAllAvatar() {
		return avatarDAO.listAvatar();
	}

	@Transactional
	public void l�schen(int avatar_id) {
		avatarDAO.l�schen(avatar_id);
	}

	@Transactional
	public void update(Avatar avatar) {
		avatarDAO.update(avatar);
	}

	@Transactional
	public Avatar getAvatar(int avatar_id) {
		return avatarDAO.getAvatar(avatar_id);
	}

	@Transactional
	public boolean vorhanden(int avatar_id) {
		return avatarDAO.vorhanden(avatar_id);
	}
}
