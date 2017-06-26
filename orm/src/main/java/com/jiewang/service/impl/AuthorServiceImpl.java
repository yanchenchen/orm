package com.jiewang.service.impl;

import com.jiewang.dao.AuthorDao;
import com.jiewang.dao.base.BaseDao;
import com.jiewang.domain.Author;
import com.jiewang.service.AuthorService;
import com.jiewang.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("authorService")
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
	
	@Resource private AuthorDao authorDao;

    @Override
    public BaseDao<Author> getDao() {
        return authorDao;
    }
}