package github.io.bluskyfishing.Katsuyou.Methods;

import java.util.HashMap;
import java.util.Map;

public class Conjugations {

    public static Map<String, String> present(String plainForm, String tag){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || ("Suru verb".equals(tag) || "Kuru verb".equals(tag))){ // Ru-Verbs
            String negative = wordStem + "ない";
            String formalAffirmative = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            Map<String, String> conjugations = new HashMap<>();

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

            Map<String, String> conjugations = new HashMap<>();

            conjugations.put("affirmative", plainForm);
            conjugations.put("negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            return conjugations;
        }

        return null;
    }

    public static String[] past(String plainForm, String tag){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || ("Suru verb".equals(tag) || "Kuru verb".equals(tag))){
            String affirmative = wordStem + "た";
            String negative = wordStem + "なかった";
            String formalAffirmative = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

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
                case 'ぐ' -> {
                    ending = "いだ";
                }
                case 'す' -> {
                    ending = "した";
                }
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

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] teForm(String plainForm, String tag){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag) ){

            String affirmative = wordStem + "て";
            String negative = wordStem + "なくて";
            String[] conjugations = {affirmative, negative};

            return conjugations;

        }
        else if ("Godan verb".equals(tag)){

            char hiragana = plainForm.charAt(plainForm.length() - 1);
            String ending = "";

            switch (hiragana) {
                case 'す'->{
                    ending = "して";
                }
                case 'く'->{
                    if ("行".equals(wordStem)){ // 行って is an exception in this conjugation.
                        ending = "って";
                    }else{
                        ending = "いて";
                    }
                }
                case 'ぐ'->{
                    ending = "いで";
                }
                case 'ぬ', 'ぶ', 'む'->{
                    ending = "んで";
                }
                case 'う', 'つ', 'る' ->{
                    ending = "って";
                }
            }

            String affirmative = wordStem + ending;
            String negative = wordStem + "なくて";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }

        return null;
    }

    public static String[] potential(String plainForm, String tag){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> {
                    stem -= 1;
                }
                case 'ぶ' -> {
                    stem = 'べ';
                }
            }

            String affirmative = wordStem + stem + "る";
            String negative = wordStem + stem + "ない";
            String formalAffirmative = wordStem + stem + "ます";
            String formalNegative = wordStem + stem + "ません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "できる";
            String negative = "できない";
            String formalAffirmative = "できます";
            String formalNegative = "できません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] volitional(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "よう";
            String negative = wordStem + "ましょう";

            String[] conjugations = {affirmative, negative};

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
                case 'つ' -> {
                    formalStem  = 'ち';
                }
                case 'ぶ' -> {
                    stem = 'ぼ';
                    formalStem = 'び';
                }
            }

            String affirmative = wordStem + stem + "う";
            String negative = wordStem + formalStem + "ましょう";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }

        return null;
    }

    public static String[] passive(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> {
                    stem += 2;
                }
                case 'ぶ' -> {
                    stem = 'ば';
                }
                case 'う' -> {
                    stem = 'わ';
                }
                case 'つ' -> {
                    stem = 'た';
                }
            }

            String affirmative = wordStem + stem + "れる";
            String negative = wordStem + stem + "れない";
            String formalAffirmative = wordStem + stem + "れます";
            String formalNegative = wordStem + stem + "れません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "される";
            String negative = "されない";
            String formalAffirmative = "されます";
            String formalNegative = "されません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] causative(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "させる";
            String negative = wordStem + "させない";
            String formalAffirmative = wordStem + "させます";
            String formalNegative = wordStem + "させません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> {
                    stem += 2;
                }
                case 'ぶ' -> {
                    stem = 'ば';
                }
                case 'う' -> {
                    stem = 'わ';
                }
                case 'つ' -> {
                    stem = 'た';
                }
            }

            String affirmative = wordStem + stem + "せる";
            String negative = wordStem + stem + "せない";
            String formalAffirmative = wordStem + stem + "せます";
            String formalNegative = wordStem + stem + "せません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "させる";
            String negative = "させない";
            String formalAffirmative = "させます";
            String formalNegative = "させません";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] causativePassive(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "せられる";
            String negative = wordStem + "せられない";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char stem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) {
                case 'ぬ','む', 'る' -> {
                    stem += 2;
                }
                case 'ぶ' -> {
                    stem = 'ば';
                }
                case 'う' -> {
                    stem = 'わ';
                }
                case 'つ' -> {
                    stem = 'た';
                }
            }

            String affirmative = wordStem + stem + "せられる";
            String negative = wordStem + stem + "せられない";


            String[] conjugations = {affirmative, negative};

            return conjugations;
        }
        else if ("Suru verb".equals(tag)){
            String affirmative = "させられる";
            String negative = "させられない";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }

        return null;
    }

    public static String[] imperative(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag)){
            String affirmative = wordStem + "ろ";
            String negative = wordStem + "な";
            String formalAffirmative = wordStem + "てください"; // te form
            String formalNegative = wordStem + "ないでください";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char ending = (char)nextHiragana;

            int formalNextHiragana = plainForm.charAt(plainForm.length() - 1 ) - 4; // finds next hiragana of conjugation.
            char formalStem = (char)formalNextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> {
                    ending -= 1;
                }
                case 'ぶ' -> {
                    ending = 'べ';
                }
            }

            // te form for affirmative formal.
            String teFrom = "";

            switch (hiragana) {
                case 'す'->{
                    teFrom = "して";
                }
                case 'く'->{
                    if ("行".equals(wordStem)){ // 行って is an exception in this conjugation.
                        teFrom = "って";
                    }else{
                        teFrom = "いて";
                    }
                }
                case 'ぐ'->{
                    teFrom = "いで";
                }
                case 'ぬ', 'ぶ', 'む'->{
                    teFrom = "んで";
                }
                case 'う', 'つ', 'る' ->{
                    teFrom = "って";
                }
            }

            // te form for negative
            switch (hiragana) {
                case 'ぬ','む', 'る' -> {
                    formalStem += 2;
                }
                case 'ぶ' -> {
                    formalStem = 'ば';
                }
                case 'う' -> {
                    formalStem = 'わ';
                }
                case 'つ' -> {
                    formalStem = 'た';
                }
            }

            String affirmative = wordStem + ending;
            String negative = wordStem + ending + "な";
            String formalAffirmative = wordStem + teFrom + "ください";
            String formalNegative = wordStem + formalStem + "ないください";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }
        else if ("Kuru verb".equals(tag)){
            String affirmative = "来い";
            String negative = "来るな";
            String formalAffirmative = "来てください";
            String formalNegative = "来ないでください";

            String[] conjugations = {affirmative, negative, formalAffirmative, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] conditional(String plainForm, String tag){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(tag) || "Suru verb".equals(tag) || "Kuru verb".equals(tag)){
            String affirmative = wordStem + "れば";
            String negative = wordStem + "なければ";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }
        else if ("Godan verb".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char nextStem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> {
                    nextStem -= 1;
                }
                case 'ぶ' -> {
                    nextStem = 'べ';
                }
            }

            String affirmative = wordStem + nextStem + "ば";
            String negative = wordStem + nextStem + "なければ";

            String[] conjugations = {affirmative, negative};

            return conjugations;
        }

        return null;
    }

}
