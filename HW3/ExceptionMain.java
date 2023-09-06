package HW3;

public class ExceptionMain extends Exception {

    public ExceptionMain (String[] arr){
        if(arr.length < 6){
            System.out.println("Упс! Забыли ввести какие-то данные!");
        } else {
            System.out.println("Что-то многовато данных, перепроверьте введённые данные!");
        }
    }

    public ExceptionMain(char x) {
        System.out.printf("Ой, какие-то проблемы с вашим полом, можете перекрыть, но лучше указать: m или f, вместо введённого %s", x);
    }
}
