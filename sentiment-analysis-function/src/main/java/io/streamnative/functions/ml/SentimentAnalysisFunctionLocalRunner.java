package io.streamnative.functions.ml;

import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.common.functions.ConsumerConfig;
import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.functions.LocalRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SentimentAnalysisFunctionLocalRunner {

    private final static String IN = "persistent://public/default/tweets-in";
    private final static String OUT = "persistent://public/default/tweets-out";

    public static void main(String[] args) throws Exception {

        LocalRunner localRunner =
                LocalRunner.builder()
                        .brokerServiceUrl("pulsar://localhost:6650")
                        .functionConfig(getFunctionConfig())
                        .build();

        localRunner.start(false);
        Thread.sleep(60 * 1000);
        localRunner.stop();
    }

    private static FunctionConfig getFunctionConfig() {

        Map<String, ConsumerConfig> inputSpecs = new HashMap<String, ConsumerConfig>();
        inputSpecs.put(IN, ConsumerConfig.builder().schemaType(
                Schema.STRING.getSchemaInfo().getType().toString()).build());

        return FunctionConfig.builder()
                .className(SentimentAnalysisFunction.class.getName())
                .cleanupSubscription(true)
                .inputs(Collections.singleton(IN))
                .inputSpecs(inputSpecs)
                .output(OUT)
                .outputSchemaType(Schema.JSON(AnalyzedTweet.class).getSchemaInfo().getType().toString())
                .runtime(FunctionConfig.Runtime.JAVA)
                .build();
    }

}
