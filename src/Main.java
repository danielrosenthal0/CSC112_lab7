import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static int binarySearchArrayList(ArrayList<Iris> a, Iris item, int low, int high) {
        if (high - low == 0) {
            return high;
        } else {
            int mid = low + (high - low) / 2;


            // If the element is present at the
            // middle itself
            if (a.get(mid).compareTo(item) <= 0) {

                return binarySearchArrayList(a, item, low, mid);
            } else {

                // If element is smaller than mid, then
                // it can only be present in left subarray

                return binarySearchArrayList(a, item, mid + 1, high);
            }
        }
    }

    public static void insertionSortArrayList(ArrayList<Iris> a) {
        int i = 1;
        while (i < a.size()) {
            Iris x = a.get(i);
            int loc;
            loc = binarySearchArrayList(a, x, 0, i-1);
            //i++;
            a.remove(i);
            a.add(loc, x);
            i++;
        }
    }


    public static int binarySearchLinkedList(LinkedList<Iris> a, Iris item, int low, int high) {

        if (high - low == 0) {
            return high;
        } else {
            int mid = low + (high - low) / 2;


            // If the element is present at the
            // middle itself
            if (a.get(mid).compareTo(item) <= 0) {

                return binarySearchLinkedList(a, item, low, mid);
            } else {

                // If element is smaller than mid, then
                // it can only be present in left subarray

                return binarySearchLinkedList(a, item, mid + 1, high);
            }
    }}
    public static void insertionSortLinkedList(LinkedList<Iris> a) {
        int i = 1;
        while (i < a.size()) {
            Iris x = a.get(i);
            int loc;
            loc = binarySearchLinkedList(a, x, 0, i-1);
            //i++;
            a.remove(i);
            a.add(loc, x);
            i++;
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
        LinkedList<Iris> linkedlist = new LinkedList<Iris>(); //linkedlist for sorting


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
//runtime
        long startTimeArrayList = System.nanoTime();
        insertionSortArrayList(arraylist);
        long endTimeArrayList   = System.nanoTime();
        long totalTimeArrayList = endTimeArrayList - startTimeArrayList;

        long startTimeLinkedList = System.nanoTime();
        insertionSortLinkedList(linkedlist);
        long endTimeLinkedList   = System.nanoTime();
        long totalTimeLinkedList = endTimeLinkedList - startTimeLinkedList;
//        System.out.println(arraylist.get(25));
//        System.out.println(arraylist.get(30));
//        System.out.println(arraylist.get(25).compareTo(arraylist.get(30)));
//        for(Iris i: linkedlist){
//            System.out.println(i.toString());
//        }
        System.out.println("LinkedList sort for " + listSize + " data points:");
        for(int i = 0; i < listSize; i++){
            //System.out.println(linkedlist.get(i).toString());
        }
        System.out.println("ArrayList sort for " + listSize + " data points:");
        for(int i = 0; i < listSize; i++){
            //System.out.println(arraylist.get(i).toString());
        }
        return ("Linked List," + listSize + "," + totalTimeLinkedList + "\n" +
                "Array List," + listSize + "," + totalTimeArrayList);
    }

    public static void main(String[] args) {
//fileoutputstream to write new file
        FileOutputStream fos = null;
        File csvFile = new File("runtime.txt");
        try {
            csvFile.createNewFile();
            PrintWriter writer = new PrintWriter(csvFile);
            writer.println(loop(1000));
            writer.println(loop(5000));
            writer.println(loop(10000));
            writer.println(loop(15000));
            writer.println(loop(20000));
            writer.println(loop(50000));
            writer.println(loop(100000));
            writer.close();
        } catch (IOException e){
            System.exit(1);
        }

    }
}
