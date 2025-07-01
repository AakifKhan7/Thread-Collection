package characterStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Write a program to count the total no. of chars, words, lines, alphabets,
// digits, white spaces in a given file

public class PB359 {
    public static void main(String[] args) throws IOException {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        int alphabetCount = 0;
        int digitCount = 0;
        int spaceCount = 0;

        BufferedReader br = new BufferedReader(new FileReader("File.txt"));
        String line = br.readLine();
        while (line != null) {
            charCount += line.length();
            wordCount += countWord(line);
            alphabetCount += countAlphabets(line);
            digitCount += countDigits(line);
            spaceCount += countWhitespaces(line);
            lineCount++;
        }
        br.close();

        System.out.println("Total characters: " + charCount);
        System.out.println("Total words: " + wordCount);
        System.out.println("Total lines: " + lineCount);
        System.out.println("Total alphabets: " + alphabetCount);
        System.out.println("Total digits: " + digitCount);
        System.out.println("Total white spaces: " + spaceCount);
    }

    static int countWord(String line){
        String[] words = line.split(" ");
        return words.length;
    }

    static int countAlphabets(String line){
        int count = 0;
        for(char c: line.toCharArray()){
            if(Character.isLetter(c)){
                count++;
            }
        }
        return count;
    }

    static int countDigits(String line){
        int count = 0;
        for(char c: line.toCharArray()){
            if(Character.isDigit(c)){
                count++;
            }
        }
        return count;
    }

    static int countWhitespaces(String line){
        int count = 0;
        for(char c: line.toCharArray()){
            if(Character.isWhitespace(c)){
                count++;
            }
        }
        return count;
    }
}
