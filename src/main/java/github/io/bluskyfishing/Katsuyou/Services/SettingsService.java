package github.io.bluskyfishing.Katsuyou.Services;

import github.io.bluskyfishing.Katsuyou.Methods.Conjugations;
import github.io.bluskyfishing.Katsuyou.Models.Settings;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettingsService {

    // Return 4 items (assertion, formality, tense, conjugation)
    // in case of conjugations where there's no formality returns 3 items.
    public Map<String, String> ConjugationBasedOnSettings(String kanji, String tag, Settings settings) {
        // decides on what assertion, formality, tense should be chosen, if multiple options are enabled.
        String assertion = getAssertion(settings);
        String formality = getFormality(settings);
        String tense = getTense(settings);

        Map<String, String> conjugationInfo = new HashMap<>();
        conjugationInfo.put("assertion", assertion);
        conjugationInfo.put("tense", tense);

        List<String> twoConjugations = Arrays.asList("teForm", "volitional", "causativePassive", "imperative", "conditional");
        if (!twoConjugations.contains(tense)) conjugationInfo.put("formality", formality);

        Map<String, String> conjugations = new HashMap<>();
        String conjugation;
        
        // Gets appropriate conjugation based on tense chosen.
        switch (tense) {
            case "present" -> conjugations = Conjugations.present(kanji, tag);
            case "past" -> conjugations = Conjugations.past(kanji, tag);
            case "teForm" -> conjugations = Conjugations.teForm(kanji, tag);
            case "potential" -> conjugations = Conjugations.potential(kanji, tag);
            case "volitional" -> conjugations = Conjugations.volitional(kanji, tag);
            case "passive" -> conjugations = Conjugations.passive(kanji, tag);
            case "causative" -> conjugations = Conjugations.causative(kanji, tag);
            case "causativePassive" -> conjugations = Conjugations.causativePassive(kanji, tag);
            case "imperative" -> conjugations = Conjugations.imperative(kanji, tag);
            case "conditional" -> conjugations = Conjugations.conditional(kanji, tag);
        }

        assert conjugations != null;
        if (formality.equals("informal") || twoConjugations.contains(tense)) {
            conjugation = conjugations.get(assertion);
        }
        else conjugation = conjugations.get("formal"+ "_" + assertion);

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
