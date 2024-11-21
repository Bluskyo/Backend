package github.io.bluskyfishing.Katsuyou.Methods;

import github.io.bluskyfishing.Katsuyou.Models.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetJLPT {
    public static String getJLPTLevel(Settings settings){
        List<String> possibleLevels = new ArrayList<>();

        if (settings != null){
            if (settings.N5) possibleLevels.add("N5");
            if (settings.N4) possibleLevels.add("N4");
            if (settings.N3) possibleLevels.add("N3");
            if (settings.N2) possibleLevels.add("N2");
            if (settings.N1) possibleLevels.add("N1");
        }

        if (!possibleLevels.isEmpty())
        {
            int decide = new Random().nextInt(possibleLevels.size());
            return possibleLevels.get(decide);
        } else return "";
    }
}
