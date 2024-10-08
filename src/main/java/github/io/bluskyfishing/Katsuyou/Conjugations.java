package github.io.bluskyfishing.Katsuyou;

import java.util.HashMap;
import java.util.Map;

public class Conjugations {

    public static Map<String, String> present(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || ("Suru verb".equals(pos) || "Kuru verb".equals(pos))){ // Ru-Verbs
            String informalNegative = wordStem + "ない";
            String formalPositive = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            Map<String, String> conjugations = new HashMap<>();

            conjugations.put("plainForm", plainForm);
            conjugations.put("informalNegative", informalNegative);
            conjugations.put("formalPositive", formalPositive);
            conjugations.put("formalNegative", formalNegative);

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){ // U-Verbs

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

            String informalNegative = wordStem + stem + "ない";
            String formalPositive = wordStem + formalStem + "ます";
            String formalNegative = wordStem + formalStem + "ません";

            Map<String, String> conjugations = new HashMap<>();

            conjugations.put("plainForm", plainForm);
            conjugations.put("informalNegative", informalNegative);
            conjugations.put("formalPositive", formalPositive);
            conjugations.put("formalNegative", formalNegative);

            return conjugations;
        }

        return null;
    }

    public static String[] past(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || ("Suru verb".equals(pos) || "Kuru verb".equals(pos))){
            String informalPlain = wordStem + "た";
            String informalNegative = wordStem + "なかった";
            String formalPositive = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){

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

            String informalPlain = wordStem + ending;
            String informalNegative = wordStem + stem + "なかった";
            String formalPositive = wordStem + formalStem +"ました";
            String formalNegative = wordStem + formalStem +"ませんでした";

            String[] conjugations = {informalPlain, informalNegative, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] teForm(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Suru verb".equals(pos) || "Kuru verb".equals(pos) ){

            String positiveForm = wordStem + "て";
            String negativeForm = wordStem + "なくて";
            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;

        }
        else if ("Godan verb".equals(pos)){

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

            String positiveForm = wordStem + ending;
            String negativeForm = wordStem + "なくて";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }

    public static String[] potential(String plainForm, String pos){

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "られる";
            String negativeForm = wordStem + "られない";
            String formalPositive = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + stem + "る";
            String negativeForm = wordStem + stem + "ない";
            String formalPositive = wordStem + stem + "ます";
            String formalNegative = wordStem + stem + "ません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(pos)){
            String positiveForm = "できる";
            String negativeForm = "できない";
            String formalPositive = "できます";
            String formalNegative = "できません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] volitional(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Suru verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "よう";
            String negativeForm = wordStem + "ましょう";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + stem + "う";
            String negativeForm = wordStem + formalStem + "ましょう";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }

    public static String[] passive(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "られる";
            String negativeForm = wordStem + "られない";
            String formalPositive = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + stem + "れる";
            String negativeForm = wordStem + stem + "れない";
            String formalPositive = wordStem + stem + "れます";
            String formalNegative = wordStem + stem + "れません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(pos)){
            String positiveForm = "される";
            String negativeForm = "されない";
            String formalPositive = "されます";
            String formalNegative = "されません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] causative(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "させる";
            String negativeForm = wordStem + "させない";
            String formalPositive = wordStem + "させます";
            String formalNegative = wordStem + "させません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + stem + "せる";
            String negativeForm = wordStem + stem + "せない";
            String formalPositive = wordStem + stem + "せます";
            String formalNegative = wordStem + stem + "せません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Suru verb".equals(pos)){
            String positiveForm = "させる";
            String negativeForm = "させない";
            String formalPositive = "させます";
            String formalNegative = "させません";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] causativePassive(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1);

        if ("Ichidan verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "せられる";
            String negativeForm = wordStem + "せられない";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + stem + "せられる";
            String negativeForm = wordStem + stem + "せられない";


            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }
        else if ("Suru verb".equals(pos)){
            String positiveForm = "させられる";
            String negativeForm = "させられない";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }

    public static String[] imperative(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Suru verb".equals(pos)){
            String positiveForm = wordStem + "ろ";
            String negativeForm = wordStem + "な";
            String formalPositive = wordStem + "てください"; // te form
            String formalNegative = wordStem + "ないでください";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            // te form for positive formal.
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

            String positiveForm = wordStem + ending;
            String negativeForm = wordStem + ending + "な";
            String formalPositive = wordStem + teFrom + "ください";
            String formalNegative = wordStem + formalStem + "ないください";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }
        else if ("Kuru verb".equals(pos)){
            String positiveForm = "来い";
            String negativeForm = "来るな";
            String formalPositive = "来てください";
            String formalNegative = "来ないでください";

            String[] conjugations = {positiveForm, negativeForm, formalPositive, formalNegative};

            return conjugations;
        }

        return null;
    }

    public static String[] conditional(String plainForm, String pos){
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.

        if ("Ichidan verb".equals(pos) || "Suru verb".equals(pos) || "Kuru verb".equals(pos)){
            String positiveForm = wordStem + "れば";
            String negativeForm = wordStem + "なければ";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }
        else if ("Godan verb".equals(pos)){
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

            String positiveForm = wordStem + nextStem + "ば";
            String negativeForm = wordStem + nextStem + "なければ";

            String[] conjugations = {positiveForm, negativeForm};

            return conjugations;
        }

        return null;
    }

}
