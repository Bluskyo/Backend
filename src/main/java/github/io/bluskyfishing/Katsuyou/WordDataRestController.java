package github.io.bluskyfishing.Katsuyou;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordDataRestController {
    @GetMapping("/")
    public ResponseEntity<Word> getWordData(){
        return ResponseEntity.status(HttpStatus.OK).body(new WordDataService().word());

    }

}
