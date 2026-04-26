package org.example;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        String palindrome = "";

        for (int i = word.length() - 1; i >= 0; i--) {
           palindrome += word.charAt(i);
        }

        if (palindrome.equalsIgnoreCase(word)) {
            System.out.println("is a palindrome");
        } else {
            System.out.println("is not a palindrome");
        }

    }
}