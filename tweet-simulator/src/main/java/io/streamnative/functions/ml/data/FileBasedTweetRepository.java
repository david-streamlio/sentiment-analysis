package io.streamnative.functions.ml.data;

import java.io.*;

public class FileBasedTweetRepository implements TweetRepository {

    private InputStream inputStream;

    // Create a BufferedReader to read the lines of the file
    private BufferedReader reader;

    public FileBasedTweetRepository() {
        inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tweets.txt");
        reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            reader.mark(65000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getRandomTweet() {

        String tweet = null;

        do {
            try {
                tweet = reader.readLine();

                if (tweet == null) {
                    reader.reset();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } while (tweet == null);

        return tweet;
    }

}
