package com.CompitApplication.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.CommentsModel;
import com.CompitApplication.Model.ReplyModel;
import com.CompitApplication.Repository.CommentsRepository;
import com.CompitApplication.Repository.ReplyRepository;

@Transactional
@Service
public class ReplyService {
	
	static LoggingUtils logger = new LoggingUtils(ReplyService.class.getName());

	@Autowired
	private ReplyRepository replyrepo;

	@Autowired
	private CommentsRepository commentRepo;

	public String postReply(int id, ReplyModel reply) {
		CommentsModel comment = commentRepo.getById(id);
		if (!reply.getReply().equals(null) && reply != null) {
			ReplyModel rep = new ReplyModel();
			rep.setReply(reply.getReply());
			rep.setCommentmodel(comment);
			replyrepo.save(rep);
			System.out.println("the reply id is ====" + rep.getReplyId());
		}

		return null;
	}

	public String deleteReply(int id) {
		replyrepo.deleteById(id);

		return null;

	}

	public String replyUpadte(int ReplyId, int commentId, ReplyModel replyModel) {

		CommentsModel comm = commentRepo.getById(commentId);
		ReplyModel reply = new ReplyModel();

		reply.setReplyId(ReplyId);
		reply.setReply(replyModel.getReply());
		reply.setCommentmodel(comm);
		replyrepo.save(reply);

		return null;
	}
}
