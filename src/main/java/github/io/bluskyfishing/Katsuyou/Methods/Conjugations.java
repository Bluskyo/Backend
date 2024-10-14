package github.io.bluskyfishing.Katsuyou.Methods;

import java.util.HashMap;
import java.util.Map;

public class Conjugations {

    public static Map<String, String> present(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || ("Suru verb".equals(tag) || "Kuru verb".equals(tag))){ // Ru-Verbs
            String negative = wordStem + "ない";
            String formalAffirmative = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            conjugations.put("affirmative", plainForm);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){ // U-Verbs

            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = plainForm.charAt(plainForm.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            // u, tsu, ru, mu verbs have different unicode than ku, gu, su verbs.
            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'う' -> stem  = 'わ';
                case 'つ' -> {
                    stem = 'た';
                    formalStem  = 'ち';
                }
                case 'る' -> {
                    stem = 'ら';
                    formalStem  = 'り';
                }
                case 'む' -> {
                    stem = 'ま';
                    formalStem  = 'み';
                }
                default -> {
                }
            }

            String negative = wordStem + stem + "ない";
            String formalAffirmative = wordStem + formalStem + "ます";
            String formalNegative = wordStem + formalStem + "ません";

            conjugations.put("affirmative", plainForm);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> past(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || ("Suru verb".equals(tag) || "Kuru verb".equals(tag))){
            String affirmative = wordStem + "た";
            String negative = wordStem + "なかった";
            String formalAffirmative = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = plainForm.charAt(plainForm.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            String ending = "";

            switch (hiragana) {
                case 'う' -> {
                    ending = "った";
                    stem = 'わ';
                    formalStem = 'い';
                }
                case 'く' ->{
                    if ("行".equals(wordStem)){ // 行った is an exception in this conjugation.
                        ending = "った";
                    }else{
                        ending = "いて";
                    }
                }
                case 'ぐ' -> ending = "いだ";
                case 'す' -> ending = "した";
                case 'つ' -> {
                    ending = "った";
                    stem = 'た';
                    formalStem = 'ち';
                }
                case 'ぬ', 'む'-> {
                    ending = "んだ";
                    stem += 2;
                    formalStem += 1;
                }
                case 'ぶ' -> {
                    ending = "んだ";
                    stem = 'ば';
                    formalStem = 'び';
                }
                case 'る' -> {
                    ending = "った";
                    stem = 'ら';
                    formalStem = 'り';
                }
                default -> {
                }

            }

            String affirmative = wordStem + ending;
            String negative = wordStem + stem + "なかった";
            String formalAffirmative = wordStem + formalStem +"ました";
            String formalNegative = wordStem + formalStem +"ませんでした";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    // Returns only 2 conjugations.
    public static Map<String, String> teForm(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag) ){

            String affirmative = wordStem + "て";
            String negative = wordStem + "なくて";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){

            char hiragana = plainForm.charAt(plainForm.length() - 1);
            String ending = "";

            switch (hiragana) {
                case 'す'-> ending = "して";
                case 'く'->{
                    if ("行".equals(wordStem)){ // 行って is an exception in this conjugation.
                        ending = "って";
                    }else{
                        ending = "いて";
                    }
                }
                case 'ぐ'-> ending = "いで";
                case 'ぬ', 'ぶ', 'む'-> ending = "んで";
                case 'う', 'つ', 'る' -> ending = "って";
            }

            String affirmative = wordStem + ending;
            String negative = wordStem + "なくて";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> potential(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> stem -= 1;
                case 'ぶ' -> stem = 'べ';
            }

            String affirmative = wordStem + stem + "る";
            String negative = wordStem + stem + "ない";
            String formalAffirmative = wordStem + stem + "ます";
            String formalNegative = wordStem + stem + "ません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "できる";
            String negative = "できない";
            String formalAffirmative = "できます";
            String formalNegative = "できません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    // returns only 2 conjugations.
    public static Map<String, String> volitional(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "よう";
            String negative = wordStem + "ましょう";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            int nextHiraganaFormal = plainForm.charAt(plainForm.length() - 1 ) - 2; // finds next hiragana of conjugation.
            char formalStem = (char)nextHiraganaFormal;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ', 'む', 'る'-> {
                    stem -= 2;
                    formalStem += 1;
                }
                case 'つ' -> formalStem  = 'ち';
                case 'ぶ' -> {
                    stem = 'ぼ';
                    formalStem = 'び';
                }
            }

            String affirmative = wordStem + stem + "う";
            String negative = wordStem + formalStem + "ましょう";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> passive(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> stem += 2;
                case 'ぶ' -> stem = 'ば';
                case 'う' -> stem = 'わ';
                case 'つ' -> stem = 'た';
            }

            String affirmative = wordStem + stem + "れる";
            String negative = wordStem + stem + "れない";
            String formalAffirmative = wordStem + stem + "れます";
            String formalNegative = wordStem + stem + "れません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "される";
            String negative = "されない";
            String formalAffirmative = "されます";
            String formalNegative = "されません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> causative(String plainForm, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "させる";
            String negative = wordStem + "させない";
            String formalAffirmative = wordStem + "させます";
            String formalNegative = wordStem + "させません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> stem += 2;
                case 'ぶ' -> stem = 'ば';
                case 'う' -> stem = 'わ';
                case 'つ' -> stem = 'た';
            }

            String affirmative = wordStem + stem + "せる";
            String negative = wordStem + stem + "せない";
            String formalAffirmative = wordStem + stem + "せます";
            String formalNegative = wordStem + stem + "せません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "させる";
            String negative = "させない";
            String formalAffirmative = "させます";
            String formalNegative = "させません";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    // returns 2 conjugations.
    public static Map<String, String> causativePassive(String plainForm, String tag){
        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "せられる";
            String negative = wordStem + "せられない";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> stem += 2;
                case 'ぶ' -> stem = 'ば';
                case 'う' -> stem = 'わ';
                case 'つ' -> stem = 'た';
            }

            String affirmative = wordStem + stem + "せられる";
            String negative = wordStem + stem + "せられない";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "させられる";
            String negative = "させられない";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> imperative(String plainForm, String tag){
        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag)){
            String affirmative = wordStem + "ろ";
            String negative = wordStem + "な";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char ending = (char)nextHiragana;
            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> ending -= 1;
                case 'ぶ' -> ending = 'べ';
            }

            String affirmative = wordStem + ending;
            String negative = wordStem + ending + "な";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Kuru verb".equals(tag)){
            String affirmative = "来い";
            String negative = "来るな";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }

        return null;
    }

    // returns 2 conjugations.
    public static Map<String, String> conditional(String plainForm, String tag){
        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "れば";
            String negative = wordStem + "なければ";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char nextStem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> nextStem -= 1;
                case 'ぶ' -> nextStem = 'べ';
            }

            String affirmative = wordStem + nextStem + "ば";
            String negative = wordStem + nextStem + "なければ";

            conjugations.put("affirmative", affirmative);
            conjugations.put("negative", negative);

            return conjugations;
        }

        return null;
    }

}
