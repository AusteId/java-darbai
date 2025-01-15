import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> translations = new HashMap<>();

    public void add(String word, String translation) {

        translations.putIfAbsent(word, new ArrayList<>());
        ArrayList<String> translationsInList = translations.get(word);
        translationsInList.add(translation);
    }

    public ArrayList<String> translate(String word) {
        return translations.getOrDefault(word, new ArrayList<>());
    }

    public void remove(String word) {
        translations.remove(word);
    }

}
