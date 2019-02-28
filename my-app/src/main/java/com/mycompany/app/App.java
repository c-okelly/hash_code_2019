package com.mycompany.app;

import hashcode.model.Orientation;
import hashcode.model.Photo;
import org.neo4j.driver.v1.*;

import java.security.SecureRandom;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;
import static org.neo4j.driver.v1.Values.parameters;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final SecureRandom random = new SecureRandom();
    public static void main( String[] args )
    {

        List<Photo> photos = new ArrayList<>(Arrays.asList(
                new Photo(1, Orientation.HORIZONTAL, new TreeSet<>(asList("cat", "beach", "sun"))),
                new Photo(2, Orientation.VERITCAL, new TreeSet<>(asList("selfie", "smile"))),
                new Photo(3, Orientation.VERITCAL, new TreeSet<>(asList("garden", "selfie"))),
                new Photo(4, Orientation.VERITCAL, new TreeSet<>(asList("garden", "cat")))
                ));


        List<Transition> slideshow = new LinkedList<>();

        Optional<Slide> leftSlide = createSlide(photos);
        leftSlide.orElseThrow(() -> new IllegalStateException());

        while(!photos.isEmpty()) {
            Optional<Slide> rightSlide = createSlide(photos);
            slideshow.add(new Transition(leftSlide.get(), rightSlide.get()));
            leftSlide = rightSlide;
        }
    }

    public static Optional<Slide> createSlide(List<Photo> photos){
        Photo one = photos.remove(random.nextInt(photos.size()));
        if(one.getOrientation() == Orientation.HORIZONTAL){
            return Optional.of(new Slide(one));
        } else {
            Optional<Photo> two = photos.parallelStream()
                                          .filter(photo -> Orientation.VERITCAL.equals(photo.getOrientation()))
                                          .findFirst();
            return two.map(photo -> {
                photos.remove(photo);
                return new Slide(one, photo);
            });
        }
    }
}
