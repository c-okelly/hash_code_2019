package com.mycompany.app;

import hashcode.io.InputParser;
import hashcode.model.Orientation;
import hashcode.model.Photo;
import hashcode.model.Slide;
import hashcode.model.SlideShow;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final SecureRandom random = new SecureRandom();

    public static void main( String[] args ) throws IOException {
        SlideShow run = run(args[0]);
        System.out.println(run);
    }

    public static SlideShow run(String args) throws IOException {
        InputParser inputParser = new InputParser();
        List<Photo> photos = inputParser.parse(args);
        List<Slide> slides = new LinkedList<>();
        Optional<Slide> leftSlide = createSlide(photos);
        leftSlide.orElseThrow(() -> new IllegalStateException());

        slides.add(leftSlide.get());
        while(!photos.isEmpty()) {
            Optional<Slide> rightSlide = createSlide(photos);
            slides.add(rightSlide.get());
            leftSlide = rightSlide;
        }

        return new SlideShow(slides);
    }

    public static Optional<Slide> createSlide(List<Photo> photos){
        Photo one = photos.remove(random.nextInt(photos.size()));
        if(one.getOrientation() == Orientation.HORIZONTAL){
            return Optional.of(new Slide(one));
        } else {
            Optional<Photo> two = photos.parallelStream()
                                          .filter(photo -> Orientation.VERTICAL.equals(photo.getOrientation()))
                                          .findFirst();
            return two.map(photo -> {
                photos.remove(photo);
                return new Slide(one, photo);
            });
        }
    }
}
