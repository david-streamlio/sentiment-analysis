package io.streamnative.functions.ml;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

import java.util.Properties;

public class SentimentAnalysisFunction implements Function<String, AnalyzedTweet> {

    static StanfordCoreNLP pipeline;

    boolean initalized = false;

    public void initialize(Context context) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
        initalized = true;
    }

    @Override
    public AnalyzedTweet process(String tweet, Context ctx) throws Exception {

        if (!initalized) {
            initialize(ctx);
        }

        int mainSentiment = 0;
        String sentimentType = "NULL";
        if (tweet != null && tweet.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(tweet);
            for (CoreMap sentence : annotation
                    .get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence
                        .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            }
        }

        return new AnalyzedTweet(tweet, sentimentType);
    }
}
