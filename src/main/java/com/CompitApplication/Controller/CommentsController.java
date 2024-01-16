package com.CompitApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.CommentsModel;
import com.CompitApplication.Service.CommentsService;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

	@Autowired
	private CommentsService commentServe;
	
	
	static LoggingUtils logger = new LoggingUtils(CommentsController.class.getName());

	@PostMapping("/video/{videoId}/save")
	public String AddingComment(@PathVariable("videoId") int videoId, @RequestBody CommentsModel comment) {

		return commentServe.addcomment(videoId, comment);
	}

	@GetMapping("/getComment/{videoId}/Comment")
	public List<CommentsModel> getCommentById(@PathVariable("videoId") int videoId) {

		return commentServe.fetchComment(videoId);

	}

	@DeleteMapping("/{commentId}/deleteComment")
	public String DeleteComment(@PathVariable("commentId") int id) {

		return commentServe.deleteComment(id);
	}

	@PutMapping("/{commentId}/{videoId}/updateComment")
	public String commentupdate(@PathVariable("commentId") int commentId, @PathVariable("videoId") int videoId,
			@RequestBody CommentsModel commentsModel) {

		return commentServe.CommentUpadte(commentId, videoId, commentsModel);
	}
}
