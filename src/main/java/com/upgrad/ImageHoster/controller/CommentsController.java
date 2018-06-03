package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/{id}/comments")
    public String getAllComments(@PathVariable int id, Model model) {
        List<Comment> list = commentService.findAll(id);
        model.addAttribute("comments", list);
        Image image = imageService.getByIdWithJoin(id);
        model.addAttribute("user", image.getUser());
        model.addAttribute("image", image);
        return "images/image";
    }

    @RequestMapping(value = "/image/{id}/comments/create", method = RequestMethod.POST)
    public String addComment(@PathVariable int id, @RequestParam("comment") Comment comment, HttpSession session) {
        comment.setId(System.currentTimeMillis()%1000);
        Image image = imageService.getById(id);
        comment.setImage(image);
        User commentUser = (User) session.getAttribute("currUser");
        comment.setUser(commentUser);
        commentService.create(comment);
        return "redirect:/{id}/comments";
    }


}
