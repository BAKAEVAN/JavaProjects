/**
 * Created by B10409038 on 2017/4/24.
 */
public class RankingTest {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        ranking.Construction_ObjArray();
        ranking.ReadFile();
        ranking.Findtraget();
        ranking.WriteFile();
        System.out.println("\nRankingTest\nThe program will soon be over. ...");
    }
}
