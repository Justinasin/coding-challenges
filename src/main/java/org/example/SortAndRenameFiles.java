package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAttributes;

public class SortAndRenameFiles {

    public void sortAndRenameFilesInDirectory(String path) {
        List<File> filesInDirectory = new ArrayList<>();

        getAllFiles(filesInDirectory, new File(path));

        sortFilesByDateCreated(filesInDirectory);

        renameFiles(filesInDirectory);

        System.out.println("done");
    }

    private void getAllFiles(List<File> filesInDirectory, File directory) {
        for (File dirChild : directory.listFiles()) {
            if (dirChild.isDirectory()) {
                getAllFiles(filesInDirectory, directory);
            } else {
                filesInDirectory.add(dirChild);
            }
        }
    }

    private void sortFilesByDateCreated(List<File> filesInDirectory) {
        int n = filesInDirectory.size();

        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                FileTime file1FileTime = getFileModificationDateTime(filesInDirectory.get(i));
                FileTime file2FileTime = getFileModificationDateTime(filesInDirectory.get(i + 1));

                if (file1FileTime.compareTo(file2FileTime) > 0) {
                    File temp = filesInDirectory.get(i);
                    filesInDirectory.set(i, filesInDirectory.get(i + 1));
                    filesInDirectory.set(i + 1, temp);
                }
            }

            n--;
        }
    }

    private void renameFiles(List<File> filesInDirectory) {
        long counter = 1000;
        for (File fileToRename : filesInDirectory) {
            String fullFileName = fileToRename.getName();

            int index = fullFileName.lastIndexOf('.');
            String extension = fullFileName.substring(index + 1);
            String newFileName = "IMG_" + counter + "." + extension;
            fileToRename.renameTo(new File(fileToRename.getParent(), newFileName));

            counter++;
        }
    }

    private FileTime getFileModificationDateTime(File file) {
        Path path = file.toPath();
        try {
            return readAttributes(path, BasicFileAttributes.class).lastModifiedTime();
        } catch (IOException e) {
            throw new RuntimeException("cannot get file " + path + " attributes", e);
        }
    }
}
