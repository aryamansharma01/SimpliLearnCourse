import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeApp {
    private static final String ROOT_DIRECTORY = "aryaman/";

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
                // Code for File Operations will be implemented in Sprint 2
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
}
