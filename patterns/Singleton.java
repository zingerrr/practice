class SingletonEx {
    private static SingletonEx instance;
    public String value;

    private SingletonEx(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonEx getInstance(String value) {
        if (instance == null) {
            instance = new SingletonEx(value);
        }
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args) {
        System.out.println("same value - singleton was reused" + "\n" +
                "different values - 2 singletons were created" + "\n\n" +
                "RESULT:" + "\n");
        SingletonEx singleton = SingletonEx.getInstance("FOO");
        SingletonEx anotherSingleton = SingletonEx.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}