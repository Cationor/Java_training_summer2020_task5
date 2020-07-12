package com.epamcourse.homework5.service.impl;

import com.epamcourse.homework5.service.ReplaceSymbols;
import org.jetbrains.annotations.NotNull;

public class ReplaceElementByStringImpl implements ReplaceSymbols {
    private final String EVERY_K_LETTER = "(?<=\\b\\w{%d})[\\w]";
    private final String WORD_WITH_LENGTH = "(?<=\\b)\\w{%d}(?!\\w)";

    @Override
    public String replaceEveryKLetter(@NotNull String text, int k, String symbol) {
        String regEx = String.format(EVERY_K_LETTER, k - 1);
        return text.replaceAll(
                regEx,
                symbol);
    }

    @Override
    public String correctWrongLetter(@NotNull String text,
                                     @NotNull String incorrectPair,
                                     @NotNull String correctPair) {
        return text.replaceAll(incorrectPair, correctPair);
    }

    @Override
    public String replaceWordsSelectedByLength(@NotNull String text, int length,
                                               @NotNull String subString) {
        String regEx = String.format(WORD_WITH_LENGTH, length);
        return text.replaceAll(
                    regEx,
                    subString);
    }
}
