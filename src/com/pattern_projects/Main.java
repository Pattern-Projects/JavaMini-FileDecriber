package com.pattern_projects;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Input File Location:");
            String location = scanner.nextLine();

            //Using java.io.File
            var file = new File(location);

            //Not Used
                //Using java.nio
                var path = Path.of(location);
                var path2 = Paths.get(location);
                var path3 = FileSystems.getDefault().getPath(location);

                //From java.io.File to java.nio.Path
                var pathFromFile = file.toPath();

                //From java.nio.Path to java.io.File
                var fileFromPath = path.toFile();
            //end

            if (file.exists()) {
                System.out.println("Path points to a " + ((file.isFile()) ? "file" : "directory") + ".");
                System.out.println("\tName: "+file.getName());
                System.out.println();

                System.out.println("Last Modified:");
                System.out.println("\t"+ file.lastModified());
                System.out.println("File Size:");
                System.out.println("\t"+file.length());
                System.out.println("Can Execute:");
                System.out.println("\t" + file.canExecute());
                System.out.println("Is Hidden:");
                System.out.println("\t"+file.isHidden());
                System.out.println();

                if (!file.isFile()) {
                    var filesList = file.listFiles();
                    System.out.println("Contains:");
                    for (var listFile : filesList) {
                        System.out.println("\t"+listFile.getName());
                    }

                }

            } else {
                System.out.println("Path does not exist.");
            }

            System.out.println("=======================");
            System.out.println();
            System.out.println();

        }
    }
}
