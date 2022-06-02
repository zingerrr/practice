interface Mom {
    void cookCourse();
    void makeDrink();
}

class makeDinner implements Mom {
    public void cookCourse(){

    }
    public void makeDrink(){

    }
}

abstract class Abstraction {
    private Mom imp;
    public Abstraction(Mom _imp){
        this.imp = _imp;
    }
    public void request(){
        this.imp.cookCourse();
    }
    public Mom getImp(){
        return imp;
    }
}

class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Mom _imp) {
        super(_imp);
    }

    @Override
    public void request() {
        /*
         */
        super.request();
        super.getImp().makeDrink();
    }
}
    public class Bridge {
    public static void main(String[] args) {
        Mom imp = new makeDinner();
        Abstraction abs = new RefinedAbstraction(imp);
        abs.request();
    }
}
