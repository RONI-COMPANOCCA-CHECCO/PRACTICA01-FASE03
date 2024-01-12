import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Editorial {
	private String name;
    private String webPage;
    private boolean status;
    private ArrayList<Article> articles;
    private ArrayList<Branch> branches;
    private ArrayList<Author> authors;
    private Map<Author, List<Book>> authorBooks;

	public Editorial(String name) {
        this.name = name;
        this.articles = new ArrayList<>();
        this.branches = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.authorBooks = new HashMap<>();
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebPage() {
		return webPage;
	}
	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean addArticle(Article article) {
        if (articles.contains(article)) {
            return false;
        } else {
            this.articles.add(article);

            if (article instanceof Book) {
                Author author = ((Book) article).getAuthor();
                if (!authors.contains(author)) {
                    authors.add(author);
                }

                // Almacenar el libro bajo el autor
                authorBooks.computeIfAbsent(author, k -> new ArrayList<>()).add((Book) article);
            }

            return true;
        }
    }

	public boolean addBranch(Branch branch) {
        if (branches.contains(branch)) {
            return false;
        } else {
            branches.add(branch);
            return true;
        }
    }	
	
	public boolean searchBooks(String code) {
		for(int i=0;i<articles.size();i++) {
			if(articles.get(i).getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<Article> getArticles() {
		return articles;
	}
	
	public void printArticles() {
		for (Article article : articles) {
            System.out.println("Editorial: " + this.getName());
            System.out.println("------------------------");
            System.out.println("Código: " + article.getCode());
            System.out.println("Título: " + article.getTitle());
            System.out.println("Páginas: " + article.getPages());
            System.out.println("Autor: " + ((Book) article).getAuthor().getName());
            System.out.println("\n");

            /*if (article instanceof Book) {
                System.out.println("ISBN: " + ((Book) article).getISBN());
                System.out.println("Autor: " + ((Book) article).getAuthor().getName());
            } else if (article instanceof Thesis) {
              
            } else if (article instanceof Journal) {
     
            }*/
   
        }
		
	}
    public void printAuthorBooks() {
        System.out.println("\n----Libros por Autor:----");

        for (Author author : authorBooks.keySet()) {
            System.out.println("Autor: " + author.getName());
            List<Book> books = authorBooks.get(author);
            
            for (Book book : books) {
                System.out.println(" - Libro: " + book.getTitle());
            }
        }
    }
		
}