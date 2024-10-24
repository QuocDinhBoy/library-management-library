import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Library Management System!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add Document");
            System.out.println("[2] Remove Document");
            System.out.println("[3] Update Document");
            System.out.println("[4] Find Document");
            System.out.println("[5] Display Document");
            System.out.println("[6] Add User");
            System.out.println("[7] Borrow Document");
            System.out.println("[8] Return Document");
            System.out.println("[9] Display User Info");
            System.out.println("Choose an action: ");

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    running = false;
                    System.out.println("Exiting The System...");
                    break;
                case 1:
                    System.out.print("Enter Document ID: ");
                    String docId = scanner.nextLine();
                    System.out.print("Enter Document Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter  Quantity: ");
                    int quantity = scanner.nextInt();
                    library.addDocument(new Document(docId,title,author, quantity));
                    break;
                case 2:
                    System.out.print("Enter Document ID to remove: ");
                    String removeId = scanner.nextLine();
                    Document docRemoved = library.findDocumentById(removeId);
                    if(docRemoved != null) {
                        library.removeDocument(docRemoved);
                    }
                    break;
                case 3:
                    System.out.println("Enter Document ID To Update: ");
                    String updateId = scanner.nextLine();
                    Document docUpdate = library.findDocumentById(updateId);
                    if (docUpdate != null) {
                        System.out.println("[1] Update Title");
                        System.out.println("[2] Update Quantity");

                        int action0 = scanner.nextInt();
                        scanner.nextLine();

                        switch (action0) {
                            case 1:
                                System.out.print("Enter New Title: ");
                                String newTitle = scanner.nextLine();
                                docUpdate.setTitle(newTitle);
                                break;
                            case 2:
                                System.out.print("Enter New Quantity: ");
                                int newQuantity = scanner.nextInt();
                                docUpdate.setQuantity(newQuantity);
                                break;
                        }
                        System.out.println("Updated Successfully");
                    }
                    break;
                case 4:
                    System.out.println("[1] Find By ID");
                    System.out.println("[2] Find By Title");

                    int action1 = scanner.nextInt();
                    scanner.nextLine();

                    switch (action1) {
                        case 1:
                            System.out.print("Enter Document ID To Find: ");
                            String findId = scanner.nextLine();
                            Document foundDoc1 = library.findDocumentById(findId);
                            if (foundDoc1 != null) {
                                foundDoc1.printInfo();
                            } else {
                                System.out.println("Document not found with ID: ");
                            }
                            break;
                        case 2:
                            System.out.print("Enter Document Title To Find: ");
                            String findTitle = scanner.nextLine();
                            Document foundDoc2 = library.findDocumentByTitle(findTitle);
                            if (foundDoc2 != null) {
                                foundDoc2.printInfo();
                            }
                            break;
                    }
                case 5:
                    library.displayDocuments();
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(userId, name));
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    String borrowUserId = scanner.nextLine();
                    User user = library.findUser(borrowUserId);
                    if (user != null) {
                        System.out.print("Enter Document Title To Borrow : ");
                        String borrowDocTitle = scanner.nextLine();
                        Document borrowDoc = library.findDocumentByTitle(borrowDocTitle);
                        if (borrowDocTitle != null) {
                            user.borrowDocument(borrowDoc);
                        } else {
                            System.out.println("Document not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    user = library.findUser(returnUserId);
                    if (user != null) {
                        System.out.print("Enter documen title to return: ");
                        String returnDocTitle = scanner.nextLine();
                        Document returnDoc = library.findDocumentByTitle(returnDocTitle);
                        if (returnDoc != null) {
                            user.returnDocument(returnDoc);
                        } else {
                            System.out.println("Document not found.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 9:
                    library.displayUsers();
                    break;
                default:
                    System.out.println("Action is not supported.");
            }
        }
        scanner.close();
    }
}
