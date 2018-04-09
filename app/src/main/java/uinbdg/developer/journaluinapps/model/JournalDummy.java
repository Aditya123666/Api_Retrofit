package uinbdg.developer.journaluinapps.model;

/**
 * Created by Nikko Eka Saputra on 13/02/2018.
 */

public class JournalDummy {

    private String judul;
    private int coverId;
    private String lastIssue;
    private String issn;

    public JournalDummy(String judul, int coverId, String lastIssue, String issn) {
        this.judul = judul;
        this.coverId = coverId;
        this.lastIssue = lastIssue;
        this.issn = issn;
    }

    public String getJudul() {
        return judul;
    }

    public int getCoverId() {
        return coverId;
    }

    public String getLastIssue() {
        return lastIssue;
    }

    public String getIssn() {
        return issn;
    }
}
