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
            @RequestHeader(value = "entry") String encodedEntry,
            @RequestHeader(value = "reading") String encodedReading,
            @RequestHeader(value = "pos") String encodedPos) {

        String entry = URLDecoder.decode(encodedEntry, StandardCharsets.UTF_8);
        String reading = URLDecoder.decode(encodedReading, StandardCharsets.UTF_8);
        String pos = URLDecoder.decode(encodedPos, StandardCharsets.UTF_8);
        String tag = GetTag.GetTagFromPos(pos);

        return ResponseEntity.status(HttpStatus.OK).body(new SettingsService().ConjugationBasedOnSettings(entry, reading, tag, settings));
    }
}
