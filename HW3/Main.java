package HW3;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом:
Фамилия Имя Отчество дата_рождения номер_телефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю
выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку
 должны записаться полученные данные, вида:

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
 */
public class Main {
    public static void main(String[] args) throws ExceptionMain, FileSystemException, ParseException {
    readString();

    }

    private static void readString() throws ExceptionMain, FileSystemException, ParseException {
        char f = 'f';
        char m = 'm';

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите данные пользователя в формате:" +
                "Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(79999999999) пол(f или m): ");
        try {
            String enteredString = iScanner.nextLine();
            String[] word = enteredString.split(" ");
            if (word.length != 6) {
                throw new ExceptionMain(word);
            }

            String lastName = word[0];
            String firstName = word[1];
            String secondName = word[2];

            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            Date birthdate;
            birthdate = format.parse(word[3]);

            long phone = Long.parseLong(word[4]);
            char gender = word[5].charAt(0);
            if (gender != 'f' & gender != 'm'){
                throw new ExceptionMain(gender);
            }
            System.out.printf("Вы ввели: \n Фамилия: %s, \n Имя: %s, \n" +
                    " Отчество: %s, \n дата рождения: %s,\n Номер телефона: %s, \n" +
                    " Пол: %s", word[0], word[1], word[2], word[3], word[4], word[5]);

            String fileName = "HW3/File/" + lastName.toLowerCase() + ".txt";
            File file = new File(fileName);
            saveFile(file, lastName, firstName, secondName, birthdate, phone, gender);


        } catch (ClassCastException e){
            System.out.println("Данные введены не по форме!");
        } catch (NumberFormatException e){
            System.out.println("Некорректно введён номер телефона!");
        } catch (ParseException e){
        throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

    }

    private static void saveFile(File file, String lName, String fName, String sName, Date birthday, long phone, char gender) throws FileSystemException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.mm.yyyy");
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("<%s><%s><%s><%s><%s><%s>", lName, fName, sName, formatDate.format(birthday), phone, gender));
        }catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }

    }
}
