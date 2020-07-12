package epamcourse.homework5.service.impl;

import com.epamcourse.homework5.exception.ProjectInvalidDataException;
import com.epamcourse.homework5.reader.ReadProcessor;
import com.epamcourse.homework5.service.impl.ReplaceElementByStringImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class ReplaceElementByStringImplTest {
    private String sourceText;
    private String expectedChangeWordWithSubStringText;
    private String expectedCorrectWrongLetterText;
    private String expectedEvery5LetterChangeText;

    @BeforeTest
    public void readTexts() throws ProjectInvalidDataException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path changeWordWithSubStringPath = Paths.
                get("test_texts/ChangeWordWithSubString");
        this.expectedChangeWordWithSubStringText = reader.
                readLines(changeWordWithSubStringPath).get(0);
        Path correctWrongLetterPath = Paths.
                get("test_texts/CorrectWrongLetter");
        this.expectedCorrectWrongLetterText = reader.
                readLines(correctWrongLetterPath).get(0);
        Path every5LetterChangePath = Paths.
                get("test_texts/EveryFiveLetterChange");
        this.expectedEvery5LetterChangeText = reader.
                readLines(every5LetterChangePath).get(0);
    }

    @Test
    public void testReplaceEveryKLetter() {
        ReplaceElementByStringImpl service = new ReplaceElementByStringImpl();
        String actualText = service.replaceEveryKLetter(sourceText, 5, "H");
        assertEquals(actualText, expectedEvery5LetterChangeText);
    }

    @Test
    public void testCorrectWrongLetter() {
        ReplaceElementByStringImpl service = new ReplaceElementByStringImpl();
        String actualText = service.correctWrongLetter(sourceText, "no", "nH");
        assertEquals(actualText, expectedCorrectWrongLetterText);
    }

    @Test
    public void testReplaceWordsSelectedByLength() {
        ReplaceElementByStringImpl service = new ReplaceElementByStringImpl();
        String actualText = service.replaceWordsSelectedByLength(
                sourceText,
                3,
                "HHH");
        assertEquals(actualText, expectedChangeWordWithSubStringText);
    }
}