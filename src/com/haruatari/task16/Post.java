package com.haruatari.task16;

final public class Post {
    public final int likesNumber;
    public final int repostsNumber;
    public final User author;

    public Post(int likesNumber, int repostsNumber, User author) {
        this.likesNumber = likesNumber;
        this.repostsNumber = repostsNumber;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post(likesNumber: " + likesNumber + "; repostsNumber: " + repostsNumber + "; author: " + author + ")";
    }
}
