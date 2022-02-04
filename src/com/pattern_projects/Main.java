package com.pattern_projects;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Input File Location:");
            String path = scanner.nextLine();

            //Using java.io.File
            var file = new File(path);

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
