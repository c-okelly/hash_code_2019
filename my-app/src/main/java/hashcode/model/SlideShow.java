package hashcode.model;

import java.util.Collection;

public class SlideShow {

	private Collection<Slide> slides;

	public SlideShow(Collection<Slide> slides) {
		this.slides = slides;	
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(slides.size()).append("\n");
		slides.stream().forEach(slide -> builder.append(slide.toString()).append("\n"));
		return builder.toString();
	}
	
	
}
