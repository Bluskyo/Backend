package github.io.bluskyfishing.Katsuyou.EndpointControllers;

import github.io.bluskyfishing.Katsuyou.Models.DisplayKanji;
import github.io.bluskyfishing.Katsuyou.Services.WordDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordDataController {

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/random")
    public ResponseEntity<DisplayKanji> getWordData(){
        return ResponseEntity.status(HttpStatus.OK).body(new WordDataService().word());
    }

}
