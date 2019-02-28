package com.mycompany.app;

import hashcode.io.InputParser;
import hashcode.model.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

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
        Map<Integer,Photo> photos = inputParser.parse(args).
                stream().collect(Collectors.toMap(Photo::getId, o -> o));


        List<Slide> slides = new LinkedList<>();

        List<Photo> iteration = new ArrayList<>(photos.values());
        Optional<Slide> leftSlide = createSlide(iteration);
        leftSlide.orElseThrow(() -> new IllegalStateException());
        slides.add(leftSlide.get());

        while(!iteration.isEmpty()) {
            List<Photo> photos1 = new ArrayList<>(iteration);
            Optional<Slide> rightSlide = createSlide(photos1);
            int idealScore = leftSlide.get().tags().size()/3;
            Optional<Slide> maxSlide = rightSlide;
            int maxScore = 0;
            int score = Transition.score(leftSlide.get(), maxSlide.get());
            while(score < idealScore && !photos1.isEmpty()){
                rightSlide = createSlide(photos1);
                score = Transition.score(leftSlide.get(), rightSlide.get());
                if(maxScore < score){
                    maxScore = score;
                    maxSlide = rightSlide;
                }
            }


            Slide max = maxSlide.get();
            photos.remove(max.getOne().getId());
            max.getTwo().ifPresent(photo -> photos.remove(photo.getId()));

            slides.add(maxSlide.get());
            leftSlide = maxSlide;
            iteration = new ArrayList<>(photos.values());
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
