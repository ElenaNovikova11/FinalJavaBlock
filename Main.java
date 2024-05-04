import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        int count = 0;
        String word = "";
        
        // Количество слов в файле
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println("Всего слов в файле: " + count);
        }
        

        // Самое длинное слово
        try (Scanner scanner = new Scanner(file)) {
            String current;
            while (scanner.hasNext()) {
                current = scanner.next();
                if (current.length() > word.length()) {
                    word = current;
                }
            }
            System.out.println();   
            System.out.println("Самое длинное слово: " + word);
        }

        // Сколько раз встречаються слова
        try (Scanner scanner = new Scanner(file)) {
            HashMap<String, Integer> KeyWord = new HashMap<>();
            while (scanner.hasNext()) {
                word = scanner.next();
                if (KeyWord.containsKey(word)) {// Сдерживающий ключ
                    count = KeyWord.get(word);// получить
                    KeyWord.put(word, count + 1);// положи

                } else {
                    KeyWord.put(word, 1);
                }
            }
            System.out.println();
            System.out.println("Вот сколько раз встречаются овощи/фрукты: ");
            for (String word1 : KeyWord.keySet()) {// набор ключей
                System.out.println(word1 + ": " + KeyWord.get(word1));
            }
        }

        // Самый популярный фрукт/овошь
        try (Scanner scanner = new Scanner(file)) {
            int max = 0;
            String res = "";
            HashMap<String, Integer> KeyWord = new HashMap<>();
            while (scanner.hasNext()) {
                word = scanner.next();
                count = KeyWord.merge(word, 1, Integer::sum);
                if (count > max) {
                    max = count;
                    res = word;
                }
            }
            System.out.println();
            System.out.println("Самый популярный фрукт/овощь: " + res + " встречается " + max + " раз");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
