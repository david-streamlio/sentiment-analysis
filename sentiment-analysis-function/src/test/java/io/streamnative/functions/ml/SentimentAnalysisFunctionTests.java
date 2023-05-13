package io.streamnative.functions.ml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SentimentAnalysisFunctionTests {

    public SentimentAnalysisFunction function = new SentimentAnalysisFunction();

    @Before
    public void init() {
        function.initialize(null);
    }

    @Test
    public final void positiveSentimentTweetTest() throws Exception {
        AnalyzedTweet result = function.process("Everything is great, great, great", null);
        assertNotNull(result);
        assertEquals("Positive", result.getSentiment());
    }

    @Test
    public final void negativeSentimentTweetTest() throws Exception {
        AnalyzedTweet result = function.process("What a horrible day.", null);
        assertNotNull(result);
        assertEquals("Negative", result.getSentiment());
    }
}
