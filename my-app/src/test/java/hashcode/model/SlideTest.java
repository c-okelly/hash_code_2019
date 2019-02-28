package hashcode.model;

import org.junit.Test;

public class SlideTest {

	@Test
	public void testPhotoOutput() {
		Photo photo1 = new Photo(1, Orientation.VERTICAL, null);
		Photo photo2 = new Photo(2, Orientation.VERTICAL, null);
		Slide slide = new Slide(photo1, photo2);
		System.out.println(slide.toString());
	}
	
}
