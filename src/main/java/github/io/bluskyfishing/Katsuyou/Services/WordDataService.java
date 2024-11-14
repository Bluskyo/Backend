package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Data.N5;
import github.io.bluskyfishing.Katsuyou.Methods.Conjugations;
import github.io.bluskyfishing.Katsuyou.Methods.GetTag;
import github.io.bluskyfishing.Katsuyou.Models.Kanji;
import github.io.bluskyfishing.Katsuyou.Repositories.KanjiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class WordDataService {

    private KanjiRepository kanjiRepository;

   @Autowired
    public void setKanjiRepository(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    public Kanji getEntryByKanji(String kanji) {
        return kanjiRepository.findEntryByKanji(kanji).getFirst();
    }

    public Kanji getRandomEntryByKanji() {
        String[] n5Verbs = N5.n5Verbs();

        int random = new Random().nextInt(n5Verbs.length);
        String kanji = n5Verbs[random];

        return kanjiRepository.findEntryByKanji(kanji).getFirst();
    }

    public Map<String, Map<String, String>> getAllConjugations(String kanji) {

        Kanji word = this.getEntryByKanji(kanji);

        String reading = word.reading;
        String tag = GetTag.GetTagFromPos(word);

        Map<String, Map<String, String>> allConjugationsDict = new HashMap<>();

        allConjugationsDict.put("present", Conjugations.present(kanji, reading, tag));
        allConjugationsDict.put("past", Conjugations.past(kanji, reading, tag));
        allConjugationsDict.put("teForm", Conjugations.teForm(kanji, reading, tag));
        allConjugationsDict.put("potential", Conjugations.potential(kanji, reading, tag));
        allConjugationsDict.put("volitional", Conjugations.volitional(kanji, reading, tag));
        allConjugationsDict.put("passive", Conjugations.passive(kanji, reading, tag));
        allConjugationsDict.put("causative", Conjugations.causative(kanji, reading, tag));
        allConjugationsDict.put("causativePassive", Conjugations.causativePassive(kanji, reading, tag));
        allConjugationsDict.put("imperative", Conjugations.imperative(kanji, reading, tag));
        allConjugationsDict.put("conditional", Conjugations.conditional(kanji, reading, tag));

        return allConjugationsDict;
    }

}