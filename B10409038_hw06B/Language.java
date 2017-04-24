/**
 * Created by B10409038 on 2017/4/24.
 */
public class Language {
    private String Rank;
    private String Programming_Language;
    private String Ratings;

    public void setRank(String top) {
        Rank = top;
    }

    public void setProgramming_Language(String name) {
        Programming_Language = name;
    }

    public void setRatings(String Use_ratio) {
        Ratings = Use_ratio;
    }

    public String getRank() {
        return Rank;
    }

    public String getProgramming_Language() {
        return Programming_Language;
    }

    public String getRatings() {
        return Ratings;
    }

}
