import java.util.*;

public class User {
    private String userId;
    private String name;
    private List<Document> borrowedDocuments;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedDocuments = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowDocument(Document document) {
        if (document.getQuantity() > 0) {
            borrowedDocuments.add(document);
            document.setQuantity(document.getQuantity() - 1);
            System.out.println("Document borrowed: " + document.getTitle());
        } else {
            System.out.println("Document is not available.");
        }
    }
    public void returnDocument(Document document) {
        if (borrowedDocuments.contains(document)) {
            borrowedDocuments.remove(document);
            System.out.println("Document returned: " + document.getTitle());
        } else {
            System.out.print("You don't have this document.");
        }
    }

    public void displayBorrowDocuments() {
        System.out.println("ID:" + userId + " Name:" + name);
        System.out.println("Documents borrowed by " + name + ":");
        for (Document document : borrowedDocuments) {
            System.out.println("-" + document.getTitle());
        }
    }
}
