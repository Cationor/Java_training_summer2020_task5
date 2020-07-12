package com.epamcourse.homework5.service;

public interface ReplaceSymbols {
    String replaceEveryKLetter(String text, int k, String symbol);
    String correctWrongLetter(String text, String incorrectPair, String correctPair);
    String replaceWordsSelectedByLength(String test, int length, String subString);
}
