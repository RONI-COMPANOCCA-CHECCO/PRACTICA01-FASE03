public class Book extends Article {
	private String ISBN;
	private Author author;
	
    public Book(String code, String title, Author author, int pages) {
        super(code, title);
        super.setType((byte) 1);
        this.author = author;
        this.setPages(pages); 
    }
	
	//public Book(String code, String title, int pages) {
		//super(code,title,pages);
		//super.setType((byte) 1);
	//}
    public String getCode() {
        return code;
    }
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
		
}