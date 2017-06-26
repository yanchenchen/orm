package com.jiewang.domain;

public interface CommentVisitor<T,A> {

    T visit(Comment f, A a);
    T visit(CommentOne f, A a);
    T visit(CommentTwo f, A a);

}
