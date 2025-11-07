package oj_java;

import java.util.*;
import java.io.*;

public class java_oj82 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryFileSystem dir = new InMemoryFileSystem(scanner); 
        File[] files = dir.listFiles();

        int count = 0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile())
                continue;

            String name = files[i].getName();

            // TODO WRITE HERE!!
            int dotIndex = name.lastIndexOf('.');
            if (dotIndex != -1) {
                String ext = name.substring(dotIndex + 1);
                if (ext.equals("txt")) {
                    if (files[i].delete()) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count + " files are removed");
    }
}


// DO NOT MODIFY CODE BELOW THIS LINE
class InMemoryFileSystem {
    private Map<String, StringBuilder> fileSystem;
    private String path;

    public InMemoryFileSystem(Scanner scanner) {
        fileSystem = new HashMap<>();
        path = "/virtual/directory";
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
            .map(fileName -> new FileWrapper(fileName, this))
            .toArray(File[]::new);
    }

    public boolean deleteFile(String fileName) {
        return fileSystem.remove(fileName) != null;
    }

    public String getPath() {
        return path;
    }

    private class FileWrapper extends File {
        private String fileName;
        private InMemoryFileSystem parentFileSystem;

        public FileWrapper(String fileName, InMemoryFileSystem parentFileSystem) {
            super(fileName);
            this.fileName = fileName;
            this.parentFileSystem = parentFileSystem;
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

        //Override
        public String getName() {
            return fileName;
        }

        //Override
        public String getPath() {
            return parentFileSystem.getPath() + "/" + fileName;
        }

        //Override
        public boolean delete() {
            return parentFileSystem.deleteFile(fileName);
        }
    }
}

