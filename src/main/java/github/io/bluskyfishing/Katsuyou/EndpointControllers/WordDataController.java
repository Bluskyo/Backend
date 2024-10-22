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
    @GetMapping("/{kanji}")
    public Kanji getEntryByKanji(@PathVariable("kanji") String kanji) {
        System.out.println(kanji);
        return wordDataService.getEntryByKanji(kanji);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/random")
    public Kanji getRandomKanji() {
        return wordDataService.getRandomEntryByKanji();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/allconjugations/{kanji}")
    public ResponseEntity<Map<String, Map<String, String>>> getAllConjugations(@PathVariable("kanji") String kanji){
        return ResponseEntity.status(HttpStatus.OK).body(wordDataService.getAllConjugations(kanji));
    }

    // Stops favicon from being sent when testing backend endpoints in browser.
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/favicon.ico")
    public ResponseEntity<Void> favicon() {
        return ResponseEntity.ok().build(); // Returns a blank response or could serve a favicon file if desired
    }
}
