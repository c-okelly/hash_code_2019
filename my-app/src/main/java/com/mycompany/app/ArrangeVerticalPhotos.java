package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hashcode.model.Orientation;
import hashcode.model.Photo;
import hashcode.model.Tag;

public class ArrangeVerticalPhotos {
	
	public List<Photo> getVerticalPhotosSlides(List<Photo> photos) {
		List<Photo> verticalPhotos = getVerticalPhotos(photos);
		return arrangeVerticalPhotos(verticalPhotos);
	}
	
	private List<Photo> arrangeVerticalPhotos(List<Photo> verticalPhotos) {
		Collections.shuffle(verticalPhotos);
		List<Slide> verticalPhotosSlides = new ArrayList<>();
		for(int i = 0; i < verticalPhotos.size(); i+=2) {
			Slide verticalPhotosSlide = getSlide(verticalPhotos.get(i), verticalPhotos.get(i+1);
			verticalPhotosSlides.add(verticalPhotosSlide);
		}
		return verticalPhotosSlides;
	}

	private Slide getSlide(Photo photo1, Photo photo2) {

	}

	public List<Photo> getVerticalPhotos(Collection<Photo> photos) {
		return photos.stream().filter(photo -> isVerticalPhoto(photo)).collect(Collectors.toList());
	}

	private Boolean isVerticalPhoto(Photo photo) {
		return photo.getOrientation().equals(Orientation.VERITCAL);
	}
	
}
