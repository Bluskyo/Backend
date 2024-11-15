package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Methods.Conjugations;
import github.io.bluskyfishing.Katsuyou.Models.Settings;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettingsService {

    // Return 4 items (assertion, formality, tense, conjugation)
    // in case of conjugations where there's no formality returns 3 items.
    public Map<String, String> ConjugationBasedOnSettings(String kanji, String reading, String tag, Settings settings) {
        // decides on what assertion, formality, tense should be chosen, if multiple options are enabled.
        String assertion = getAssertion(settings);
        String formality = getFormality(settings);
        String tense = getTense(settings);

        // if multiple readings chooses first one.
        String oneReading = reading.split(",")[0];

        Map<String, String> conjugationInfo = new HashMap<>();

        conjugationInfo.put("tense", tense);
        if (!tense.equals("Volitional")) conjugationInfo.put("assertion", assertion);

        List<String> twoConjugations = Arrays.asList("Te-Form", "Causative Passive", "Imperative", "Conditional");
        if (!twoConjugations.contains(tense)) conjugationInfo.put("formality", formality);

        Map<String, String> conjugations = new HashMap<>();
        String conjugation = "";
        String hiraganaReading = "";
        
        // Gets appropriate conjugation based on tense chosen.
        switch (tense) {
            case "Present" -> conjugations = Conjugations.present(kanji, oneReading, tag);
            case "Past" -> conjugations = Conjugations.past(kanji, oneReading, tag);
            case "Te-Form" -> conjugations = Conjugations.teForm(kanji, oneReading, tag);
            case "Potential" -> conjugations = Conjugations.potential(kanji, oneReading, tag);
            case "Volitional" -> conjugations = Conjugations.volitional(kanji, oneReading, tag);
            case "Passive" -> conjugations = Conjugations.passive(kanji, oneReading, tag);
            case "Causative" -> conjugations = Conjugations.causative(kanji, oneReading, tag);
            case "Causative Passive" -> conjugations = Conjugations.causativePassive(kanji, oneReading, tag);
            case "Imperative" -> conjugations = Conjugations.imperative(kanji, oneReading, tag);
            case "Conditional" -> conjugations = Conjugations.conditional(kanji, oneReading, tag);
        }

        List<String> fourConjugations = Arrays.asList("Present", "Past", "Potential", "Passive", "Causative");

        assert conjugations != null;
        if (fourConjugations.contains(tense) && formality.equals("Informal") || twoConjugations.contains(tense)) {
            hiraganaReading = conjugations.get("Hiragana_" + assertion);
            conjugation = conjugations.get(assertion);
        } else if (fourConjugations.contains(tense) && formality.equals("Formal")) {
            hiraganaReading = conjugations.get("Hiragana_" + "Formal_" + assertion);
            conjugation = conjugations.get("Formal_" + assertion);
        } else if (tense.equals("Volitional")) {
            hiraganaReading = conjugations.get("Hiragana_" + formality);
            conjugation = conjugations.get(formality);
        }

        conjugationInfo.put("reading", hiraganaReading);
        conjugationInfo.put("conjugation", conjugation);

        return conjugationInfo;
    }

    private String getAssertion(Settings settings) {
        if (settings.affirmative && settings.negative){
            boolean assertion = new Random().nextBoolean();

            if (assertion)  return "Affirmative";
            else return "Negative";

        } else if (settings.affirmative) return "Affirmative";
        else if (settings.negative)  return  "Negative";

        return "";
    }

    private String getFormality(Settings settings) {

        if (settings.formal && settings.informal){
            boolean formal = new Random().nextBoolean();

            if (formal)  return  "Formal";
            else  return "Informal";

        } else if (settings.formal)  return "Formal";
        else if (settings.informal)  return "Informal";

        return "";
    }

    private String getTense(Settings settings) {
        List<String> possibleTenses = new ArrayList<>();

        if (settings.present) {possibleTenses.add("Present");}
        if (settings.past) {possibleTenses.add("Past");}
        if (settings.teForm) {possibleTenses.add("Te-Form");}
        if (settings.potential) {possibleTenses.add("Potential");}
        if (settings.volitional) {possibleTenses.add("Volitional");}
        if (settings.passive) {possibleTenses.add("Passive");}
        if (settings.causative) {possibleTenses.add("Causative");}
        if (settings.causativePassive) {possibleTenses.add("Causative Passive");}
        if (settings.imperative) {possibleTenses.add("Imperative");}
        if (settings.conditional) {possibleTenses.add("Conditional");}

        if (!possibleTenses.isEmpty())
        {
            int decide = new Random().nextInt(possibleTenses.size());
            return possibleTenses.get(decide);
        }

        return "";
    }
}
