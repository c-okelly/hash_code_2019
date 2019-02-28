package hashcode.model;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Slide {

	private Photo one;
	private Optional<Photo> two = Optional.empty();
	private Set<String> tags;

	public Slide(Photo horizontal){
		super();
		if(horizontal.getOrientation() != Orientation.HORIZONTAL){
			throw new IllegalArgumentException();
		}
		this.one = horizontal;
		this.tags = one.getTags();
	}

	public Slide(Photo one, Photo two){
		super();
		if(one.getOrientation() != Orientation.VERTICAL || two.getOrientation() != Orientation.VERTICAL){
			throw new IllegalArgumentException();
		}
		this.one = one;
		this.tags = new TreeSet<>(one.getTags());
		this.two = Optional.of(two);

		this.two.ifPresent(photo -> tags.addAll(photo.getTags()));
	}

	public Set<String> tags() {
		return this.tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(one.getId());
		two.ifPresent(photo -> builder.append(" ").append(photo.getId()));
		return builder.toString().trim();
	}

	public Photo getOne() {
		return one;
	}

	public Optional<Photo> getTwo() {
		return two;
	}
}
