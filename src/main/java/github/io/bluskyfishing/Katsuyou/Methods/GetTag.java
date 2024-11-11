package github.io.bluskyfishing.Katsuyou.Methods;

import github.io.bluskyfishing.Katsuyou.Models.Kanji;

public class GetTag {

    public static String GetTagFromPos(Kanji word){
        String[] allTags = word.pos.split(",", 10);

        // Parse allTags with a method? Get Godan, Ichidan, Kuru, Suru verbs.
        for (String stringTags : allTags){
            if (stringTags.toLowerCase().contains("godan")) {
                return "Godan";
            } else if (stringTags.toLowerCase().contains("ichidan")) {
                return "Ichidan";
            } else if (stringTags.toLowerCase().contains("kuru")) {
               return "Kuru";
            } else if (stringTags.toLowerCase().contains("suru")) {
                return "Suru";
            }
        }
        return "NOT FOUND";
    }

    public static String GetTagFromPos(String word){
        String[] allTags = word.split(",", 10);
        // Parse allTags with a method? Get Godan, Ichidan, Kuru, Suru verbs.
        for (String stringTags : allTags){
            if (stringTags.toLowerCase().contains("godan")) {
                return "Godan";
            } else if (stringTags.toLowerCase().contains("ichidan")) {
                return "Ichidan";
            } else if (stringTags.toLowerCase().contains("kuru")) {
                return "Kuru";
            } else if (stringTags.toLowerCase().contains("suru")) {
                return "Suru";
            }
        }
        return "NOT FOUND";
    }
}
