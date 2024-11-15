package github.io.bluskyfishing.Katsuyou.Methods;

import java.util.HashMap;
import java.util.Map;

public class Conjugations {

    public static Map<String, String> present(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){ // Ru-Verbs
            String negative = wordStem + "ない";
            String formalAffirmative = wordStem + "ます";
            String formalNegative = wordStem + "ません";

            String hiraganaNegative = readingWordStem + "ない";
            String hiraganaFormalAffirmative = readingWordStem + "ます";
            String hiraganaFormalNegative = readingWordStem + "ません";

            conjugations.put("Affirmative", plainForm);
            conjugations.put("Negative", negative);
            conjugations.put("formal_affirmative", formalAffirmative);
            conjugations.put("formal_negative", formalNegative);

            conjugations.put("hiragana_affirmative", reading);
            conjugations.put("hiragana_negative", hiraganaNegative);
            conjugations.put("hiragana_formal_affirmative", hiraganaFormalAffirmative);
            conjugations.put("hiragana_formal_negative", hiraganaFormalNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){ // U-Verbs

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
            }

            String negative = wordStem + stem + "ない";
            String formalAffirmative = wordStem + formalStem + "ます";
            String formalNegative = wordStem + formalStem + "ません";

            String readingNegative = readingWordStem + stem + "ない";
            String readingFormalAffirmative = readingWordStem + formalStem + "ます";
            String readingFormalNegative = readingWordStem + formalStem + "ません";

            conjugations.put("Affirmative", plainForm);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", reading);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)) {
            conjugations.put("Affirmative", plainForm);
            conjugations.put("Negative", "来ない");
            conjugations.put("formal_affirmative", "来ます");
            conjugations.put("formal_negative", "来ませｎ");

            conjugations.put("hiragana_affirmative", reading);
            conjugations.put("hiragana_negative", "こない");
            conjugations.put("hiragana_formal_affirmative", "きます");
            conjugations.put("hiragana_formal_negative", "きません");

            return conjugations;
        } else if ("Suru".equals(tag)) { // Suru kanji almost never used, uses only hiragana.
            conjugations.put("Affirmative", reading);
            conjugations.put("Negative", "しない");
            conjugations.put("formal_affirmative", "します");
            conjugations.put("formal_negative", "しません");

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> past(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)) {

            String affirmative = wordStem + "た";
            String negative = wordStem + "なかった";
            String formalAffirmative = wordStem + "ました";
            String formalNegative = wordStem + "ませんでした";

            String readingAffirmative = readingWordStem + "た";
            String readingNegative = readingWordStem + "なかった";
            String readingFormalAffirmative = readingWordStem + "ました";
            String readingFormalNegative = readingWordStem + "ませんでした";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){

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
                        ending = "いた";
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
            String formalAffirmative = wordStem + formalStem + "ました";
            String formalNegative = wordStem + formalStem + "ませんでした";

            String readingAffirmative = readingWordStem + ending;
            String readingNegative = readingWordStem + stem + "なかった";
            String readingFormalAffirmative = readingWordStem + formalStem + "ました";
            String readingFormalNegative = readingWordStem + formalStem + "ませんでした";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){

            conjugations.put("Affirmative", "来た");
            conjugations.put("Negative", "来なかった");
            conjugations.put("Formal_Affirmative", "来ました");
            conjugations.put("Formal_Negative", "来ませんでした");

            conjugations.put("Hiragana_Affirmative", "きた");
            conjugations.put("Hiragana_Negative", "こなかった");
            conjugations.put("Hiragana_Formal_Affirmative", "きました");
            conjugations.put("Hiragana_Formal_Negative", "きませんでした");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "した");
            conjugations.put("Negative", "しなかった");
            conjugations.put("Formal_Affirmative", "しました");
            conjugations.put("Formal_Negative", "しませんでした");

