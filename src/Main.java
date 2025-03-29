
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class
 * Reading input.txt putting into HashTable
 * @author Cody Bandrowski
 */
public class Main {
    public static void main(String[] args) {
            HashTable table = new HashTable();

        File file = new File("/Users/cbandrowski/School/CSC311/CSC329_HW3/src/input.txt");

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        System.out.println("Reading file");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String nameline;
            while((nameline = br.readLine()) != null){
                String scoreLine = br.readLine();
                int score = Integer.parseInt(scoreLine.trim());
                table.add(new Player(nameline, score));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file");
        }

        System.out.println("Original Hash Table ------------------------------------------------------------------------------>");
        table.show();

        // Test Copy Constructor
        HashTable copiedTable = new HashTable(table);
        System.out.println("Copied Hash Table ------------------------------------------------------------------------------>");
        copiedTable.show();

        // Test CreateClone
        HashTable clonedTable = table.createclone();
        System.out.println("Cloned Hash Table ------------------------------------------------------------------------------>");
        clonedTable.show();

        // Test find method
        System.out.println("Finding name --------------------------------------->");
        String nameFind = "Tyler Scott";
        Player found = table.find(nameFind);
        if(found != null){
            System.out.println("Player found"+ found.toString());
        }
        else{
            System.out.println("Player not found");
        }
        }
    }

