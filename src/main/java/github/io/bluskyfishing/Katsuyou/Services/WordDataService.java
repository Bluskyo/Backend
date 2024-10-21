package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Data.N5;
import github.io.bluskyfishing.Katsuyou.Models.Kanji;
import github.io.bluskyfishing.Katsuyou.Repositories.KanjiRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WordDataService {

    private final KanjiRepository kanjiRepository;

    // Constructor injection for KanjiRepository
    public WordDataService(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    public List<Kanji> getEntryByKanji(String kanji) {
        return kanjiRepository.findEntryByKanji(kanji);
    }

    public List<Kanji> getRandomEntryByKanji() {
        String[] n5Verbs = N5.n5Verbs();

        int random = new Random().nextInt(n5Verbs.length);
        // Gets a random kanji from the list
        String kanji = n5Verbs[random];

        return kanjiRepository.findEntryByKanji(kanji);
    }
}
