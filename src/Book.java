class Book {
    private String title;
    private String author;
    private int id;
    private int year;
    private boolean isAvailable;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public int getId () {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayDetails() {
        System.out.println("Book Details - Title: " + title + ", Author: " + author + ", ID: " + id + ", Year: " + year);
    }
}
