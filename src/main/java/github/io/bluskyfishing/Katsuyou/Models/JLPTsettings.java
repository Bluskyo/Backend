package github.io.bluskyfishing.Katsuyou.Models;

public class JLPTsettings {
    public boolean N5;
    public boolean N4;
    public boolean N3;
    public boolean N2;
    public boolean N1;

    public JLPTsettings() {}

    public JLPTsettings(boolean N5, boolean N4, boolean N3, boolean N2, boolean N1) {
        this.N5 = N5;
        this.N4 = N4;
        this.N3 = N3;
        this.N2 = N2;
        this.N1 = N1;
    }

    @Override
    public String toString() {
        return "{" +
                "\"N5\":" + N5 +
                ", \"N4\":" + N3 +
                ", \"N3\":" + N4 +
                ", \"N2\":" + N2 +
                ", \"N1\":" + N1 +
                '}';
    }
}

