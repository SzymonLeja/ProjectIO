import jdk.jfr.Category;
import main.Post.Post;
import org.junit.jupiter.api.Test;
import mockit.Mocked;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category("MockedPost")
public class PostMockTest {

    @Mocked
    Post postMocked = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);


    @Test
    void createNewPost() {
        assertEquals("Very cool, strange and complicated title!", postMocked.getPostTitle());
        assertEquals("This is very cool description, I'm using it to test my post list class!", postMocked.getPostDescription());
        assertEquals("Phone = +48600700800", postMocked.getPostContact());
        assertEquals("Information", postMocked.getPostCategory());
        assertEquals(0, postMocked.getPostId());
    }

    @Test
    void createNewPostWithNullValues() {
        Post post = new Post(null, null, null, null, 0);
        assertEquals(null, post.getPostTitle());
        assertEquals(null, post.getPostDescription());
        assertEquals(null, post.getPostContact());
        assertEquals(null, post.getPostCategory());
        assertEquals(0, post.getPostId());
    }

    @Test
    void createNewPostWithEmptyValues() {
        Post post = new Post("", "", "", "", 0);
        assertEquals("", post.getPostTitle());
        assertEquals("", post.getPostDescription());
        assertEquals("", post.getPostContact());
        assertEquals("", post.getPostCategory());
        assertEquals(0, post.getPostId());
    }

    @Test
    void createNewPostAndSetNewValues() {
        postMocked.setPostTitle("Very cool, strange and complicated title! And this is edited version of it!");
        postMocked.setPostDescription("This is very cool description, I'm using it to test my postMocked list class! And this is edited version of it!");
        postMocked.setPostContact("Phone = +48600700800 And this is edited version of it!");
        postMocked.setPostCategory("Information And this is edited version of it!");
        assertEquals("Very cool, strange and complicated title! And this is edited version of it!", postMocked.getPostTitle());
        assertEquals("This is very cool description, I'm using it to test my postMocked list class! And this is edited version of it!", postMocked.getPostDescription());
        assertEquals("Phone = +48600700800 And this is edited version of it!", postMocked.getPostContact());
        assertEquals("Information And this is edited version of it!", postMocked.getPostCategory());
    }

    @Test
    void createNewPostAndGetId() {
        Post post = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);
        assertEquals(0, post.getPostId());
    }

    @Test
    void createNewPostAndGetTitle() {
        Post post = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);
        assertEquals("Very cool, strange and complicated title!", post.getPostTitle());
    }

    @Test
    void createNewPostAndGetDescription() {
        Post post = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);
        assertEquals("This is very cool description, I'm using it to test my post list class!", post.getPostDescription());
    }

    @Test
    void createNewPostAndGetContact() {
        Post post = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);
        assertEquals("Phone = +48600700800", post.getPostContact());
    }

    @Test
    void createNewPostAndGetCategory() {
        Post post = new Post("Very cool, strange and complicated title!", "This is very cool description, I'm using it to test my post list class!", "Phone = +48600700800", "Information", 0);
        assertEquals("Information", post.getPostCategory());
    }


}
