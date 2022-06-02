abstract class Cup {
    abstract void volume();
}

interface Color {
    void color();
}

class Red implements Color {

    @Override
    public void color() {
        System.out.print("red color");
    }
}

class Yellow implements Color {

    @Override
    public void color() {
        System.out.print("yellow color");
    }
}

class Cup300ml extends Cup {
    private Color mColor;
    public void volume() {
        System.out.print("300ml cup ");
        mColor.color();
    }
    public Cup300ml(Color c) {
        mColor = c;
    }
}
class Cup500ml extends Cup {
    private Color mColor;
    public void volume() {
        System.out.print("500ml cup ");
        mColor.color();
    }
    public Cup500ml(Color c) {
        mColor = c;
    }
}
class Cup700ml extends Cup {
    private Color mColor;
    public void volume() {
        System.out.print("700ml cup ");
        mColor.color();
    }
    public Cup700ml(Color c) {
        mColor = c;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Red red = new Red();
        Yellow yellow = new Yellow();
        Cup300ml cup300 = new Cup300ml(red);
        Cup500ml cup500 = new Cup500ml(yellow);
        cup300.volume();
        cup500.volume();
    }
}
