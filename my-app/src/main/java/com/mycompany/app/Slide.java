package com.mycompany.app;

import hashcode.model.Orientation;
import hashcode.model.Photo;

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
        if(one.getOrientation() != Orientation.VERITCAL || two.getOrientation() != Orientation.VERITCAL){
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
}
