package citybike.HelsinkiCitybikeBackend.comment;




import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@CrossOrigin 

@Entity
public class Comment {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;
	private String comment_text;
	private String nickname;
	private int stars;

	public Comment() {
		super();
		this.comment_text = null;
		this.nickname = null;
	
	}

	public Comment(String comment_text, String nickname, int stars) {
		super();
		this.comment_text = comment_text;
		this.nickname = nickname;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setCommentText(String comment_text) {
		this.comment_text = comment_text;
	}

	@Override
	public String toString() {

		return "Kysely [id=" + comment_id + ", nimi=" + comment_text + "]";

	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

}
