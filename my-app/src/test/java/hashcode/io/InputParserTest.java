package hashcode.io;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import hashcode.model.Photo;

public class InputParserTest {

	@Test
	public void parse() throws IOException{
		InputParser parser = new InputParser();
		List<Photo> photos = parser.parse("a_example.txt");
		System.out.println(photos);
	}

}
