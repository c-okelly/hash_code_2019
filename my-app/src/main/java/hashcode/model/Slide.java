package hashcode.model;

import java.util.Collection;

public class Slide {

	private Collection<Photo> photos;

	public Slide(Collection<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		photos.stream().forEach(photo -> builder.append(photo.getId() + " "));
		return builder.toString().trim();
	}
	
	
}
