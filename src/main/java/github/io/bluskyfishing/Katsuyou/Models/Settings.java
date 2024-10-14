package github.io.bluskyfishing.Katsuyou.Models;

public class Settings {
    // Assertions
    public boolean affirmative;
    public boolean negative;
    // Formalities
    public boolean formal;
    public boolean informal;
    // Tenses
    public boolean present;
    public boolean past;
    public boolean teForm;
    public boolean potential;
    public boolean volitional;
    public boolean passive;
    public boolean causative;
    public boolean causativePassive;
    public boolean imperative;
    public boolean conditional;

    public Settings() {}

    public Settings(boolean affirmative, boolean negative, boolean formal,
                    boolean informal, boolean present, boolean past,
                    boolean teForm , boolean potential, boolean volitional,
                    boolean passive, boolean causative, boolean causativePassive,
                    boolean imperative, boolean conditional) {

        this.affirmative = affirmative;
        this.negative = negative;
        this.formal = formal;
        this.informal = informal;
        this.present = present;
        this.past = past;
        this.teForm = teForm;
        this.potential = potential;
        this.volitional = volitional;
        this.passive = passive;
        this.causative = causative;
        this.causativePassive = causativePassive;
        this.imperative = imperative;
        this.conditional = conditional;
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
                ", \"teForm\":" + teForm +
                ", \"potential\":" + potential +
                ", \"volitional\":" + volitional +
                ", \"passive\":" + passive +
                ", \"causative\":" + causative +
                ", \"causativePassive\":" + causativePassive +
                ", \"imperative\":" + imperative +
                ", \"conditional\":" + conditional +
                '}';
    }
}
