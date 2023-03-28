package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class StatisticsCalculatorTest {

    @Mock
    private StatisticsCalculator statisticsCalculator;
    private Statistics statisticsMock;
    private List<String> users;

    @BeforeEach
    public void beforeTestAnnotation() {
        System.out.println("Test begin: ");
    }
    public double setAvgOfCommentsPerUser() {
        return (double) statisticsMock.commentsCount() / statisticsMock.usersNames().size();
    }
    public double setAvgOfCommentsPerPosts() {
        return (double) statisticsMock.commentsCount() / statisticsMock.postsCount();
    }
    public double setAvgOfPostsPerUse() {
        return (double) statisticsMock.postsCount() / statisticsMock.usersNames().size();
    }
    public void setStatistics() {
        statisticsMock = mock(Statistics.class);
        statisticsCalculator = new StatisticsCalculator();
        users = statisticsMock.usersNames();
    }
    @AfterEach
    public void afterTestAnnotation() { System.out.println("Test passed. "); }

    @Test
    public void testWhenNoPosts() {

        // Given
        setStatistics();
        users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        users.add("userC");

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(3);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedPPerUser = setAvgOfPostsPerUse();

        // Then
        assertEquals(3, statisticsCalculator.getUsersCount());
        assertEquals(0, statisticsCalculator.getPostsCount());
        assertEquals(3, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(0, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());
    }

    @Test
    public void testWhen1000Posts() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        users.add("userC");

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedCPerPost = setAvgOfCommentsPerPosts();
        double expectedPPerUser = setAvgOfPostsPerUse();

        //Then
        assertEquals(3, statisticsCalculator.getUsersCount());
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(10, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());
    }

    @Test
    public void testWhen0Comments() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        users.add("userC");

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedCPerPost = setAvgOfCommentsPerPosts();
        double expectedPPerUser = setAvgOfPostsPerUse();

        //Then
        assertEquals(3, statisticsCalculator.getUsersCount());
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());
    }

    @Test
    public void testWhenCommentsCountIsSmallerThanPostsCount() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        users.add("userC");

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedCPerPost = setAvgOfCommentsPerPosts();
        double expectedPPerUser = setAvgOfPostsPerUse();
        boolean expectedResult = statisticsMock.commentsCount() < statisticsMock.postsCount();

        //Then
        assertEquals(3, statisticsCalculator.getUsersCount());
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(500, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());
        assertTrue(expectedResult);
    }

    @Test
    public void testWhenCommentsCountIsBiggerThanPostsCount() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        users.add("userC");

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(250);
        when(statisticsMock.commentsCount()).thenReturn(251);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedCPerPost = setAvgOfCommentsPerPosts();
        double expectedPPerUser = setAvgOfPostsPerUse();
        boolean expectedResult = statisticsMock.commentsCount() > statisticsMock.postsCount();

        //Then
        assertEquals(3, statisticsCalculator.getUsersCount());
        assertEquals(250, statisticsCalculator.getPostsCount());
        assertEquals(251, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());
        assertTrue(expectedResult);
    }

    @Test
    public void testWhen0UsersCount() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(250);
        when(statisticsMock.commentsCount()).thenReturn(251);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        double expectedCPerPost = setAvgOfCommentsPerPosts();

        //Then
        assertEquals(0, statisticsCalculator.getUsersCount());
        assertEquals(250, statisticsCalculator.getPostsCount());
        assertEquals(251, statisticsCalculator.getCommentsCount());
        assertEquals(0, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(0, statisticsCalculator.getCommentsPerUser());
    }

    @Test
    public void testWhen100Users() {

        //Given
        setStatistics();
        users = new ArrayList<>();
        List<String> spy = spy(users);
        when(spy.size()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(spy);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(80);

        //When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        double expectedCPerUser = setAvgOfCommentsPerUser();
        double expectedCPerPost = setAvgOfCommentsPerPosts();
        double expectedPPerUser = setAvgOfPostsPerUse();

        //Then
        assertEquals(100, statisticsCalculator.getUsersCount());
        assertEquals(50, statisticsCalculator.getPostsCount());
        assertEquals(80, statisticsCalculator.getCommentsCount());
        assertEquals(expectedPPerUser, statisticsCalculator.getPostsPerUser());
        assertEquals(expectedCPerPost, statisticsCalculator.getCommentsPerPost());
        assertEquals(expectedCPerUser, statisticsCalculator.getCommentsPerUser());

    }
}


