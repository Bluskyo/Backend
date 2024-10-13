package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Methods.Conjugations;
import github.io.bluskyfishing.Katsuyou.Models.Settings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.random;

@Service
public class SettingsService {

    // Return 4 items (assertion, formality, tense, conjugation,)
    public Map<String, String> ConjugationBasedOnSettings(String kanji, String tag, Settings settings) {

        Map<String, String> conjugationInfo = new HashMap<>();

        String assertion = getAssertion(settings);
        String formality = getFormality(settings);
        String tense = getTense(settings);

        conjugationInfo.put("assertion", assertion);
        conjugationInfo.put("formality", formality);
        conjugationInfo.put("tense", tense);

        if (tense.equals("present")){
            Map<String, String> presentConjugations = Conjugations.present(kanji, tag);
             String conjugation = "";

            if (formality.equals("informal"))  conjugation = presentConjugations.get(assertion);
            else conjugation = presentConjugations.get("formal"+ "_" + assertion); // look at this later. "_"

            conjugationInfo.put("conjugation", conjugation);
        }

        return conjugationInfo;
    }

    private String getAssertion(Settings settings) {
        if (settings.affirmative && settings.negative){
            boolean assertion = new Random().nextBoolean();

            if (assertion)  return "affirmative";
            else return "negative";

        } else if (settings.affirmative) return "affirmative";
        else if (settings.negative)  return  "negative";

        return "";
    }

    private String getFormality(Settings settings) {

        if (settings.formal && settings.informal){
            boolean formal = new Random().nextBoolean();

            if (formal)  return  "formal";
            else  return "informal";

        } else if (settings.formal)  return "formal";
        else if (settings.informal)  return "informal";

        return "";
    }

    private String getTense(Settings settings) {
        List<String> possibleTenses = new ArrayList<>();

        if (settings.present) {possibleTenses.add("present");}
        if (settings.past) {possibleTenses.add("past");}

        if (!possibleTenses.isEmpty())
        {
            int decide = new Random().nextInt(possibleTenses.size());
            return possibleTenses.get(decide);
        }
        return "";
    }
}
