package test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArticleDAOTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        
    }

	@Test
	public void getArticlesTest() {
		assertTrue(true);
	}
	
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
