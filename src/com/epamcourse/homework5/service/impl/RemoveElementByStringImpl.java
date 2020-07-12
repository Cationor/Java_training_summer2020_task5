package com.epamcourse.homework5.service.impl;

import com.epamcourse.homework5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

public class RemoveElementByStringImpl implements RemoveSymbols {
    private final String PUNCTUATION_BETWEEN_LETTERS = "\\w\\p{Punct}\\w";
    private final String PUNCTUATION = "\\p{Punct}";
    private final String WORD_STARTS_WITH_VOWEL_WITH_LENGTH =
            "(?<=\\b)[eyuioa]\\w{%d}(?!\\w)";

    @Override
    public String removePunctuation(@NotNull String text) {
        String processingText = text.replaceAll(
                PUNCTUATION_BETWEEN_LETTERS, " ");
        return processingText.replaceAll(PUNCTUATION, "");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text,
                                                      int length) {
        String regEx = String.
                format(WORD_STARTS_WITH_VOWEL_WITH_LENGTH, length - 1);
        return text.replaceAll(regEx, "");
    }
}
