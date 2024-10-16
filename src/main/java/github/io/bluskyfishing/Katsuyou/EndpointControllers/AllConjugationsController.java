package github.io.bluskyfishing.Katsuyou.EndpointControllers;

import github.io.bluskyfishing.Katsuyou.Services.AllConjugationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AllConjugationsController {

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping("/allconjugations/{kanji}/{tag}")
    public ResponseEntity <Map<String, Map<String, String>>> getAllConjugations(@PathVariable("kanji") String kanji,
                                                                             @PathVariable("tag") String tag){

        return ResponseEntity.status(HttpStatus.OK).body(AllConjugationsService.addAllConjugations(kanji, tag));
    }

}
