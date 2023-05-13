package io.streamnative.functions.ml;

public class AnalyzedTweet {

    private String tweet;

    private String sentiment;

    public AnalyzedTweet(String tweet, String sentiment) {
        this.tweet = tweet;
        this.sentiment = sentiment;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
