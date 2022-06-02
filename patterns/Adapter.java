interface USB {
    void connectWithUsbCable();
}

class MemoryCard {
    public void insert() {
        System.out.println("Memory card inserted");
    }
    public void copyData() {
        System.out.println("Data copied");
    }
}

class CardReader implements USB {
    private MemoryCard memoryCard;
    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}

public class Adapter {
    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}
