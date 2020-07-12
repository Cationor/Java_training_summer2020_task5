package com.epamcourse.homework5.service.impl;

import com.epamcourse.homework5.service.ReplaceSymbols;
import org.jetbrains.annotations.NotNull;

public class ReplaceElementByCharImpl implements ReplaceSymbols {
    @Override
    public String replaceEveryKLetter(@NotNull String text, int k,
                                      @NotNull String symbol) {
        char castedSymbol = symbol.charAt(0);
        int begin = 0;
        char[] castedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if ((castedText[i] == ' ') ||
                    (castedText[i] == ',') ||
                    (castedText[i] == '.') ||
                    (castedText[i] == '!')) {
                begin = i + 1;
            }

            if ((i - begin) == k - 1) {
                castedText[i] = castedSymbol;
            }
        }

        return new String(castedText);
    }

    @Override
    public String replaceWordsSelectedByLength(@NotNull String text, int length,
                                               String subString) {
        char[] castedText =
                text.toCharArray();
        int begin = 0;
        for (int i = 0; i < text.length(); i++) {
            if ((castedText[i] == ' ') ||
                    (castedText[i] == ',') ||
                    (castedText[i] == '.') ||
                    (castedText[i] == '!')) {
                begin = i + 1;
            }

            if ((i - begin == length - 1) && (
                    (castedText[i + 1] == ' ') ||
                    (castedText[i + 1] == ',') ||
                    (castedText[i + 1] == '.') ||
                    (castedText[i + 1] == '!'))) {
                int distinction = subString.length() - length;
                char[] textWithSubString = new char
                        [text.length() + distinction];
                if (begin >= 0) {
                    System.arraycopy(castedText, 0, textWithSubString, 0, begin);
                }
                for (int j = 0; j < subString.length(); j++) {
                    textWithSubString[begin + j] = subString.charAt(j);
                }
                for (int j = i + 1;
                     j < text.length() + distinction;
                     j++) {
                    textWithSubString[j] = text.
                            charAt(j + distinction);
                }

                castedText = textWithSubString;
            }
        }

        return new String(castedText);
    }

    @Override
    public String correctWrongLetter(@NotNull String text, String incorrectPair, String correctPair) {
        char[] castedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if ((castedText[i] == incorrectPair.charAt(0)) &&
                    (castedText[i + 1] == incorrectPair.charAt(1))) {
                castedText[i] = correctPair.charAt(0);
                castedText[i + 1] = correctPair.charAt(1);
                i++;
            }
        }

        return new String(castedText);
    }
}
