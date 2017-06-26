package com.jiewang.domain;

public class Comment {

    Long id;
    Long post_id;
    String name;
    String comment;
    String commentType;

    public Comment(){
        this.commentType = "C";
    }

    public Comment(String type){
        this.commentType = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public <T, A> T accept(CommentVisitor<T, A> v, A a) {
        return v.visit(this, a);
    }
}
