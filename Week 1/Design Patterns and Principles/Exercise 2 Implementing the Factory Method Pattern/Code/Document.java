public interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("A word document is opening.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("A pdf document is opening.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("An excel document is opening.");
    }
}
