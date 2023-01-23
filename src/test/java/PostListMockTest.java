import jdk.jfr.Category;
import main.Post.Post;
import main.Post.PostInterface;
import main.Post.PostList;
import mockit.Mocked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Category("MockedPostList")
class PostListMockTest extends PostList {

    @Mocked
    PostInterface postInterface = new PostList();
    @Test
    void createNewEmptyPostList() {
        assertEquals(0, postInterface.getPostList().getPostHashMap().size());
    }

    @Test
    void addNewPostAndFindItProperly(){
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        Post postFromList = postInterface.findPost(0);
        assertEquals(postDescription,postFromList.getPostDescription());
    }

    @Test
    void addNewPostAndEditItProperlyWithNullValues(){
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        postInterface.editPost(0, null, null, null, null);
        Post postFromList = postInterface.findPost(0);
        assertEquals(postTitle,postFromList.getPostTitle());
        assertEquals(postDescription,postFromList.getPostDescription());
        assertEquals(postContact,postFromList.getPostContact());
        assertEquals(postCategory,postFromList.getPostCategory());
    }
    @Test
    void addNewPostEditAndFindItProperly(){
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postDescriptionEdited = "This is very cool description, I'm using it to test my post list class! And this is edited version of it!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        PostListMockTest.this.postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        PostListMockTest.this.postInterface.editPost(0, postTitle, postDescriptionEdited, postContact, postCategory);
        Post postFromList = PostListMockTest.this.postInterface.findPost(0);
        assertNotEquals(postDescription,postFromList.getPostDescription());
    }

    @Test
    void addNewPostAndDeleteItProperly(){
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        PostListMockTest.this.postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        int postInterfaceSizeBeforeDelete = PostListMockTest.this.postInterface.getPostList().getPostHashMap().size();
        PostListMockTest.this.postInterface.deletePost(0);
        int postInterfaceSizeAfterDelete = PostListMockTest.this.postInterface.getPostList().getPostHashMap().size();
        assertNotEquals(postInterfaceSizeBeforeDelete,postInterfaceSizeAfterDelete);
    }
    @Test
    void addTwoPostsDeleteFirstAndFindSecondProperly(){
        String postTitle = "Very cool, strange and complicated title!";
        String secondPostTitle = "Very cool, strange and complicated title! But its second one!";

        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        PostListMockTest.this.postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        PostListMockTest.this.postInterface.addPost(secondPostTitle, postDescription, postContact, postCategory);
        PostListMockTest.this.postInterface.deletePost(0);
        Post postFromList = PostListMockTest.this.postInterface.findPost(0);
        Post secondPostFromList = PostListMockTest.this.postInterface.findPost(1);
        assertNull(postFromList);
        assertEquals(secondPostTitle, secondPostFromList.getPostTitle());
    }

    @Test
    void getHashMapProperly(){
        String postTitle = "Very cool, strange and complicated title!";
        String postDescription = "This is very cool description, I'm using it to test my post list class!";
        String postContact = "Phone = +48600700800";
        String postCategory = "Information";
        PostListMockTest.this.postInterface.addPost(postTitle, postDescription, postContact, postCategory);
        assertEquals(1,PostListMockTest.this.postInterface.getPostList().getPostHashMap().size());
    }
}