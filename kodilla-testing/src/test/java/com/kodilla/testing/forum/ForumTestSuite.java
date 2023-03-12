package com.kodilla.testing.forum;
import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;


class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }
    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }


    @DisplayName("when create SimpleUser with realName, " +
            "then getRealName should return real user name"
    )
    @Test
     void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing: " + result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
