package io.streamnative.functions.ml.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileBasedTweetRepositoryTests {

    private FileBasedTweetRepository repo = new FileBasedTweetRepository();

    @Test
    public final void oneRandomTweetTest() {
        String tweet = repo.getRandomTweet();
        assertNotNull(tweet);
        assertEquals("All they could see was the blue water surrounding their sailboat.", tweet);
    }

    /*
     * The tweets.txt file has 267 lines in it, so make sure we can
     * read more tweets than this to confirm that the result logic works
     */
    @Test
    public final void resetOnceTest() {
        int count = 0;

        do {
            assertNotNull(repo.getRandomTweet());
        } while (++count < 300);
    }

    @Test
    public final void multiResetTest() {
        int count = 0;

        do {
            assertNotNull(repo.getRandomTweet());
        } while (++count < 30000);
    }
}
