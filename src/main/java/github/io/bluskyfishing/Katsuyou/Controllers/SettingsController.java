package github.io.bluskyfishing.Katsuyou.Controllers;

import github.io.bluskyfishing.Katsuyou.Models.Settings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
public class SettingsController {

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping("/settings")
    public ResponseEntity<String> applySettings(
            @RequestBody Settings settings,
            @RequestHeader(value = "Kanji", required = true) String encodedKanji) {

        String kanji = URLDecoder.decode(encodedKanji, StandardCharsets.UTF_8);

        System.out.println(encodedKanji);
        System.out.println("Received kanji: " + kanji);
        System.out.println("Received settings" + settings);

        return ResponseEntity.ok("OK");

        //return ResponseEntity.status(HttpStatus.OK).body();
    }
}
