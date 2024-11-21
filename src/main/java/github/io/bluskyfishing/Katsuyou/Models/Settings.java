package github.io.bluskyfishing.Katsuyou.Models;

public class Settings {
    // JLPT level
    public boolean N5;
    public boolean N4;
    public boolean N3;
    public boolean N2;
    public boolean N1;
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

    public Settings(boolean N5, boolean N4, boolean N3, boolean N2, boolean N1,
                    boolean affirmative, boolean negative, boolean formal,
                    boolean informal, boolean present, boolean past,
                    boolean teForm , boolean potential, boolean volitional,
                    boolean passive, boolean causative, boolean causativePassive,
                    boolean imperative, boolean conditional) {

        this.N5 = N5;
        this.N4 = N4;
        this.N3 = N3;
        this.N2 = N2;
        this.N1 = N1;
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
                "\"N5\":" + N5 +
                ", \"N4\":" + N3 +
                ", \"N3\":" + N4 +
                ", \"N2\":" + N2 +
                ", \"N1\":" + N1 +
                ", \"affirmative\":" + affirmative +
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
