import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    int binarySearch(LinkedList a, Iris item, int low, int high) {

        return 0;
    }

    void insertionSort(LinkedList a, int n) {
        int i = 0;
        while (i < a.size()) {

        }
    }

    public static String loop(int listSize) {
        //file reader
        FileInputStream fis = null;
        String lines[];
        //try and catch for file not found, initializes fis
        try {
            fis = new FileInputStream("fish-iris.csv.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<Iris> arraylist = new ArrayList<Iris>(); //arraylist for sorting
        LinkedList<Iris> linkedlist = new LinkedList<>(); //linkedlist for sorting

        //fill list
        Scanner reader = new Scanner(fis);
        reader.nextLine(); //skips column headers
        //reader iterates thru list certain number of times, splits by comma and parses and adds to arraylist
        for (int i = 0; i < listSize; i++) {
            lines = reader.nextLine().split(",");
            arraylist.add(new Iris(Double.parseDouble(lines[0]), Double.parseDouble(lines[1]), Double.parseDouble(lines[2]),
                    Double.parseDouble(lines[3]), lines[4]));
            //test1

        }

        //reader iterates thru list certain number of times, splits by comma and parses and adds to linkedlist
        for (int i = 0; i < listSize; i ++) {
            lines = reader.nextLine().split(",");
            linkedlist.add(new Iris(Double.parseDouble(lines[0]), Double.parseDouble(lines[1]), Double.parseDouble(lines[2]),
                    Double.parseDouble(lines[3]), lines[4]));
        }
        reader.close();

        //test
        String print;
        print = linkedlist.get(11).toString();
        return print;
    }

    public static void main(String[] args) {
//fileoutputstream to write new file
        FileOutputStream fos = null;
        File csvFile = new File("runtime.txt");
        try {
            csvFile.createNewFile();
            PrintWriter writer = new PrintWriter(csvFile);
            writer.println(loop(1000));


            writer.close();
        } catch (IOException e){
            System.exit(1);
        }
    }
}
