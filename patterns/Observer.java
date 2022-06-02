import java.util.ArrayList;
import java.util.List;

interface Observerable {
    void attachObserver(Observ observer);
    void removeObserver(Observ observer);
    void notifyObserver();
}

interface Observ {
    void receiveContent(String info);
}

class ChainSubject implements Observerable{
    private List<Observ> observers = new ArrayList<>();
    private String message;
    @Override
    public void attachObserver(Observ observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observ observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observ observer : observers) {
            observer.receiveContent(message);
        }
    }
    public boolean isAttchObserver(Observ observer) {
        return observers.contains(observer);
    }
    public void submitContent(String updateContent) {
        this.message = updateContent;
        this.notifyObserver();
    }

}

class ReaderObserver implements Observ{
    private String name;
    public ReaderObserver(String name) {
        this.name = name;
    }
    @Override
    public void receiveContent(String info) {
        System.out.println(name + "got it" + info);
    }
    public String getUname() {
        return this.name;
    }
}

public class Observer {
    public static void main(String[] args) {
        ChainSubject chainSubject = new ChainSubject();
        ReaderObserver John = new ReaderObserver("John");
        ReaderObserver Max = new ReaderObserver("Max");
        ReaderObserver Elizabeth = new ReaderObserver("Elizabeth");
        chainSubject.attachObserver(John);
        chainSubject.attachObserver(Max);
        chainSubject.submitContent("Hi!");
        boolean attch = chainSubject.isAttchObserver(Elizabeth);
        if(!attch) {
            System.out.println(Elizabeth.getUname() + "unsubscribe");
        }
    }
}

