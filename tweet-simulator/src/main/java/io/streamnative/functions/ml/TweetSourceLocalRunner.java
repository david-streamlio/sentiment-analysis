package io.streamnative.functions.ml;

import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.common.io.SourceConfig;
import org.apache.pulsar.functions.LocalRunner;

public class TweetSourceLocalRunner {

    public static void main(String[] args) throws Exception {

        SourceConfig sourceConfig =
                SourceConfig.builder()
                        .className(TweetSource.class.getName())
                        .name("cc-simulator")
                        .topicName("persistent://public/default/tweets-in")
                        .processingGuarantees(FunctionConfig.ProcessingGuarantees.ATMOST_ONCE)
                        .schemaType("string")
                        .build();

        LocalRunner localRunner =
                LocalRunner.builder()
                        .brokerServiceUrl("pulsar://localhost:6650")
                        .sourceConfig(sourceConfig)
                        .build();

        localRunner.start(false);
        Thread.sleep(120 * 1000);
        localRunner.stop();
    }
}
