package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Comment;
import com.etroya.model.ErrorMessage;
import com.etroya.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-06-12.
 */
public class CommentService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();


    public List<Comment> getAllComments(long messageId){
       Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

//    public List<Comment> getAllMessagesForYear(int year){
//        List<Comment> commentsForYear = new ArrayList<>();
//        Calendar cal = Calendar.getInstance();
//        for(Comment comment : comments.values()){
//            cal.setTime(comment.getCreated());
//            if(cal.get(Calendar.YEAR) == year)
//                commentsForYear.add(comment);
//        }
//        return commentsForYear;
//    }

//    public List<Comment> getAllCommentsPaginated(int start, int size){
//        List<Comment> list = new ArrayList<>(comments.values());
//        return list.subList(start, start+size);
//    }

    public Comment getComment(long messageId, long commentId){
        Message msg = messages.get(messageId);
        ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://etroya.pl");
        Response resp = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage).build();
        if(msg == null){
            throw new WebApplicationException(resp);
        }
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        Comment comm = comments.get(commentId);
        if(comm == null){
            throw new WebApplicationException(resp);
        }
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if(comment.getId() <= 0){
            return null;
        }else{
            comments.put(comment.getId(), comment);
            return comment;
        }
    }

    public Comment removeComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }


}
