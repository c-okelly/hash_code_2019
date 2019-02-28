package hashcode.model;

import java.util.Collection;


public class Photo {
	
	private final Orientation orientation;
	private final Collection<String> tags;
	private final int id;
	
	public Photo(int id, Orientation orientation, Collection<String> tags) {
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

	public Collection<String> getTags() {
		return tags;
	}
	

}