            return conjugations;
        }

        return null;
    }

    // Returns only 2 conjugations.
    public static Map<String, String> teForm(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();

        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){

            String affirmative = wordStem + "て";
            String negative = wordStem + "なくて";
            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            String hiraganaAffirmative = readingWordStem + "て";
            String hiraganaNegative = readingWordStem + "なくて";
            conjugations.put("Hiragana_Affirmative", hiraganaAffirmative);
            conjugations.put("Hiragana_Negative", hiraganaNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){

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

            String hiragana_affirmative = readingWordStem + ending;
            String hiragana_negative = readingWordStem + "なくて";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", hiragana_affirmative);
            conjugations.put("Hiragana_Negative", hiragana_negative);

            return conjugations;
        } else if ("Kuru".equals(tag)) {
            conjugations.put("Affirmative", "来て");
            conjugations.put("Negative", "来てなくて");

            conjugations.put("Hiragana_Affirmative", "きて");
            conjugations.put("Hiragana_Negative", "きてなくて");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "して");
            conjugations.put("Negative", "しなくて");

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> potential(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String readingAffirmative = readingWordStem + "られる";
            String readingNegative = readingWordStem + "られない";
            String readingFormalAffirmative = readingWordStem + "られます";
            String readingFormalNegative = readingWordStem + "られません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
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

            String readingAffirmative = readingWordStem + stem + "る";
            String readingNegative = readingWordStem + stem + "ない";
            String readingFormalAffirmative = readingWordStem + stem + "ます";
            String readingFormalNegative = readingWordStem + stem + "ません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){
            conjugations.put("Affirmative", "来られる");
            conjugations.put("Negative", "来られない");
            conjugations.put("Formal_Affirmative", "来られます");
            conjugations.put("Formal_Negative", "来られません");

            conjugations.put("Hiragana_Affirmative", "こられる");
            conjugations.put("Hiragana_Negative", "こられない");
            conjugations.put("Hiragana_Formal_Affirmative", "こられます");
            conjugations.put("Hiragana_Formal_Negative", "こられません");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "できる");
            conjugations.put("Negative", "できない");
            conjugations.put("Formal_Affirmative", "できます");
            conjugations.put("Formal_Negative", "できません");

            return conjugations;
        }

        return null;
    }

    // returns only 2 conjugations (Formal/Informal).
    public static Map<String, String> volitional(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String informal = wordStem + "よう";
            String formal = wordStem + "ましょう";

            String hiraganaAffirmative = readingWordStem + "よう";
            String hiraganaNegative = readingWordStem + "ましょう";

            conjugations.put("Informal", informal);
            conjugations.put("Formal", formal);

            conjugations.put("Hiragana_Affirmative", hiraganaAffirmative);
            conjugations.put("Hiragana_Negative", hiraganaNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
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

            String informal = wordStem + stem + "う";
            String formal = wordStem + formalStem + "ましょう";

            String hiraganaAffirmative = readingWordStem + stem + "う";
            String hiraganaNegative = readingWordStem + formalStem + "ましょう";

            conjugations.put("Informal", informal);
            conjugations.put("Formal", formal);

            conjugations.put("Hiragana_Affirmative", hiraganaAffirmative);
            conjugations.put("Hiragana_Negative", hiraganaNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)) {
            conjugations.put("Informal", "来よう");
            conjugations.put("Formal", "来ましょう");

            conjugations.put("Hiragana_Informal", "こよう");
            conjugations.put("Hiragana_Formal", "きましょう");

            return conjugations;
        } else if ("Suru".equals(tag)) {
            conjugations.put("Informal", "しよう");
            conjugations.put("Formal", "しましょう");

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> passive(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1); //Creates string without last hiragana in word.
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "られる";
            String negative = wordStem + "られない";
            String formalAffirmative = wordStem + "られます";
            String formalNegative = wordStem + "られません";

            String readingAffirmative = readingWordStem + "られる";
            String readingNegative = readingWordStem + "られない";
            String readingFormalAffirmative = readingWordStem + "られます";
            String readingFormalNegative = readingWordStem + "られません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
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

            String readingAffirmative = readingWordStem +  stem + "れる";
            String readingNegative = readingWordStem + stem + "れない";
            String readingFormalAffirmative = readingWordStem + stem + "れます";
            String readingFormalNegative = readingWordStem + stem + "れません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)) {
            conjugations.put("Affirmative", "来られる");
            conjugations.put("Negative", "来られない");
            conjugations.put("Formal_Affirmative", "来られます");
            conjugations.put("Formal_Negative", "来られません");

            conjugations.put("Hiragana_Affirmative", "こられる");
            conjugations.put("Hiragana_Negative", "こられない");
            conjugations.put("Hiragana_Formal_Affirmative", "こられます");
            conjugations.put("Hiragana_Formal_Negative", "こられません");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "される");
            conjugations.put("Negative", "されない");
            conjugations.put("Formal_Affirmative", "されます");
            conjugations.put("Formal_Negative", "されませｎ");

            return conjugations;
        }

        return null;
    }

    public static Map<String, String> causative(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();
        String wordStem = plainForm.substring(0, plainForm.length() - 1);
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "させる";
            String negative = wordStem + "させない";
            String formalAffirmative = wordStem + "させます";
            String formalNegative = wordStem + "させません";

            String readingAffirmative = readingWordStem + "させる";
            String readingNegative = readingWordStem + "させない";
            String readingFormalAffirmative = readingWordStem + "させます";
            String readingFormalNegative = readingWordStem + "させません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
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

            String readingAffirmative = readingWordStem + stem + "せる";
            String readingNegative = readingWordStem + stem + "せない";
            String readingFormalAffirmative = readingWordStem + stem + "せます";
            String readingFormalNegative = readingWordStem + stem +  "せません";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);
            conjugations.put("Formal_Affirmative", formalAffirmative);
            conjugations.put("Formal_Negative", formalNegative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);
            conjugations.put("Hiragana_Formal_Affirmative", readingFormalAffirmative);
            conjugations.put("Hiragana_Formal_Negative", readingFormalNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){
            conjugations.put("Affirmative", "来させる");
            conjugations.put("Negative", "来させない");
            conjugations.put("Formal_Affirmative", "来させます");
            conjugations.put("Formal_Negative", "来させません");

            conjugations.put("Hiragana_Affirmative", "こさせる");
            conjugations.put("Hiragana_Negative", "こさせない");
            conjugations.put("Hiragana_Formal_Affirmative", "こさせます");
            conjugations.put("Hiragana_Formal_Negative", "こさせません");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "させる");
            conjugations.put("Negative", "させない");
            conjugations.put("Formal_Affirmative", "させます");
            conjugations.put("Formal_Negative", "させません");

            return conjugations;
        }

        return null;
    }

    // returns 2 conjugations.
    public static Map<String, String> causativePassive(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();

        String wordStem = plainForm.substring(0, plainForm.length() - 1);
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "せられる";
            String negative = wordStem + "せられない";

            String readingAffirmative = readingWordStem + "せられる";
            String readingNegative = readingWordStem + "せられない";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
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

            String readingAffirmative = readingWordStem + stem +"せられる";
            String readingNegative = readingWordStem + stem + "せられない";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){
            conjugations.put("Affirmative", "来させられる");
            conjugations.put("Negative", "来させられない");

            conjugations.put("Hiragana_Affirmative", "こさせられる");
            conjugations.put("Hiragana_Negative", "こさせられない");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "させられる");
            conjugations.put("Negative", "させられない");

            return conjugations;
        }

        return null;
    }

    // returns 2 conjugations.
    public static Map<String, String> imperative(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();

        String wordStem = plainForm.substring(0, plainForm.length() - 1);
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "ろ";
            String negative = wordStem + "な";

            String readingAffirmative = readingWordStem + "ろ";
            String readingNegative = readingWordStem + "な";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char ending = (char)nextHiragana;
            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> ending -= 1;
                case 'ぶ' -> ending = 'べ';
            }

            String affirmative = wordStem + ending;
            String negative = wordStem + hiragana + "な";

            String readingAffirmative = readingWordStem + ending;
            String readingNegative = readingWordStem + hiragana + "な";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){
            conjugations.put("Affirmative", "来い");
            conjugations.put("Negative", "来るな");

            conjugations.put("Hiragana_Affirmative", "こい");
            conjugations.put("Hiragana_Negative", "くるな");

            return conjugations;
        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "しろ");
            conjugations.put("Negative", "するな");

            return conjugations;
        }

        return null;
    }

    // returns 2 conjugations.
    public static Map<String, String> conditional(String plainForm, String reading, String tag){

        Map<String, String> conjugations = new HashMap<>();

        String wordStem = plainForm.substring(0, plainForm.length() - 1);
        String readingWordStem = reading.substring(0, reading.length() - 1);

        if ("Ichidan".equals(tag)){
            String affirmative = wordStem + "れば";
            String negative = wordStem + "なければ";

            String readingAffirmative = readingWordStem + "れば";
            String readingNegative = readingWordStem + "なければ";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Godan".equals(tag)){
            int nextHiragana = plainForm.charAt(plainForm.length() - 1 ) + 2; // finds next hiragana of conjugation.
            char nextStem = (char)nextHiragana;

            char hiragana = plainForm.charAt(plainForm.length() - 1);

            switch (hiragana) { // finds e equivalent hiragana.
                case 'ぬ','む', 'る' -> nextStem -= 1;
                case 'ぶ' -> nextStem = 'べ';
            }

            String affirmative = wordStem + nextStem + "ば";
            String negative = wordStem + nextStem + "なければ";

            String readingAffirmative = readingWordStem + nextStem + "ば";
            String readingNegative = readingWordStem + nextStem + "なければ";

            conjugations.put("Affirmative", affirmative);
            conjugations.put("Negative", negative);

            conjugations.put("Hiragana_Affirmative", readingAffirmative);
            conjugations.put("Hiragana_Negative", readingNegative);

            return conjugations;
        } else if ("Kuru".equals(tag)){
            conjugations.put("Affirmative", "来れば");
            conjugations.put("Negative", "来れなければ");

            conjugations.put("Hiragana_Affirmative", "くれば");
            conjugations.put("Hiragana_Negative", "こなければ");

            return conjugations;

        } else if ("Suru".equals(tag)){
            conjugations.put("Affirmative", "すれば");
            conjugations.put("Negative", "しなければ");
            return conjugations;
        }

        return null;
    }

}
