package com.jiewang.service.impl;

import com.jiewang.dao.BlogDao;
import com.jiewang.dao.base.BaseDao;
import com.jiewang.domain.Blog;
import com.jiewang.domain.Post;
import com.jiewang.service.AuthorService;
import com.jiewang.service.BlogService;
import com.jiewang.service.PostService;
import com.jiewang.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("blogService")
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BlogService {
	
	@Resource private BlogDao blogDao;
    @Resource private AuthorService authorService;
    @Resource private PostService postService;

    @Override
    public BaseDao<Blog> getDao() {
        return blogDao;
    }


    public Blog selectEntryByKey(Object key) {

        Blog blog = getDao().selectEntryByKey(key);

        visitBlog(blog);

        return blog;
    }

    public List<Blog> selectEntryList(Blog condition) {

        List<Blog> blogs = getDao().selectEntryList(condition);
        for (Blog blog : blogs){
            visitBlog(blog);
        }

        return blogs;
    }

    private void visitBlog(Blog blog){

        blog.setAuthor(authorService.selectEntryByKey(blog.getAuthor()));

        List<Post> posts = new ArrayList<Post>();
        for (Post post : posts){
            posts.add(postService.selectEntryByKey(post));
        }
        blog.setPosts(posts);

    }
}