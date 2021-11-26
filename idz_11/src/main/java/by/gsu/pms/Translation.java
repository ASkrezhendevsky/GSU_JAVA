package by.gsu.pms;

public enum Translation {
    RUS_TO_BEL("SELECT bel FROM rusbel WHERE rus = ?"),
    BEL_TO_RUS("SELECT rus FROM rusbel WHERE bel = ?");

    public static int WORD_PARAMETER = 0;

    private String query;

    Translation(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
