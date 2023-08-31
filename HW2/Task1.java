package HW2;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner iScanner = new Scanner(System.in);
                System.out.printf("Введите число n: ");
                float n = iScanner.nextFloat();
                System.out.printf("Введённое число:  %s \n", n);
            } catch (Exception ex) {
                System.out.println("Некорректный ввод числа, повторите попытку");
            }
        }
    }
}
