package github.io.bluskyfishing.Katsuyou.EndpointControllers;

import github.io.bluskyfishing.Katsuyou.Methods.GetTag;
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
    @PostMapping("/api/settings")
    public ResponseEntity<Map<String, String>> applySettings(

            // Get settings and kanji from apply settings.
            @RequestBody Settings settings,
            @RequestHeader(value = "entry", required = true) String encodedEntry,
            @RequestHeader(value = "pos", required = true) String encodedPos) {

        String entry = URLDecoder.decode(encodedEntry, StandardCharsets.UTF_8);
        String pos = URLDecoder.decode(encodedPos, StandardCharsets.UTF_8);
        String tag = GetTag.GetTagFromPos(pos);

        // System.out.println(encodedKanji);
        // System.out.println("Received kanji: " + entry);
        // System.out.println("Received tag: " + tag);
        // System.out.println("Received settings" + settings);

        return ResponseEntity.status(HttpStatus.OK).body(new SettingsService().ConjugationBasedOnSettings(entry, tag, settings));
    }
}
