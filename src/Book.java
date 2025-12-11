class Book {
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.available = true;
        this.id = idGen++;
    }

    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author must not be null or empty");
        }
        this.author = author;
    }

    public void setYear(int year) {
        if (year <= 1500 || year >= 2025) {
            throw new IllegalArgumentException("Year must be in a reasonable range");
        }
        this.year = year;
    }

    public void setAvailable(boolean available) {           //Как будто это не надо добавлять, потому что сет авейлабл будет плохой идеей для реального использования(т.е. с помощью чего-то стороннего можно будет вернуть книгу, даже если она не возвращена)
        this.available = available;
    }

    public void markAsBorrowed() {
        setAvailable(false);        //или this.available = false; (ниже так же)
    }

    public void markAsReturned() {
        setAvailable(true);
    }

    @Override
    public String toString() {
        return "Book: id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", available=" + available;
    }
}