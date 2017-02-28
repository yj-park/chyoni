package network.api;

import java.util.List;

class BlogJsonItemVO {
	private String pubDate;
	private String author;
	private String title;
	private String description;
	private String link;
	private String comment;
	
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

class BlogJsonChannel {
	private String result;
	private String pageCount;
	private String title;
	private String totalCount;
	private String description;
	private List<BlogJsonItemVO> item;
	private String lastBuildDate;
	private String link;
	private String generator;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<BlogJsonItemVO> getItem() {
		return item;
	}
	public void setItem(List<BlogJsonItemVO> item) {
		this.item = item;
	}
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
}

public class BlogJsonVO {
	private BlogJsonChannel channel;

	public BlogJsonChannel getChannel() {
		return channel;
	}

	public void setChannel(BlogJsonChannel channel) {
		this.channel = channel;
	}
}
