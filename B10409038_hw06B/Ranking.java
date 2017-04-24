import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.*;

/**
 * Created by B10409038 on 2017/4/24.
 */
public class Ranking {
    private Language[] lan = new Language[20];
    private StringBuffer sb = new StringBuffer();

    public void Construction_ObjArray() {
        for (int i = 0; i < 20; i++)
            lan[i] = new Language();
    }

    public void ReadFile() {
        try {
            FileReader fr = new FileReader("index.html");
            BufferedReader br = new BufferedReader(fr);
            String aLine;
            while ((aLine = br.readLine()) != null) {
                sb.append(aLine);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Findtraget() {
        Pattern traget = Pattern.compile("<table.*?table-top20.*?</table>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = traget.matcher(sb.toString());
        int Top = 1, words_count = 0;
        boolean search_nextsetdata = true;
        while (matcher.find()) {
            String tmp = matcher.group();
            tmp = tmp.replaceAll("<.*?>", "@").trim();
            StringTokenizer tokens = new StringTokenizer(tmp, "@");
            while (tokens.hasMoreTokens()) {
                String word = tokens.nextToken().toString();
                if (search_nextsetdata && word.equals(String.valueOf(Top))) {
                    lan[Top - 1].setRank(word);
                    words_count = 4;
                    search_nextsetdata = false;
                    continue;
                }
                if (words_count != 0) {
                    switch (words_count) {
                        case 3:
                            lan[Top - 1].setProgramming_Language(word);
                            break;
                        case 2:
                            lan[Top - 1].setRatings(word);
                            break;
                        case 1:
                            search_nextsetdata = true;
                            Top++;
                            break;
                    }
                    words_count--;
                }
            }
        }
    }

    public void WriteFile() {
        try {
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Rank\tProgramming Language\tRatings");
            bw.newLine();
            String aligned;
            for (int i = 0; i < 20; i++) {
                bw.write(lan[i].getRank() + "\t");
                if (lan[i].getProgramming_Language().length() > 12)
                    aligned = "\t";
                else if (lan[i].getProgramming_Language().length() >= 10)
                    aligned = "\t\t";
                else
                    aligned = "\t\t\t";
                bw.write(lan[i].getProgramming_Language() + aligned);
                bw.write(lan[i].getRatings());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
