package com.jiewang.service.impl;

import com.jiewang.dao.CommentDao;
import com.jiewang.dao.CommentOneDao;
import com.jiewang.dao.CommentTwoDao;
import com.jiewang.domain.Comment;
import com.jiewang.domain.CommentOne;
import com.jiewang.domain.CommentTwo;
import com.jiewang.domain.CommentVisitor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yanxiongliang on 4/29/15.
 */
@Service("commentSelect")
public class CommentSelect implements CommentVisitor<Comment, Object> {

    @Resource
    private CommentDao commentDao;
    @Resource
    private CommentOneDao commentOneDao;
    @Resource
    private CommentTwoDao commentTwoDao;

    @Override
    public Comment visit(Comment f, Object o) {

        return f;
    }

    @Override
    public Comment visit(CommentOne f, Object o) {

        CommentOne commentOne = commentOneDao.selectEntryByKey(f);

        f.setCommentOne(commentOne.getCommentOne());

        return f;
    }

    @Override
    public Comment visit(CommentTwo f, Object o) {

        CommentTwo commentTwo = commentTwoDao.selectEntryByKey(f);

        f.setCommentTwo(commentTwo.getCommentTwo());

        return f;
    }
}
