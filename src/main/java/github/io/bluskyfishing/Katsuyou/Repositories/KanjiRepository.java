package github.io.bluskyfishing.Katsuyou.Repositories;

import github.io.bluskyfishing.Katsuyou.Models.Kanji;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KanjiRepository extends CrudRepository<Kanji, Long> {
    @Query(value = "SELECT Entry_ID, Entry_Seq, Entry, Reading, Pos, Similar_Meaning, Frequency, Field, Antonym, Similar_kanji, Gloss " +
            "FROM Kanji " +
            "INNER JOIN Metadata ON Kanji.Metadata_ID=Metadata.Metadata_ID " +
            "INNER JOIN Translations ON Kanji.Translations_ID=Translations.Translations_ID " +
            "WHERE Entry LIKE :kanji",
            nativeQuery = true)
    List<Kanji> findEntryByKanji(@Param("kanji") String kanji);
}
