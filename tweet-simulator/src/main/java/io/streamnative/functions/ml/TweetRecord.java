package io.streamnative.functions.ml;

import org.apache.pulsar.functions.api.Record;

import java.util.Optional;

public class TweetRecord implements Record<String> {

    private String text;

    public TweetRecord(String s) {
        this.text = s;
    }

    @Override
    public String getValue() {
        return text;
    }

    @Override
    public Optional<String> getKey() {
        return Optional.of("");
    }
}
