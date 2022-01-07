package edu.web.model;

import java.util.Date;

public class Board {
	private int boardId;
	private String title;
	private String content;
	private String writer;
	private Date updateTime;
	private int viewCount;
	
	public Board() {}

	public Board(int boardId, String title, String content, 
			String writer, Date updateTime, int viewCount) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.updateTime = updateTime;
		this.viewCount = viewCount;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Board{boardId: %d, title: %s, content: %s, writer: %s, updateTime: %s, viewCount: %d}", 
				this.boardId,
				this.title,
				this.content,
				this.writer,
				this.updateTime.toString(),
				this.viewCount);
	}
}