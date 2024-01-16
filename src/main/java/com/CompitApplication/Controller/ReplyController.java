package com.CompitApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ReplyModel;
import com.CompitApplication.Service.ReplyService;



@RestController
@RequestMapping("/api/v1/reply")
public class ReplyController {
	
	
	static LoggingUtils logger = new LoggingUtils(ReplyController.class.getName());
	
	
	@Autowired
	private ReplyService replyserv;
	
	
	@PostMapping("/{commentId}/saveReply")
	public String PostReply(@PathVariable("commentId") int commentId, @RequestBody ReplyModel reply) {
		
		
		
		return replyserv.postReply(commentId, reply);
	}
	
	@DeleteMapping("/{replyId}/deleteReply")
	public String deletReply(@PathVariable("replyId") int id) {
		
		return replyserv.deleteReply(id);
	}
	
	@PutMapping("/{replyId}/{commentId}/updateReply")
	public String replyUpdate(@PathVariable("replyId") int replyId,@PathVariable("commentId") int commentId, @RequestBody ReplyModel replyModel) {
		
		return replyserv.replyUpadte(replyId,commentId, replyModel);
	}

}
