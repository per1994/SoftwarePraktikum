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
	public void addNewAvatar(String avatarName){
		System.out.println("Ich bin im Service, Methode addNewAvatar");
		Avatar avatar=new Avatar();
		avatarDAO.add(avatar);
		
	}
	
	@Transactional
	public List<Avatar>listAllAvatar(){
		return avatarDAO.listAvatars();
	}
	
	@Transactional
	public void löschen(int avatar_id){
		avatarDAO.löschen(avatar_id);
	}
	
	@Transactional
	public void update( int avatar_id){
		avatarDAO.update(avatar_id);
	}

	@Transactional
	public Avatar getAvatar(int avatar_id){
		return avatarDAO.getAvatar(avatar_id);
	}
}
