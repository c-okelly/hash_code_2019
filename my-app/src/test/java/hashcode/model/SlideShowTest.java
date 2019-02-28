package hashcode.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class SlideShowTest {

	@Test
	public void test() {
		SlideShow slideShow = new SlideShow(newSlides(2));
		System.out.println(slideShow);
	}

	private Collection<Slide> newSlides(int numberOfSlides) {
		List<Slide> slides = new ArrayList<>();

		for(int i = 0; i < numberOfSlides; i++) {
//			slides.add(new Slide(newPhotos(2, Orientation.VERTICAL)));
//			slides.add(new Slide(newPhotos(1, Orientation.HORIZONTAL)));
		}
		return slides;


	}

	private Collection<Photo> newPhotos(int numberOfPhotos, Orientation orientation) {
		List<Photo> photos = new ArrayList<>();
		for(int i = 0; i < numberOfPhotos; i++) {
			photos.add(new Photo(i, orientation, null));
		}
		
		return photos;
	}
	
}
