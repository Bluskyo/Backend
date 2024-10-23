package github.io.bluskyfishing.Katsuyou.Methods;

import github.io.bluskyfishing.Katsuyou.Models.Kanji;

public class GetTag {

    public static String GetTagFromPos(Kanji word){
        String[] allTags = word.pos.split(",", 10);

        // Parse allTags with a method? Get Godan, Ichidan, Kuru, Suru verbs.
        for (String stringTags : allTags){
            if (stringTags.contains("Godan")) {
                return "Godan";
            } else if (stringTags.contains("Ichidan")) {
                return "Ichidan";
            } else if (stringTags.contains("Kuru")) {
               return "Kuru";
            } else if (stringTags.contains("Suru")) {
                return "Suru";
            }
        }
        return "NOT FOUND";
    }

    public static String GetTagFromPos(String word){
        String[] allTags = word.split(",", 10);
        // Parse allTags with a method? Get Godan, Ichidan, Kuru, Suru verbs.
        for (String stringTags : allTags){
            if (stringTags.contains("Godan")) {
                return "Godan";
            } else if (stringTags.contains("Ichidan")) {
                return "Ichidan";
            } else if (stringTags.contains("Kuru")) {
                return "Kuru";
            } else if (stringTags.contains("Suru")) {
                return "Suru";
            }
        }
        return "NOT FOUND";
    }
}