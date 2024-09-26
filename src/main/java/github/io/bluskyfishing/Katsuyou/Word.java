package github.io.bluskyfishing.Katsuyou;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Word {
    public String kanji;
    public String hiragana;
    public String tag;
    public String meaning;

    public Word(String kanji, String hiragana, String tag, String meaning) {
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.tag = tag;
        this.meaning = meaning;
    }
}
