package br.com.java.post.helper;

public class MessageHelper {
    private static final String USER_NOT_FOUND = "User not found!";
    private static final String POST_NOT_FOUND = "Post not found!";

    public static String getUserNotFound() {
        return USER_NOT_FOUND;
    }

    public static String getPostNotFound() {
        return POST_NOT_FOUND;
    }

    @Override
    public String toString() {
        return "MessageHelper []";
    }
}
