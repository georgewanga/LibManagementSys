package dataoffice;

import java.io.File;

public class CreateDirectory {

    public void createDirectory(String[] Directory) {
        for (int i = 0; i < Directory.length; i++) {
            File theDirectory = new File(Directory[i]);

            // if the main Dir does not exist, create it
            if (!theDirectory.exists()) {
                System.out.println("creating directory: " + theDirectory.getName());
                boolean result = false;
                try {
                    theDirectory.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("DIR created");
                }
            } else {
                System.out.println("DIR exist");
            }
        }
    }
}
