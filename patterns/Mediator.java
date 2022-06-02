abstract class Colleague {
    protected Mediat mediator;
    public Colleague(Mediat mediator) {
        this.mediator = mediator;
    }
    public void send(String message) {
        mediator.send(message, this);
    }
    public abstract void notify(String message);
}

abstract class Mediat {
    public abstract void send(String message, Colleague sender);
}
class ConcColleague1 extends Colleague {
    public ConcColleague1(Mediat mediator) {
        super(mediator);
    }
    @Override
    public void notify(String message) {
        System.out.println("Colleague1 gets message: " + message);
    }
}

class ConcColleague2 extends Colleague {
    public ConcColleague2(Mediat mediator) {
        super(mediator);
    }
    @Override
    public void notify(String message) {
        System.out.println("Colleague2 gets message: " + message);
    }
}

class ConcMediator extends Mediat {
    private ConcColleague1 colleague1;
    private ConcColleague2 colleague2;
    public void setColleague1(ConcColleague1 colleague) {
        this.colleague1 = colleague;
    }
    public void setColleague2(ConcColleague2 colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void send(String message, Colleague sender) {
        if (sender.equals(colleague1)) {
            colleague2.notify(message);
        } else {
            colleague1.notify(message);
        }
    }
}

public class Mediator {
    public static void main(String[] args) {
        ConcMediator m = new ConcMediator();
        ConcColleague1 c1 = new ConcColleague1(m);
        ConcColleague2 c2 = new ConcColleague2(m);
        m.setColleague1(c1);
        m.setColleague2(c2);
        c1.send("How are you?");
        c2.send("Fine, thanks");
    }
}