package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Data.N5verbs;
import github.io.bluskyfishing.Katsuyou.Models.DisplayKanji;
import org.springframework.stereotype.Service;

@Service
public class WordDataService {

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public DisplayKanji word(){
        String[][] verbs = N5verbs.n5List();
        int x = verbs.length;
        int random = getRandomNumber(0, x);

        return new DisplayKanji(
                verbs[random][0],
                verbs[random][1],
                verbs[random][2],
                verbs[random][3]
        );
    }
}
