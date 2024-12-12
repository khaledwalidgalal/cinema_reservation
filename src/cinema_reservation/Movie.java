// Movie.java
package cinema_reservation;

import java.util.ArrayList;

public class Movie implements MovieSubjet {
    private int movieID;
    private String title;
    private float duration;
    private String genre;
    private int hallNumber;
    private int lightingIntensity;
    private int framerate;
    private String moviename;
    private double price;
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<String> showtimes; // To store showtimes

    public Movie(int movieID, String title, float duration, String genre, int hallNumber, 
                 int lightingIntensity, int framerate, String moviename, double price) {
        this.movieID = movieID;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.hallNumber = hallNumber;
        this.lightingIntensity = lightingIntensity;
        this.framerate = framerate;
        this.moviename = moviename;
        this.price = price;
        this.showtimes = new ArrayList<>(); // Initialize the showtimes list
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getLightingIntensity() {
        return lightingIntensity;
    }

    public void setLightingIntensity(int lightingIntensity) {
        this.lightingIntensity = lightingIntensity;
    }

    public int getFramerate() {
        return framerate;
    }

    public void setFramerate(int framerate) {
        this.framerate = framerate;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    // ... (Getters and Setters) ...
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers("price_change"); 
    }

    public void addShowtime(String showtime) {
        this.showtimes.add(showtime); 
        System.out.println("Showtime '" + showtime + "' added for " + title);
        notifyObservers("showtime_added");
    }

    public ArrayList<String> getShowtimes() {
        return showtimes;
    }

    // MovieSubject interface methods
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String updateType) {
        for (Observer observer : observers) {
            observer.update(updateType, this); 
        }
    }
}