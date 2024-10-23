package github.io.bluskyfishing.Katsuyou.EndpointControllers;
import github.io.bluskyfishing.Katsuyou.Models.Kanji;
import github.io.bluskyfishing.Katsuyou.Services.WordDataService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WordDataController {

    private final WordDataService wordDataService;

    // Constructor injection for WordDataService
    public WordDataController(WordDataService wordDataService) {
        this.wordDataService = wordDataService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/api/{kanji}")
    public Kanji getEntryByKanji(@PathVariable("kanji") String kanji) {
        return wordDataService.getEntryByKanji(kanji);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/api/random")
    public Kanji getRandomKanji() {
        return wordDataService.getRandomEntryByKanji();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/api/allConjugations/{kanji}")
    public ResponseEntity<Map<String, Map<String, String>>> getAllConjugations(@PathVariable("kanji") String kanji){
        return ResponseEntity.status(HttpStatus.OK).body(wordDataService.getAllConjugations(kanji));
    }
    
}
