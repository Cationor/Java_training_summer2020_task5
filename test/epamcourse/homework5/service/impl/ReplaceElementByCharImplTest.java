package epamcourse.homework5.service.impl;

import com.epamcourse.homework5.exception.ProjectInvalidDataException;
import com.epamcourse.homework5.reader.ReadProcessor;
import com.epamcourse.homework5.service.impl.ReplaceElementByCharImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class ReplaceElementByCharImplTest {
    private String sourceText;
    private String resultChangeWordWithSubStringText;
    private String resultCorrectWrongLetterText;
    private String resultEvery5LetterChangeText;

    @BeforeTest
    public void readTexts() throws ProjectInvalidDataException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path changeWordWithSubStringPath = Paths.
                get("test_texts/ChangeWordWithSubString");
        this.resultChangeWordWithSubStringText = reader.
                readLines(changeWordWithSubStringPath).get(0);
        Path correctWrongLetterPath = Paths.
                get("test_texts/CorrectWrongLetter");
        this.resultCorrectWrongLetterText = reader.
                readLines(correctWrongLetterPath).get(0);
        Path every5LetterChangePath = Paths.
                get("test_texts/EveryFiveLetterChange");
        this.resultEvery5LetterChangeText = reader.
                readLines(every5LetterChangePath).get(0);
    }

    @Test
    public void testReplaceEveryKLetter() {
        ReplaceElementByCharImpl service = new ReplaceElementByCharImpl();
        String actualText = service.replaceEveryKLetter(sourceText, 5, "H");
        assertEquals(actualText, resultEvery5LetterChangeText);
    }

    @Test
    public void testReplaceWordsSelectedByLength() {
        ReplaceElementByCharImpl service = new ReplaceElementByCharImpl();
        String actualText = service.replaceWordsSelectedByLength(sourceText, 3, "HHH");
        assertEquals(actualText, resultChangeWordWithSubStringText);
    }

    @Test
    public void testCorrectWrongLetter() {
        ReplaceElementByCharImpl service = new ReplaceElementByCharImpl();
        String actualText = service.correctWrongLetter(
                sourceText,
                "no",
                "nH");
        assertEquals(actualText, resultCorrectWrongLetterText);
    }
}