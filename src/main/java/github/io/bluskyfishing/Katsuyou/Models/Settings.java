package github.io.bluskyfishing.Katsuyou.Models;

public class Settings {
    public boolean affirmative;
    public boolean negative;
    public boolean formal;
    public boolean informal;
    public boolean present;
    public boolean past;

    public Settings() {}

    public Settings(boolean affirmative, boolean negative, boolean formal,
                    boolean informal, boolean present, boolean past ) {
        this.affirmative = affirmative;
        this.negative = negative;
        this.formal = formal;
        this.informal = informal;
        this.present = present;
        this.past = past;
    }

    @Override
    public String toString() {
        return "{" +
                "\"affirmative\":" + affirmative +
                ", \"negative\":" + negative +
                ", \"formal\":" + formal +
                ", \"informal\":" + informal +
                ", \"present\":" + present +
                ", \"past\":" + past +
                '}';
    }
}
