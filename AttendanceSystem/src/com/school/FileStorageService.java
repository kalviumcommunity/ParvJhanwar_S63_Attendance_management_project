package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Simple file storage service to save lists of Storable objects to disk.
 */
public class FileStorageService {

    /**
     * Save a list of Storable items to the given filename. Each item is written
     * as a single line using its toDataString() representation.
     */
    public void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Storable s : items) {
                pw.println(s.toDataString());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }
}
