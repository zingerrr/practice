interface Com {
    void com();
}

class OnCommand implements Com {
    private Reciver reciver;
    public OnCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void com() {
        reciver.on();
    }
}

class OffCommand implements Com {
    private Reciver reciver;
    public OffCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void com() {
        reciver.off();
    }
}

interface Reciver {
    void on();
    void off();
}

class ConcReciver implements Reciver{

    @Override
    public void on() {
        System.out.println("ON");
    }

    @Override
    public void off() {
        System.out.println("OFF");
    }
}

class Invoker {
    private Com com;
    public void setCommand(Com com) {
        this.com = com;
    }
    public void excute() {
        com.com();
    }
}

public class Command {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new OnCommand(new ConcReciver()));
        invoker.excute();
        invoker.setCommand(new OffCommand(new ConcReciver()));
        invoker.excute();
    }
}


