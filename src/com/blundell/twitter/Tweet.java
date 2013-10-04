package com.blundell.twitter;

public class Tweet {
    private final String username;
    private final String content;

    public Tweet(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return username + " : " + content;
    }

}
