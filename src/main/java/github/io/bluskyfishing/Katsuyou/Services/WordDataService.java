package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Data.N5verbs;
import github.io.bluskyfishing.Katsuyou.Models.DisplayKanji;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class WordDataService {

    public DisplayKanji word(){
        String[][] n5Verbs = N5verbs.n5List();
        int random = new Random().nextInt(n5Verbs.length);

        return new DisplayKanji(
                n5Verbs[random][0], // kanji
                n5Verbs[random][1], // hiragana
                n5Verbs[random][2], // tag
                n5Verbs[random][3] // meaning
        );
    }
}
