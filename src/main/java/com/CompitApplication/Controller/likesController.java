package com.CompitApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Service.LikesService;

@RestController
@RequestMapping("/api/v1/likes")
public class likesController {
	
	static LoggingUtils logger = new LoggingUtils(likesController.class.getName());

	@Autowired
	private LikesService likeServe;

	@PostMapping("/UpdatingPost/{videoId}/{UserId}/save")
	public String LikesTesting(@PathVariable("videoId") int videoId, @PathVariable("UserId") int UserId) {
// have to make trigger the count of the likes once click the api 
		return likeServe.LikesSave(videoId, UserId);
	}

	@GetMapping("/gettingVideo/{videoId}/count")
	public void countingLikes(@PathVariable("videoId") int videoId) {

		likeServe.findingCount(videoId);
	}

}
