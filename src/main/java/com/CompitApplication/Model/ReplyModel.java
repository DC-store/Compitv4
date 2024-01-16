package com.CompitApplication.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reply_model")     
public class ReplyModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyId;
	
	private String reply;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_id", referencedColumnName = "commentid")
	@JsonIgnoreProperties("replies")
	private CommentsModel commentmodel;


	public ReplyModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReplyModel(int replyId, String reply, CommentsModel commentmodel) {
		super();
		this.replyId = replyId;
		this.reply = reply;
		this.commentmodel = commentmodel;
	}


	@Override
	public String toString() {
		return "ReplyModel [replyId=" + replyId + ", reply=" + reply + ", commentmodel=" + commentmodel + "]";
	}


	public int getReplyId() {
		return replyId;
	}


	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}


	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}


	public CommentsModel getCommentmodel() {
		return commentmodel;
	}


	public void setCommentmodel(CommentsModel commentmodel) {
		this.commentmodel = commentmodel;
	}
	
	
	

}
