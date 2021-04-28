import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    int binarySearch(LinkedList a, Iris item, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the
            // middle itself
            if (a.get(mid) == item)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (a.get(mid).compareTo(item) > 0))
                return binarySearch(a, item, mid - 1, low);

            // Else the element can only be present
            // in right subarray
            return binarySearch(a, item, mid+1, high);
        }

        // We reach here when element is not present
        // in array
        return -1;
        return 0;
    }

    void insertionSort(LinkedList a, int n) {
        int n = a.size();
        for (int i = 1; i < n; ++i) {
            int key = (int) a.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
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
