package main.Post;

public class Post {
    private String postTitle;
    private String postDescription;
    private String postContact;
    private String postCategory;
    private Integer postId;

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public String getPostContact() {
        return postContact;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public Integer getPostId() {
        return postId;
    }

    public Post(String postTitle, String postDescription, String postContact, String postCategory, Integer postId) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postContact = postContact;
        this.postCategory = postCategory;
        this.postId = postId;
    }

    protected void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    protected void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    protected void setPostContact(String postContact) {
        this.postContact = postContact;
    }

    protected void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }
}
