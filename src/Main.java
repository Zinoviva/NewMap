import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //вводим алфавит
        String input = newText.text.toUpperCase();  //переводим весь текст в верхний регистр
        char occursTheMost = 'A';  //ввели произвольно самый часто встречающийся символ
        int maxCount = 0;  //макс кол
        int minCount = 0;  //мин кол

        for (int i = 0; i < alphabet.length(); i++)  //создадим для хранения увиденные символы
            map.put(alphabet.charAt(i), 0);

        //находим нужный символ кот нужно искать
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c))  //если он содержится в нашей мапе- увиливаем его количество
                map.put(c, map.get(c) + 1);
            //проверяем максимальное количество и установливаем соответствующие значения
            if (map.containsKey(c) && map.get(c) > maxCount) {
                //occursTheMost = c;
                maxCount = map.get(c);
            }
            //проверяем минимальное количество и установливаем соответствующие значения
            if (map.containsKey(c) && map.get(c) < minCount) {
                //occursTheMost = c;
                maxCount = map.get(c);
            }
        }
        //разделяем строку на слова и ищем символ, который содержатся в тексте
        String[] words = input.split(" ");  //ищем разделитель по пробелу и делаем массив
        int wordCount = 0;
        CharSequence charSequence;
        for (Character character : map.keySet()) {
            int tempCount = 0;
            charSequence = "" + character;
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains(charSequence))
                    tempCount++;
            }

            if (tempCount > wordCount) {
                occursTheMost = character;
                wordCount = tempCount;
            }
        }

        System.out.println(occursTheMost + " " + wordCount);
    }

    public static class newText {  // статическое текстовое поле
        static String text;

        static {
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        }

    }
}

