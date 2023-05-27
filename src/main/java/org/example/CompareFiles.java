package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompareFiles {

    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize SHA-512 hash function", e);
        }
    }

    public void parseDirectory(String path) {
        Map<String, List<File>> lists = new HashMap<>();

        // Get all duplicated files
        System.out.println("Getting the list of duplicated files");
        getDuplicateFiles(lists, new File(path));

        // List all duplicated files
        listDuplicateFiles(lists, path);

        // Delete all duplicate files
        System.out.printf("Starting to delete duplicated files at %s%n", LocalDateTime.now());
        deleteDuplicateFiles(lists);
        System.out.printf("Duplicated files deletion ended at %s%n", LocalDateTime.now());
    }

    private void getDuplicateFiles(Map<String, List<File>> filesList, File directory) {
        for (File dirChild : directory.listFiles()) {

            // Iterate all file sub directories recursively
            if (dirChild.isDirectory()) {
                getDuplicateFiles(filesList, dirChild);
            } else {
                try {
                    // Read file as bytes
                    FileInputStream fileInput = new FileInputStream(dirChild);
                    byte fileData[] = new byte[(int) dirChild.length()];
                    fileInput.read(fileData);
                    fileInput.close();
                    // Create unique hash for current file
                    String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);

                    List<File> identicalList = filesList.get(uniqueFileHash);
                    if (identicalList == null) {
                        identicalList = new LinkedList<>();
                    }

                    // Add path to list
                    identicalList.add(dirChild);

                    // push updated list to Hash table
                    filesList.put(uniqueFileHash, identicalList);
                } catch (IOException e) {
                    throw new RuntimeException("cannot read file " + dirChild.getAbsolutePath(), e);
                }
            }
        }
    }

    private void listDuplicateFiles(Map<String, List<File>> filesList, String directory) {
        System.out.printf("Duplicate files in directory: %s%n", directory);
        int fileCount = 0;

        for (List<File> list : filesList.values()) {
            fileCount = fileCount + list.size();
            if (list.size() > 1) {
                for (File file : list) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

        System.out.printf("Found %s%n duplicated files", fileCount);
    }

    private void deleteDuplicateFiles(Map<String, List<File>> filesList) {
        int fileCount = 0;

        for (List<File> list : filesList.values()) {
            fileCount = fileCount + list.size();
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    deleteFile(list.get(i));
                }
            }
        }

        System.out.printf("Deleted %s%n duplicated files", fileCount);
    }

    private void deleteFile(File file) {
        if (file.delete()) {
            System.out.printf("File: %s deleted successfully%n", file.getAbsoluteFile());
        } else {
            System.out.printf("Failed to delete the file: %s%n", file.getAbsoluteFile());
        }
    }
}
