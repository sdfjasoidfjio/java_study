package oj_java;

import java.util.*;
import java.io.*;

public class java_oj81 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryFileSystem file = new InMemoryFileSystem(scanner);

        File[] files = file.listFiles(); 
        File bigFile = null;             
        long bigSize = 0;                

        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                long size = f.length();  
                if (size > bigSize) {
                    bigSize = size;
                    bigFile = f;
                }
            }
        }

        if (bigFile == null)
            System.out.println("None");
        else
            System.out.println("biggest file is " + bigFile.getName() + "(" + bigSize + " bytes)");
    }
}


// DO NOT MODIFY CODE BELOW THIS LINE
class InMemoryFileSystem {
    private Map<String, StringBuilder> fileSystem;

    public InMemoryFileSystem(Scanner scanner) {
        fileSystem = new HashMap<>();
        initializeFileSystem(scanner);
    }

    private void initializeFileSystem(Scanner scanner) {
        int f_cnt = 0;
        while (true) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }
            f_cnt++;
            String fileName = "input" + f_cnt + ".txt";
            String randomContent = generateRandomText(n);
            writeFile(fileName, randomContent);
        }
    }

    private String generateRandomText(int seed) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        int minLength = 32;
        int maxLength = 128;

        Random random = new Random(seed);
        int randomLength = minLength + random.nextInt(maxLength - minLength + 1);
        StringBuilder sb = new StringBuilder(seed);

        for (int i = 0; i < randomLength; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public void writeFile(String fileName, String content) {
        fileSystem.put(fileName, new StringBuilder(content));
    }

    public File[] listFiles() {
        return fileSystem.keySet().stream()
            .map(FileWrapper::new)
            .toArray(File[]::new);
    }

    private class FileWrapper extends File {
        private String fileName;

        public FileWrapper(String fileName) {
            super(fileName);
            this.fileName = fileName;
        }

        //Override
        public boolean isFile() {
            return true;
        }

        //Override
        public long length() {
            StringBuilder content = fileSystem.get(fileName);
            return content == null ? 0 : content.length();
        }
    }
}
