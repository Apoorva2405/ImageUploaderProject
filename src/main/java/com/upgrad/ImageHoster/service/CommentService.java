package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll(int id);
    void create(Comment comment);
}
