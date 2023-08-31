package HW2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Task {
    public static void main(String[] args) {
       //Task2();
       //Task3();
       Task4();
    }
    public static void Task2(){
    // Задание:
    //    try {
    //        int d = 0;
    //        double catchedRes1 = intArray[8] / d;
    //        System.out.println("catchedRes1 = " + catchedRes1);
    //    } catch (ArithmeticException e) {
    //        System.out.println("Catching exception: " + e);
    //    }
        try {
            int d = 0;
            //проверка на выход за пределы массива, расскомментить:
            int[] intArray = new int[5];
            //проверка на арифметику, расскомментить:
            //int[] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Catching exception: " + ex);
        }
    }

    public static void Task3() {

        try {
            int a = 90;
            int b = 0;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        }  catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }  catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }


    public static void Task4(){
//        Разработайте программу, которая выбросит Exception,
//        когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            boolean exit = true;
            while (exit){
                try {
                    System.out.println("Введите строку: ");
                    String text = getText(bufferedReader);
                    System.out.println(text);
                    exit = false;
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка при работе с консолью");
        }

    }

    public static String getText(BufferedReader bufferedReader) throws IOException{
        String text = bufferedReader.readLine();
        if (text.isEmpty()){
            throw new RuntimeException("Введена пустая строка, повторите попытку!");
        }
        return text;
    }
}
