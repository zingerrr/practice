class SingletonEx {
    private static SingletonEx instance;
    public String value;

    private SingletonEx(String value) {
        // Этот код эмулирует медленную инициализацию.
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
        System.out.println("If you see the same value, then singleton was reused" + "\n" +
                "If you see different values, then 2 singletons were created" + "\n\n" +
                "RESULT:" + "\n");
        SingletonEx singleton = SingletonEx.getInstance("FOO");
        SingletonEx anotherSingleton = SingletonEx.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}