package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        averagePostsPerUser = (double) postsCount / usersCount;
        averagePostsPerUser = Double.isInfinite(averagePostsPerUser) ? 0 : (double) postsCount / usersCount;
        averageCommentsPerUser = (double) commentsCount / usersCount;
        averageCommentsPerUser = Double.isInfinite(averageCommentsPerUser) ? 0 : (double) commentsCount / usersCount;
        averageCommentsPerPost = (double) commentsCount / postsCount;
        averageCommentsPerPost = Double.isInfinite(averageCommentsPerPost) ? 0 : (double) commentsCount / postsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getPostsPerUser() {
        return averagePostsPerUser;
    }

    public double getCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getCommentsPerPost() {
        return averageCommentsPerPost;
    }
}