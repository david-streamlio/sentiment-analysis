package io.streamnative.functions.ml;

import java.util.Random;

public class RandomTweetGenerator {

    private static final String[] SENTENCES = {"All they could see was the blue water surrounding their sailboat.\n",
            "Everyone says they love nature until they realize how dangerous she can be.\n",
            "The sight of his goatee made me want to run and hide under my sister-in-law's bed.\n",
            "He invested some skill points in Charisma and Strength.\n",
            "It was obvious she was hot, sweaty, and tired.\n",
            "Please wait outside of the house.\n",
            "The murder hornet was disappointed by the preconceived ideas people had of him.\n",
            "He loved eating his bananas in hot dog buns.\n",
            "There's probably enough glass in my cupboard to build an undersea aquarium.\n",
            "I am never at home on Sundays.\n" ,
            "Three years later, the coffin was still full of Jello.\n" ,
            "I want to buy a onesie… but know it won’t suit me.\n" ,
            "Every manager should be able to recite at least ten nursery rhymes backward.\n" ,
            "He turned in the research paper on Friday; otherwise, he would have not passed the class.\n" ,
            "Sixty-Four comes asking for bread.\n" ,
            "Facing his greatest fear, he ate his first marshmallow.\n" ,
            "My dentist tells me that chewing bricks is very bad for your teeth."};

    private final Random random = new Random();

    public String get() {
       return SENTENCES[random.nextInt(SENTENCES.length)];
    }
}
