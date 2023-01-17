package main.Post;

public interface PostInterface {
    public Post findPost(Integer postId);
    public void editPost(Integer postId, String postTitle, String postDescription, String postContact, String postCategory);
    public void addPost(String postTitle, String postDescription, String postContact, String postCategory);
    public void deletePost(Integer postId);
    public void createPostList();
    public PostList getPostList();
}
