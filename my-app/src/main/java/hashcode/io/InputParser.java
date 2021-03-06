package hashcode.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import hashcode.model.Orientation;
import hashcode.model.Photo;

public class InputParser {
	
	public List<Photo> parse(String nameOfFile) throws IOException{
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/" + nameOfFile));
		List<Photo> photos = new ArrayList<>();
		allLines.remove(0);
		int i =0;
		for (String line : allLines) {
			photos.add(buildPhoto(i, line));
			i++;
		}
		return photos;
	}

	private Photo buildPhoto(int i, String line) {
		String[] split = line.split(" ");
		return new Photo(i, Orientation.getOrientation(split[0]), getTags(split));
	}

	private SortedSet<String> getTags(String[] split) {
		SortedSet<String> tags = new TreeSet<>();
		for(int i = 2; i < split.length; i++) {
			tags.add(split[i]);
		}
		return tags;
	}

}
