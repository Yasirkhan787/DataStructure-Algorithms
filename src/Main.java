import arrayImplemenation.Array;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("-----------Welcome to Data Structure & Algorithms-----------");
        while (true)
        {
            System.out.println("Enter the Desired Data Structure \n 1.Array \n 2.Linked List \n 3.Stack \n 4.Queue \n 5.Exit");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                {
                    Array A = new Array();
                }
                break;
                case 2:
                    System.exit(0);
            }
        }
    }
}
