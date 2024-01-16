package com.CompitApplication.dtos;

public class ReplyDto {

	private String reply;

	private Long replyID;

	private Long commentId;

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Long getReplyID() {
		return replyID;
	}

	public void setReplyID(Long replyID) {
		this.replyID = replyID;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		return "ReplyDto [reply=" + reply + ", replyID=" + replyID + ", commentId=" + commentId + "]";
	}

	public ReplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
