package JPHomeWork3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HMW32 {
    private static Map<String,ArrayList<String>> MyPhoneBook = new HashMap<>();

//Метод для добавления контакта в телефонную книгу
    private static void AddPhoneBook(String name, String phone){
        ArrayList<String> Phones = new ArrayList<>();
        if (MyPhoneBook.containsKey(name)) {
            MyPhoneBook.get(name).add(phone);
        }
        else {
            Phones.add(phone);
            MyPhoneBook.put(name,Phones);
        }
    }
//Метод поиска по фамилии контактных данных
    private static void GetPhones(String name){
        System.out.println("Фамилия: " + name + " - Телефон: " + MyPhoneBook.get(name));
    }
//Основной метод
    public static void main(String[] args){
        AddPhoneBook("Федотов","89137106378");
        AddPhoneBook("Петров","89137106377");
        AddPhoneBook("Иванов","89137106377");
        AddPhoneBook("Иванов","89137106379");
        AddPhoneBook("Федотов","89137106378");
        AddPhoneBook("Петров","89137106377");
        AddPhoneBook("Иванов","89137106377");
        AddPhoneBook("Иванов","89137106379");

        System.out.println(MyPhoneBook);

        GetPhones("Федотов");

    }
}
