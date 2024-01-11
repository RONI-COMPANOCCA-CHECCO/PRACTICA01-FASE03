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
    private Map<String, List<Author>> nameToAuthors; // Mapeo de nombres de autor a lista de autores
    private Map<Author, List<Book>> authorBooks;	
	public Editorial(String name) {
		this.name = name;
        this.articles = new ArrayList<>();
        this.branches = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.nameToAuthors = new HashMap<>();
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
                String authorName = author.getName();

                // Si el nombre del autor ya existe, verificar si es un autor diferente
                if (nameToAuthors.containsKey(authorName)) {
                    List<Author> authorsWithSameName = nameToAuthors.get(authorName);
                    boolean isNewAuthor = true;

                    for (Author existingAuthor : authorsWithSameName) {
                        if (existingAuthor.getCode().equals(author.getCode())) {
                            isNewAuthor = false;
                            author = existingAuthor;
                            break;
                        }
                    }

                    if (isNewAuthor) {
                        authors.add(author);
                        authorsWithSameName.add(author);
                    }
                } else {
                    // Si el nombre del autor no existe, agregar el nuevo autor
                    authors.add(author);
                    List<Author> newAuthorList = new ArrayList<>();
                    newAuthorList.add(author);
                    nameToAuthors.put(authorName, newAuthorList);
                }

                // Almacenar el libro bajo el autor
                authorBooks.computeIfAbsent(author, k -> new ArrayList<>()).add((Book) article);
            }

            return true;
        }
    }
	public void clearBooks() {
		this.articles.clear();
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
		for(int i=0;i<articles.size();i++) {
			System.out.println("Editorial : " + this.getName());
			System.out.println("------------------------");
			System.out.println("Codigo : " + articles.get(i).getCode());
			System.out.println("Titulo : " + articles.get(i).getTitle());
			System.out.println("Paginas : " + articles.get(i).getPages());
			System.out.println("\n");
		}
		
	}
	public void printAuthorBooks() {
        System.out.println("Libros por Autor:");

        for (Author author : authorBooks.keySet()) {
            System.out.println("Autor: " + author.getName());
            List<Book> books = authorBooks.get(author);
            
            for (Book book : books) {
                System.out.println(" - Libro: " + book.getTitle());
            }
        }
    }
	public void printAuthorsWithSameName() {
        System.out.println("Autores con el mismo nombre:");

        for (String authorName : nameToAuthors.keySet()) {
            List<Author> authorsWithSameName = nameToAuthors.get(authorName);
            if (authorsWithSameName.size() > 1) {
                System.out.println("Nombre: " + authorName);

                for (Author author : authorsWithSameName) {
                    System.out.println(" - ID: " + author.getCode());
                }
            }
        }
    }
		
}