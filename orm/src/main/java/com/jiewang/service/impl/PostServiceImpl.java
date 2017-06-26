package com.jiewang.service.impl;

import com.jiewang.dao.PostDao;
import com.jiewang.dao.base.BaseDao;
import com.jiewang.domain.Comment;
import com.jiewang.domain.Post;
import com.jiewang.service.AuthorService;
import com.jiewang.service.CommentService;
import com.jiewang.service.PostService;
import com.jiewang.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {
	
	@Resource private PostDao postDao;
    @Resource private AuthorService authorService;
    @Resource private CommentService commentService;


    @Override
    public BaseDao<Post> getDao() {
        return postDao;
    }


    public Post selectEntryByKey(Object key) {

        Post post = getDao().selectEntryByKey(key);

        visitPost(post);

        return post;
    }

    public List<Post> selectEntryList(Post condition) {

        List<Post> posts = getDao().selectEntryList(condition);
        for (Post post : posts){
            visitPost(post);
        }

        return posts;
    }

    private void visitPost(Post post){

        post.setAuthor(authorService.selectEntryByKey(post.getAuthor()));

        List<Comment> comments = new ArrayList<Comment>();

        for (Comment comment : post.getComments()){
            comments.add(commentService.selectEntryByKey(comment));
        }

        post.setComments(comments);

    }
}