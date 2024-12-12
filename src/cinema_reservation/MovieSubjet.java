package cinema_reservation;

public interface MovieSubjet {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String updateType); 
}
