package com.haruatari.task18;

final class Post {
    public final int likesNumber;
    public final User author;

    public Post(int likesNumber, User author) {
        this.likesNumber = likesNumber;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post(likesNumber: " + likesNumber + "; author: " + author + ")";
    }
}
