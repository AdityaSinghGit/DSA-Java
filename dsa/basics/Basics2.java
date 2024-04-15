package basics;

import java.util.Scanner;

public class Basics2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of pattern : ");
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((int) Math.pow(j, 2));
            }
            System.out.println();
        }
        sc.close();
    }
}