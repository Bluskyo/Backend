package github.io.bluskyfishing.Katsuyou.EndpointControllers;
import github.io.bluskyfishing.Katsuyou.Models.Kanji;
import github.io.bluskyfishing.Katsuyou.Services.WordDataService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordDataController {

    private final WordDataService wordDataService;

    // Constructor injection for WordDataService
    public WordDataController(WordDataService wordDataService) {
        this.wordDataService = wordDataService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/{kanji}")
    public List<Kanji> getEntryByKanji(@PathVariable("kanji") String kanji) {
        return wordDataService.getEntryByKanji(kanji);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/random")
    public List<Kanji> getRandomKanji() {
        return wordDataService.getRandomEntryByKanji();
    }
}
