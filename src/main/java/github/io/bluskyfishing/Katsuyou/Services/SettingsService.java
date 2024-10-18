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
        if (settings.teForm) {possibleTenses.add("teForm");}
        if (settings.potential) {possibleTenses.add("potential");}
        if (settings.volitional) {possibleTenses.add("volitional");}
        if (settings.passive) {possibleTenses.add("passive");}
        if (settings.causative) {possibleTenses.add("causative");}
        if (settings.causativePassive) {possibleTenses.add("causativePassive");}
        if (settings.imperative) {possibleTenses.add("imperative");}
        if (settings.conditional) {possibleTenses.add("conditional");}

        if (!possibleTenses.isEmpty())
        {
            int decide = new Random().nextInt(possibleTenses.size());
            return possibleTenses.get(decide);
        }

        return "";
    }
}
