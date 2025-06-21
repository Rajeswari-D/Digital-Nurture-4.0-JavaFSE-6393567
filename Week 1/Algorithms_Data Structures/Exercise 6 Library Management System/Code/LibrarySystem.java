import java.util.*;

class Book {
    String bookId;
    String title;
    String author;

    Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

public class LibrarySystem {
    
    // Linear search
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search (assumes list is sorted)
    public static Book binarySearch(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = books.get(mid);
            int result = midBook.title.compareToIgnoreCase(title);

            if (result == 0) {
                return midBook;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("B101", "The Alchemist", "Paulo Coelho"));
        books.add(new Book("B102", "Atomic Habits", "James Clear"));
        books.add(new Book("B103", "The Power of Now", "Eckhart Tolle"));
        books.add(new Book("B104", "Ikigai", "Hector Garcia"));

        Scanner sc = new Scanner(System.in);

        // Unsorted list for linear search
        System.out.print("Enter book title to search (Linear Search): ");
        String searchTitle1 = sc.nextLine();
        Book result1 = linearSearch(books, searchTitle1);
        if (result1 != null) result1.display();
        else System.out.println("Book not found.");

        // Sort list by title for binary search
        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.print("\nEnter book title to search (Binary Search): ");
        String searchTitle2 = sc.nextLine();
        Book result2 = binarySearch(books, searchTitle2);
        if (result2 != null) result2.display();
        else System.out.println("Book not found.");

        sc.close();
    }
}
