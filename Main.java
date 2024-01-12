public class Main {
    public static void main(String[] args) {
        Editorial e1 = new Editorial("UNIVERSIDAD");
        Author author1 = new Author("Robert C. Martin");
        Author author2 = new Author("Marijn Haverbeke");
        Author author3 = new Author("Kyle Simpson");
        Book b1 = new Book("F23-678","Clean Code", author1, 358);
        Book b2 = new Book("F78-098","Eloquent JavaScript", author2, 250);
        b2.setISBN("978-612-00-0855-3");
        Book b3 = new Book("F67-908","You dont know JavaScript", author3, 410);
        Book b4 = new Book("K58-098","Clean Agile: Back to Basics", author1, 350);
        Book b5 = new Book("K68-098","Agile Software Development", author1, 950);
        Thesis t1 = new Thesis("THESIS-ISIS-01", "Modelo de Analisis del sentimiento en la Red Social Facebook usando Redes Neuronales", 118);
        Journal j1 = new Journal("JOURNAL-ISIS-01", "Revista de la Escuela Profesional de Ingenieria de Sistemas", 80);

        Branch branch1 = new Branch("BRANCH-001", "Sucursal A", "Direccion A");
        Branch branch2 = new Branch("BRANCH-002", "Sucursal B", "Direccion B");
        Branch branch3 = new Branch("BRANCH-003", "Sucursal C", "Direccion C");
        Branch branch4 = new Branch("BRANCH-004", "Sucursal D", "Direccion D");

        System.out.println((e1.addArticle(b1)) ? "Exito" : "Fracaso");
        System.out.println((e1.addArticle(b2)) ? "Exito" : "Fracaso");
        System.out.println((e1.addArticle(b3)) ? "Exito" : "Fracaso");
        System.out.println((e1.addArticle(b4)) ? "Exito" : "Fracaso");
        System.out.println((e1.addArticle(b5)) ? "Exito" : "Fracaso");
        e1.printArticles();
        
        branch1.addBookCopy(b1, 5);
        branch1.addBookCopy(b2, 3);
        branch1.addBookCopy(b3, 7);
        branch1.addBookCopy(b4, 12);
        branch2.addBookCopy(b1, 7);
        branch2.addBookCopy(b2, 2);
        branch2.addBookCopy(b3, 8);
        branch2.addBookCopy(b5, 18);
        branch3.addBookCopy(b1, 7);
        branch3.addBookCopy(b2, 2);
        branch3.addBookCopy(b3, 8);
        branch3.addBookCopy(b4, 17);
        branch4.addBookCopy(b1, 7);
        branch4.addBookCopy(b2, 2);
        branch4.addBookCopy(b3, 8);
        branch4.addBookCopy(b4, 13);
        branch4.addBookCopy(b5, 21);
        
        System.out.println("---INFORMACION DE LAS SUCURSALES---");
        System.out.println("--------------------");
        System.out.println("--------------------");
        branch1.printBranchInfo();
        System.out.println("\n");
        branch2.printBranchInfo();
        System.out.println("\n");
        branch3.printBranchInfo();
        System.out.println("\n");
        branch4.printBranchInfo();
        
        e1.printAuthorBooks();
    }
}
