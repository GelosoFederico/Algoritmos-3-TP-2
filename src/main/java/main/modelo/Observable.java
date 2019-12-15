package main.modelo;

import java.util.ArrayList;

public abstract class Observable {
    private ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}