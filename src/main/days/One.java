package main.days;

import main.FileByDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One extends FileByDay {
    
    @Override
    public String getSampleInputFilePath() {
        return "One.txt";
    }

    public void problemOneSample() {
        ArrayList<Integer> leftColumn = new ArrayList<>();
        ArrayList<Integer> rightColumn = new ArrayList<>();

        readSampleFile(line -> {
            String[] splitLine = line.trim().split("\\s+");
            
            // ensures there is two columns and puts each column in an array
            if (splitLine.length == 2) {
                try {
                    int leftValue = Integer.parseInt(splitLine[0]);
                    int rightValue = Integer.parseInt(splitLine[1]);
                    leftColumn.add(leftValue);
                    rightColumn.add(rightValue);
                } catch (NumberFormatException e) {
                    //this ensures that the file only has integers after
                    //parsing. Will throw an error if this was done improperly
                    System.out.println("Invalid number format in line: " + line);
                }
            }else {
                //if there are more than two or less than two columns, tells us file format is wrong
                System.out.println("Invalid number of columns for this problem");
            }
        });

        //orders arrays from smallest number to highest number
        Collections.sort(leftColumn);
        Collections.sort(rightColumn);

        //finds the difference between the left and right column (absolute value)
        int distance = 0; //initial distance
        for (int i = 0; i < leftColumn.size() && i < rightColumn.size(); i++) {
            int newDistance = Math.abs(leftColumn.get(i) - rightColumn.get(i));
            distance = distance + newDistance; //adds total distance as it iterates
        }
    }
    
}

