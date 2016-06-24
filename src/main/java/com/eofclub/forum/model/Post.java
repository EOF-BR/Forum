package com.eofclub.forum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import com.eofclub.forum.model.Category;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

	private static final long serialVersionUID = 7084323359678453044L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	private User author;

	private String answers;

	private String votes;

	private String title;

	private String body;

	private String create_at;

	private String update_at;

	private Category category;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public User getAutor() {
		return author;
	}

	public void setAutor(User autor) {
		this.author = autor;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (author != null)
			result += ", author: " + author;
		if (answers != null && !answers.trim().isEmpty())
			result += ", answers: " + answers;
		if (votes != null && !votes.trim().isEmpty())
			result += ", votes: " + votes;
		if (title != null && !title.trim().isEmpty())
			result += ", title: " + title;
		if (body != null && !body.trim().isEmpty())
			result += ", body: " + body;
		if (create_at != null && !create_at.trim().isEmpty())
			result += ", create_at: " + create_at;
		if (update_at != null && !update_at.trim().isEmpty())
			result += ", update_at: " + update_at;
		if (category != null)
			result += ", category: " + category;
		return result;
	}
}