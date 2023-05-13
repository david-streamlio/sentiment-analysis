package io.streamnative.functions.ml;

import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.io.core.Source;
import org.apache.pulsar.io.core.SourceContext;

import java.util.Map;

public class TweetSource implements Source<String> {

    private long delay = 5000;
    private RandomTweetGenerator random;

    @Override
    public void open(Map<String, Object> config, SourceContext ctx) throws Exception {
        random = new RandomTweetGenerator();
    }

    @Override
    public Record<String> read() throws Exception {
        Thread.sleep(delay);
        return new TweetRecord(random.get());
    }

    @Override
    public void close() throws Exception {

    }
}
