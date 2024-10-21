package github.io.bluskyfishing.Katsuyou.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Kanji")
public class Kanji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int entry_id;
    public int entry_seq;
    public String entry;
    public String reading;
    // From Metadata table
    public String pos;
    public String similar_meaning;
    public String frequency;
    public String field;
    public String antonym;
    public String similar_kanji;
    // From Translations table
    public String gloss;

    public Kanji(int entry_id, int entry_seq, String entry, String reading, String pos, String similar_meaning,
                 String frequency, String field, String antonym, String similar_kanji, String gloss) {

        this.entry_id = entry_id;
        this.entry_seq = entry_seq;
        this.entry = entry;
        this.reading = reading;
        this.pos = pos;
        this.similar_meaning = similar_meaning;
        this.frequency = frequency;
        this.field = field;
        this.antonym = antonym;
        this.similar_kanji = similar_kanji;
        this.gloss = gloss;
    }

    protected Kanji() {
    }
}

