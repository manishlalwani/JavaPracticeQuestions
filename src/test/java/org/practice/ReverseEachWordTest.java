package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.questions.ReverseEachWord;

public class ReverseEachWordTest {


    private ReverseEachWord reverseSentence;

    @BeforeEach
    public void setUp(){
        reverseSentence = new ReverseEachWord();
    }

    @Test
    public void verifySingleWordReverseSentence(){
        assertEquals("si",reverseSentence.getReverseSentence("is"));
    }

    @Test
    public void verifyMultipleWordReverseSentence(){
        assertEquals("sihT si ym edoc",reverseSentence.getReverseSentence("This is my code")); // Iterating This is my code
    }

    @Test
    public void verifyMultipleWordWithSpacesReverseSentence(){
        assertEquals("sihT si ym edoc",reverseSentence.getReverseSentence("This is  my   code"));
    }

    @Test
    public void verifyMultipleWordWithSpecialCharacterReverseSentence(){
        assertEquals("!olleH !dlroW",reverseSentence.getReverseSentence("Hello! World!"));
    }

    @Test
    public void verifyMultipleWordAdditonalSpaceReverseSentence(){
        assertEquals("olleH dlroW",reverseSentence.getReverseSentence("  Hello   World   "));
    }

    @Test
    public void verifyMultipleWordOnlyDigitsReverseSentence(){
        assertEquals("1234 4321",reverseSentence.getReverseSentence("4321 1234"));
    }

    @Test
    public void verifyMultipleWordAlphanumericReverseSentence(){
        assertEquals("123a a123",reverseSentence.getReverseSentence("a321 321a"));
    }

    @Test
    public void verifyStringCharacterReverseSentence(){
        assertEquals("c b a",reverseSentence.getReverseSentence("c b a"));
    }

    @Test
    public void verifyNullReverseSentence(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()-> reverseSentence.getReverseSentence(null));
        assertEquals("Sentence cannot be Null",exception.getMessage());
    }

    @Test
    public void verifyEmptyReverseSentence(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()-> reverseSentence.getReverseSentence(""));
        assertEquals("Sentence cannot be Empty",exception.getMessage());
    }

    @Test
    public void verifyEmptyAdditionalSpaceReverseSentence(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()-> reverseSentence.getReverseSentence("   "));
        assertEquals("Sentence cannot be Empty",exception.getMessage());
    }
}
