package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Comment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-06-12.
 */
public class CommentService {
    private Map<Long, Comment> comments = DatabaseClass.getComments();

    public CommentService(){
        comments.put(1L, new Comment(1, "First comment", "Epredator"));
        comments.put(2L, new Comment(2, "Second comment", "Epredator2"));
    }

    public List<Comment> getAllComments(){
        return new ArrayList<Comment>(comments.values());
    }

    public List<Comment> getAllMessagesForYear(int year){
        List<Comment> commentsForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Comment comment : comments.values()){
            cal.setTime(comment.getCreated());
            if(cal.get(Calendar.YEAR) == year)
                commentsForYear.add(comment);
        }
        return commentsForYear;
    }

    public List<Comment> getAllCommentsPaginated(int start, int size){
        List<Comment> list = new ArrayList<>(comments.values());
        return list.subList(start, start+size);
    }

    public Comment getComment(long id){
        return comments.get(id);
    }

    public Comment addComment(Comment comment){
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(Comment comment){
        if(comment.getId() <= 0){
            return null;
        }else{
            comments.put(comment.getId(), comment);
            return comment;
        }
    }

    public Comment removeComment(long id){
        return comments.remove(id);
    }


}
