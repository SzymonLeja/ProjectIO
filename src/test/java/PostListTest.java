import main.Post.Post;
import main.Post.PostInterface;
import main.Post.PostList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostListTest extends PostList {

    @Test
    void createNewEmptyPostList() {
        PostList postList = PostInterface.createPostList();
        assertEquals(0, postList.getPostHashMap().size());
    }

    @Test
    void addNewPostAndFindItProperly(){
        PostList postList = PostInterface.createPostList();
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postList.addPost(postTitle, postDescription, postContact, postCategory);
        Post postFromList = postList.findPost(0);
        assertEquals(postDescription,postFromList.getPostDescription());
    }

    @Test
    void addNewPostEditAndFindItProperly(){
        PostList postList = PostInterface.createPostList();
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postDescriptionEdited = "This is very cool description, I'm using it to test my post list class! And this is edited version of it!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postList.addPost(postTitle, postDescription, postContact, postCategory);
        postList.editPost(0, postTitle, postDescriptionEdited, postContact, postCategory);
        Post postFromList = postList.findPost(0);
        assertNotEquals(postDescription,postFromList.getPostDescription());
    }
    @Test
    void addTwoPostsDeleteFirstAndFindSecondProperly(){
        PostList postList = PostInterface.createPostList();
        String postTitle = "Very cool, strange and complicated title!";
        String secondPostTitle = "Very cool, strange and complicated title! But its second one!";

        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postList.addPost(postTitle, postDescription, postContact, postCategory);
        postList.addPost(secondPostTitle, postDescription, postContact, postCategory);
        postList.deletePost(0);
        Post postFromList = postList.findPost(0);
        Post secondPostFromList = postList.findPost(1);
        assertNull(postFromList);
        assertEquals(secondPostTitle, secondPostFromList.getPostTitle());
    }

    @Test
    void getHashMapProperly(){
        PostList postList = PostInterface.createPostList();
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postList.addPost(postTitle, postDescription, postContact, postCategory);
        assertEquals(1,postList.getPostHashMap().size());
    }
}