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
public class PermitController {
	
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
		permitService.insertOrUpdateSharedAlbum(idAlbum, idUser,read,write);
		return ViewRouteHelper.UPDATESHAREDALBUM;
	}
	//does not working
	@GetMapping("GET/users/permits/album/:{album}/read={read}/write={write}")
	public List<UserModel> getUsersByPermits(@PathVariable("idAlbum")long idAlbum,
			@PathVariable("read") boolean read,@PathVariable("write")boolean write){
		List<UserModel> users = permitService.getUserByPermits(idAlbum, read, write);
		return users;
	}
	
}
