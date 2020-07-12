package com.epamcourse.homework5.service;

public interface RemoveSymbols {
    String removePunctuation(String text);
    String removeWordsStartsWithVowelsByLength(String text, int length);
}
