package com.jiewang.service.impl;

import com.jiewang.dao.CommentDao;
import com.jiewang.dao.base.BaseDao;
import com.jiewang.domain.Comment;
import com.jiewang.domain.CommentVisitor;
import com.jiewang.service.CommentService;
import com.jiewang.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
	
	@Resource private CommentDao commentDao;
	@Resource private CommentVisitor<Comment, Object> commentSelect;

    @Override
    public BaseDao<Comment> getDao() {
        return commentDao;
    }


    public Comment selectEntryByKey(Object key) {

        Comment comment = getDao().selectEntryByKey(key);

        comment.accept(commentSelect, null);

        return comment;
    }

    public List<Comment> selectEntryList(Comment condition) {

        List<Comment> comments = getDao().selectEntryList(condition);

        for (Comment comment : comments){
            comment.accept(commentSelect, null);
        }

        return comments;
    }
}