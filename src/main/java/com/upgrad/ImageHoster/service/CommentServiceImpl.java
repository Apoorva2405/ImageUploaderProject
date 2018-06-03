package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentsManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private List<Comment> comments = new ArrayList<Comment>();
    private CommentsManager commentsManager;

    public CommentServiceImpl() {
        commentsManager = new CommentsManager();
    }

    @Override
    public void create(Comment comment) {
        commentsManager.saveComment(comment);
    }

    @Override
    public List<Comment> findAll(int id) { return commentsManager.getAllComments(id); }

}
