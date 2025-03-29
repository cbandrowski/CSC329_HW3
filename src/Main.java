import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        System.out.println("Original Hash Table");
        table.show();
        }
    }

