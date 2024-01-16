package com.CompitApplication.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.CommentsModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.CommentsRepository;
import com.CompitApplication.Repository.VideoRepository;
@Transactional
@Service
public class CommentsService {
	
	static LoggingUtils logger = new LoggingUtils(CommentsService.class.getName());
	

	@Autowired
	private VideoRepository videoRepo;

	@Autowired
	private CommentsRepository commentrepo;

	public String addcomment(int videoId, CommentsModel commentmodel) {

		VideoModel video = videoRepo.findByVideoId(videoId);

		CommentsModel comment = new CommentsModel();

		if (!commentmodel.getComment().equals(null) && commentmodel != null) {
			comment.setComment(commentmodel.getComment());
			comment.setVideomodel(video);
			commentrepo.save(comment);
			System.out.println("inserted comment id is " + comment.getCommentid());

		}

		return null;
	}

	public List<CommentsModel> fetchComment(int videoId) {

		return commentrepo.fetchVideoComment(videoId);

	}

	public String deleteComment(int id) {

		commentrepo.deleteById(id);

		return null;
	}

	public String CommentUpadte(int CommentId, int videoId, CommentsModel commModel) {
		VideoModel video = videoRepo.getById(videoId);

		CommentsModel comm = new CommentsModel();
		comm.setCommentid(CommentId);
		comm.setComment(commModel.getComment());
		comm.setVideomodel(video);
		commentrepo.save(comm);

		return null;
	}
}
