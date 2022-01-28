package org.example.task1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {

    @JsonProperty("_id")
    private String id;
    private String text;
    private FactType type;
    private User user;
    private int upvotes;
    private Integer userUpvoted;

    public Fact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FactType getType() {
        return type;
    }

    public void setType(FactType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(Integer userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    @Override
    public String toString() {
        return "\nFact id='" + id + "'" +
                "\n\ttext='" + text + "'" +
                "\n\ttype=" + type +
                "\n\tuser=" + user +
                "\n\tupvotes=" + upvotes +
                "\n\tuserUpvoted=" + userUpvoted;
    }
}
