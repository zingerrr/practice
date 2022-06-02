interface Stt {
    void doAction(Context context);
}

class StartState implements Stt {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
    public String toString(){
        return "Start State";
    }
}

class StopState implements Stt {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
    public String toString(){
        return "Stop State";
    }
}

class Context {
    private Stt state;
    public Context(){
        state = null;
    }
    public void setState(Stt state){
        this.state = state;
    }
    public Stt getState(){
        return state;
    }
}

public class State {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());
        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}