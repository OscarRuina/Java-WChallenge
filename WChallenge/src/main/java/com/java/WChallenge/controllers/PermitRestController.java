package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.helpers.ViewRouteHelper;
import com.java.WChallenge.models.UserModel;
import com.java.WChallenge.services.PermitService;

@RestController
@RequestMapping("/")
public class PermitRestController {
	
	@Autowired
	private PermitService permitService;
	
	@GetMapping("POST/sharedAlbum/:{idAlbum}/user/:{idUser}/read={read}/write={write}")
	public String insertSharedAlbum(@PathVariable("idAlbum")long idAlbum, @PathVariable("idUser")long idUser,
			@PathVariable("read") boolean read,@PathVariable("write")boolean write) {
		permitService.insertSharedAlbum(idAlbum, idUser,read,write);
		return ViewRouteHelper.SHAREDALBUM;
	}
	
	@GetMapping("POST/sharedAlbum/update/:{idAlbum}/user/:{idUser}/read={read}/write={write}")
	public String updateSharedAlbum(@PathVariable("idAlbum")long idAlbum, @PathVariable("idUser")long idUser,
			@PathVariable("read") boolean read,@PathVariable("write")boolean write) {
		permitService.updateSharedAlbum(idAlbum, idUser,read,write);
		return ViewRouteHelper.UPDATESHAREDALBUM;
	}
	
	@GetMapping("GET/users/album/:{idAlbum}/permits/read:{read}/write:{write}")
	public List<UserModel> getUsersPermitsByAlbum(@PathVariable("idAlbum")long idAlbum,
			@PathVariable("read")boolean read,@PathVariable("write")boolean write){
		return permitService.getUsersPermitsByAlbum(idAlbum,read,write);
	}
	
}
