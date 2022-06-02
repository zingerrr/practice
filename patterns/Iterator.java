interface Aggregate {
    abstract Iter iter();
}

interface Iter {
    abstract boolean hasNext();
    abstract Object next();
}


class Book {
    private String name = "";
    public Book(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}


class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;
    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return books.length;
    }

    public Iter iter() {
        return new BookShelfIterator(this);
    }

}

class BookShelfIterator implements Iter {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        if(index < bookShelf.getLength()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index ++;
        return book;
    }
}

public class Iterator {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);

        bookShelf.appendBook (new Book("Moby Dick"));
        bookShelf.appendBook (new Book("The Great Gatsby"));
        bookShelf.appendBook (new Book("The Divine Comedy"));

        Iter it = bookShelf.iter();
        while(it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
