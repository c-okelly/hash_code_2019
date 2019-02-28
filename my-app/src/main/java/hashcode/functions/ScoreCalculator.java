package hashcode.functions;

import java.util.List;

public class ScoreCalculator {
	
	private static int neighbourScore(List<String> slide1Tags, List<String> slide2Tags) {
		int commonTags = 0;
		int aSubB = 0;
		int bSubA = 0;
		
		for(String tag1 : slide1Tags) {
			for(String tag2 : slide2Tags) {
				if(tag1.equals(tag2)) {
					commonTags++;
				}
				if(!slide1Tags.contains(tag2)) {
					aSubB++;
				}
			}
			if(!slide2Tags.contains(tag1)) {
				bSubA++;
			}
		}
		
		return Math.min(commonTags, Math.min(aSubB, bSubA));
	}

}
