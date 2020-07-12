package com.epamcourse.homework5.service.impl;

import com.epamcourse.homework5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveElementByRegExImpl implements RemoveSymbols {
    private final String PUNCTUATION_BETWEEN_LETTERS = "\\w\\p{Punct}\\w";
    private final String PUNCTUATION = "\\p{Punct}";
    private final String WORD_STARTS_WITH_VOWEL_WITH_LENGTH =
            "(?<=\\b)[eyuioa]\\w{%d}(?!\\w)";

    @Override
    public String removePunctuation(@NotNull String text) {
        Pattern patternBetweenWords = Pattern.compile
                (PUNCTUATION_BETWEEN_LETTERS);
        Matcher matcherBetweenWords = patternBetweenWords.matcher(text);
        String processingText = matcherBetweenWords.replaceAll(" ");
        Pattern patternClearPunctuation = Pattern.compile(PUNCTUATION);
        Matcher matcherCrearPunctuation = patternClearPunctuation.
                matcher(processingText);
        return matcherCrearPunctuation.replaceAll("");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text,
                                                      int length) {
        Pattern pattern = Pattern.compile
                (String.format(WORD_STARTS_WITH_VOWEL_WITH_LENGTH, length - 1),
                        Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
}
