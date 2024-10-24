import java.util.*;

public class Library {
    private List<Document> documents;
    private List<User> users;
    public Library() {
        documents = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
        System.out.println("Document added: " + document.getTitle());
    }

    public void removeDocument(Document document) {
        documents.remove(document);
        System.out.println("Document removed: " + document.getTitle());
    }

    public Document findDocumentById (String id) {
        for (Document document : documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        System.out.println("Document not found with ID: " + id);
        return null;
    }

    public Document findDocumentByTitle (String title) {
        for (Document document : documents) {
            if (document.getTitle().equals(title)) {
                return document;
            }
        }
        System.out.println("Document not found with title: " + title);
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added " + user.getName());
    }

    public User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        System.out.println("User not found with ID: " + userId);
        return null;
    }

    public void displayDocuments() {
        System.out.println("Documents in Library:");
        for (Document doc : documents) {
            doc.printInfo();
        }
    }

    public void displayUsers() {
        System.out.println("Library Users:");
        for (User user : users) {
            user.displayBorrowDocuments();
        }
    }
}
