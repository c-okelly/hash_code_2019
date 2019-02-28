package hashcode.model;

import java.util.Objects;
import java.util.Set;


public class Photo {
	
	private final Orientation orientation;
	private final Set<String> tags;
	private final int id;
	
	public Photo(int id, Orientation orientation, Set<String> tags) {
		this.id = id;
		this.orientation = orientation;
		this.tags = tags;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public int getId() {
		return id;
	}

	public Set<String> getTags() {
		return tags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Photo photo = (Photo) o;
		return id == photo.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
