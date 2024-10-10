package github.io.bluskyfishing.Katsuyou.EndpointControllers;

import github.io.bluskyfishing.Katsuyou.Models.Settings;
import github.io.bluskyfishing.Katsuyou.Services.SettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
public class SettingsController {

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping("/settings")
    public ResponseEntity<Map<String, String>> applySettings(

            // Get settings and kanji from apply settings.
            @RequestBody Settings settings,
            @RequestHeader(value = "Kanji", required = true) String encodedKanji,
            @RequestHeader(value = "Tag", required = true) String encodedTag) {

        String kanji = URLDecoder.decode(encodedKanji, StandardCharsets.UTF_8);
        String tag = URLDecoder.decode(encodedTag, StandardCharsets.UTF_8);

        System.out.println(encodedKanji);
        System.out.println("Received kanji: " + kanji);
        System.out.println("Received tag: " + tag);
        System.out.println("Received settings" + settings);

        return ResponseEntity.status(HttpStatus.OK).body(new SettingsService().ConjugationBasedOnSettings(kanji, tag, settings));
    }
}
