import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeApp_3 {
    // Import statements and LockedMeApp class declaration

    // Import statements and LockedMeApp class declaration

    private static final String ROOT_DIRECTORY = "out/";

    public static void main(String[] args) {
        displayWelcomeScreen();
        displayUserOptions();
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: Aryaman Sharma");
        System.out.println();
    }

    private static void displayUserOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. Retrieve file names in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Close the application");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                retrieveFileNames();
                break;
            case 2:
                displayFileOperations();
                break;
            case 3:
                closeApplication();
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                displayUserOptions();
                break;
        }
    }

    private static void retrieveFileNames() {
        File directory = new File(ROOT_DIRECTORY);
        File[] files = directory.listFiles();

        if (files != null && files.length > 0) {
            List<String> fileNames = new ArrayList<>();
            for (File file : files) {
                fileNames.add(file.getName());
            }
            Collections.sort(fileNames);

            System.out.println("Files in ascending order:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        displayUserOptions();
    }

    private static void closeApplication() {
        System.out.println("Closing the application... Goodbye!");
        // Additional cleanup or exit code can be added here if necessary
    }

    private static void displayFileOperations() {
        System.out.println("File Operations:");
        System.out.println("1. Add a file to the existing directory list");
        System.out.println("2. Delete a file from the existing directory list");
        System.out.println("3. Search for a file in the main directory");
        System.out.println("4. Navigate back to the main context");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addFile();
                break;
            case 2:
                deleteFile();
                break;
            case 3:
                searchFile();
                break;
            case 4:
                displayUserOptions();
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                displayFileOperations();
                break;
        }
    }

    private static void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + fileName);
        System.out.println(ROOT_DIRECTORY + fileName);
        if (file.exists()) {
            System.out.println("File already exists.");
        } else {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File added successfully.");
                } else {
                    System.out.println("Failed to add the file.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while adding the file: " + e.getMessage());
            }
        }

        displayFileOperations();
    }

    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + File.separator + fileName);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }

        displayFileOperations();
    }

    private static void searchFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File directory = new File(ROOT_DIRECTORY);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    displayFileOperations();
                    return;
                }
            }
        }

        System.out.println("File not found.");
        displayFileOperations();
    }

}
