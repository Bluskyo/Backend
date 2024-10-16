package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Methods.Conjugations;

import java.util.HashMap;
import java.util.Map;

public class AllConjugationsService {
    public static Map<String, Map<String, String>>  addAllConjugations(String kanji, String tag) {

        Map<String, Map<String, String>> allConjugationsDict = new HashMap<>();

        allConjugationsDict.put("Present", Conjugations.present(kanji, tag));
        allConjugationsDict.put("past", Conjugations.past(kanji, tag));
        allConjugationsDict.put("teForm", Conjugations.teForm(kanji, tag));
        allConjugationsDict.put("potential", Conjugations.potential(kanji, tag));
        allConjugationsDict.put("volitional", Conjugations.volitional(kanji, tag));
        allConjugationsDict.put("passive", Conjugations.passive(kanji, tag));
        allConjugationsDict.put("causative", Conjugations.causative(kanji, tag));
        allConjugationsDict.put("causativePassive", Conjugations.causativePassive(kanji, tag));
        allConjugationsDict.put("imperative", Conjugations.imperative(kanji, tag));
        allConjugationsDict.put("conditional", Conjugations.conditional(kanji, tag));

        return allConjugationsDict;
    }
}
