package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
import java.util.Date;

public class FileUtils {
    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        String content = "";

        // With BufferedWriter
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                content += bufferedReader.readLine() + "\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);

        // With BufferedWriter
        try {
            FileWriter fileWriter = new FileWriter("./notes/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String inputStreamFileReader(File file) {
        String content = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0) {
                content += (char) fileInputStream.read();
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    //TODO: Phase1: define method here for writing file with OutputStream
    public static void outputStreamFileWriter(String content) {
        String fileName = getProperFileName(content);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./notes/" + fileName);
            char[] c = content.toCharArray();
            byte[] temp = new byte[c.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (byte) c[i];
            }
            fileOutputStream.write(temp);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't save note.");
        }
    }

    //TODO: Phase2: proper methods for handling serialization
    public static void objectFileWriter(Note note) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./notes/" + note.getTitle() + ".obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(note);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Note objectFileReader(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Note note = (Note) objectInputStream.readObject();

            return note;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }

    public static String[] noteListTitles(File[] files) {
        String[] titles = new String[files.length];

        for (int i = 0; i < titles.length; i++) {
            Note note = (Note) FileUtils.objectFileReader(files[i]);
            String title = note.getTitle();
            String line1 = FileUtils.getProperFileName(note.getContent());
            String date = (new Date()).toString();

            String listTitle = title + " | " + date + " | " + line1;
            titles[i] = listTitle;
        }

        return titles;
    }
}
