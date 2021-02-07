package uni.pu.fmi.services;

import uni.pu.fmi.Comment;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.User;

public class CommentinService {

	public static String publishComment(String commentText, Torrent torrent) {
		User user = UserSessionService.getCurrentUser();
		if(user == null) {
			return "Влезте в профила си или се регистрирайте";
		}
		if(commentText.isBlank()) {
			return "Въведете текст";
		}
		Comment comment = new Comment(user,commentText);
		torrent.addComment(comment);
		return "Коментарът е публикуван успешно";
	}

}
