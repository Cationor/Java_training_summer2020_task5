package epamcourse.homework5.service.impl;

import com.epamcourse.homework5.exception.ProjectInvalidDataException;
import com.epamcourse.homework5.reader.ReadProcessor;
import com.epamcourse.homework5.service.impl.RemoveElementByRegExImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class RemoveElementByRegExImplTest {
    private String sourceText;
    private String resultPunctuationRemovingText;
    private String resultRemoveWordsStartsWithVowelsByLength;

    @BeforeTest
    public void readTexts() throws ProjectInvalidDataException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path punctuationRemovingPath = Paths.
                get("test_texts/PunctuationRemoving");
        this.resultPunctuationRemovingText = reader.
                readLines(punctuationRemovingPath).get(0);
        Path removeWordsStartsWithVowelsByPath = Paths.
                get("test_texts/RemovingWords");
        this.resultRemoveWordsStartsWithVowelsByLength = reader.
                readLines(removeWordsStartsWithVowelsByPath).get(0);
    }

    @Test
    public void testRemovePunctuation() {
        RemoveElementByRegExImpl service = new RemoveElementByRegExImpl();
        String actualText = service.removePunctuation(sourceText);
        assertEquals(actualText, resultPunctuationRemovingText);
    }

    @Test
    public void testRemoveWordsStartsWithVowelsByLength() {
        RemoveElementByRegExImpl service = new RemoveElementByRegExImpl();
        String actualText = service.
                removeWordsStartsWithVowelsByLength(sourceText, 4);
        assertEquals(actualText, resultRemoveWordsStartsWithVowelsByLength);
    }
}