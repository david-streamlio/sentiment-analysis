package io.streamnative.functions.ml;

import io.streamnative.functions.ml.data.FileBasedTweetRepository;
import io.streamnative.functions.ml.data.RandomTweetRepository;
import io.streamnative.functions.ml.data.TweetRepository;
import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.io.core.Source;
import org.apache.pulsar.io.core.SourceContext;

import java.util.Map;

public class TweetSource implements Source<String> {

    private long delay = 5000;
    private TweetRepository tweetRepository;

    @Override
    public void open(Map<String, Object> config, SourceContext ctx) throws Exception {
        tweetRepository = new FileBasedTweetRepository();
    }

    @Override
    public Record<String> read() throws Exception {
        Thread.sleep(delay);
        return new TweetRecord(tweetRepository.getRandomTweet());
    }

    @Override
    public void close() throws Exception {
        // Nothing to do.
    }
}
