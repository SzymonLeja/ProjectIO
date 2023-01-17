package main.Post;

import java.util.HashMap;

public class PostList implements PostInterface {
    private final HashMap<Integer, Post> postHashMap;
    public PostList() {
        this.postHashMap = new HashMap<Integer, Post>();
    }

    public HashMap<Integer, Post> getPostHashMap() {
        return postHashMap;
    }

    @Override
    public String toString() {
        String result = "";
        for (Integer key : postHashMap.keySet()) {
            result += key +" = {" + "\n Post Title = " + postHashMap.get(key).getPostTitle() + ",\n Post Description =" + postHashMap.get(key).getPostDescription() + ",\n Post Contact =" + postHashMap.get(key).getPostContact() + ",\n Post Category = " + postHashMap.get(key).getPostCategory() + ",\n Post Id = " + postHashMap.get(key).getPostId() + "\n}";
            if(key+1 != postHashMap.size()) {
                result += ",\n ";
            }

    }
        return result;
    }

    @Override
    public Post findPost(Integer postId) {
        return postHashMap.get(postId);
    }

    @Override
    public void editPost(Integer postId, String postTitle, String postDescription, String postContact, String postCategory) {
        Post postToEdit = findPost(postId);
        postToEdit.setPostTitle(postTitle == null ? postToEdit.getPostTitle() : postTitle);
        postToEdit.setPostCategory(postCategory == null ? postToEdit.getPostCategory() : postCategory);
        postToEdit.setPostDescription(postDescription == null ? postToEdit.getPostDescription() : postDescription);
        postToEdit.setPostContact(postContact == null ? postToEdit.getPostContact() : postContact);
    }

    @Override
    public void addPost(String postTitle, String postDescription, String postContact, String postCategory) {
        Integer newPostId = postHashMap.size();
        while(findPost(newPostId) != null){
            newPostId++;
        }
        Post newPost = new Post(postTitle, postDescription, postContact, postCategory, newPostId);
        postHashMap.put(newPostId, newPost);
    }

    @Override
    public void deletePost(Integer postId) {
        postHashMap.remove(postId);
    }

    @Override
    public void createPostList() {
        new PostList();
    }

    @Override
    public PostList getPostList() {
        return this;
    }
}
