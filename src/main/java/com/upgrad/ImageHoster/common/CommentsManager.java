package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class CommentsManager extends SessionManager{

    /**
     * This method saves an image's data to the database
     *
     * @param comment the comment who's data that we want to save to the database
     */
    public void saveComment(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }
    /**
     * This method retrieves all of the images saved in the database
     *
     * @return a List of Comment objects for an Image
     */
    public List<Comment> getAllComments(int id) {
        Session session = openSession();
        List<Comment> comments = session.createCriteria(Comment.class).list();
        List<Comment> commentsForImage = new ArrayList<>();
        for(Comment c: comments) {
            if (c.getImage().getId() == id) {
                commentsForImage.add(c);
            }
        }
        commitSession(session);
        return commentsForImage;
    }
}
