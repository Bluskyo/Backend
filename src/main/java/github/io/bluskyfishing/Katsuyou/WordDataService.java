package github.io.bluskyfishing.Katsuyou;

import org.springframework.stereotype.Service;


@Service
public class WordDataService {

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Word word(){
        String[][] verbs = N5verbs.n5List();
        int x = verbs.length;
        int random = getRandomNumber(0, x);
        Word word = new Word(
                verbs[random][0],
                verbs[random][1],
                verbs[random][2],
                verbs[random][3]
        );

        return word;
    }
}
