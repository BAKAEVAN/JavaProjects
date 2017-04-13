/**
 * Created by B10409038 on 2017/4/12.
 */
public class ID {
    private String id;
    private String area;
    private int area_code;
    private String gender;
    private int[] id_make = new int[9];
    private char alphabet;

    public boolean format_confirm(String input) {
        if (!input.matches("[A-Z]{1}[1-2]{1}[0-9]{8}")) {
            System.out.println("格式不符\n");
            return true;
        } else {
            id = input;
            alphabet_to_area(id.charAt(0));
            check_gender(id.charAt(1));
        }
        return false;
    }

    public void check() {
        int sum = 0;
        sum += area_code / 10;
        sum += area_code % 10 * 9;
        for (int i = 1; i <= 8; i++) {
            int n = id.charAt(i) - 48;
            sum += n * (9 - i);
        }
        sum += id.charAt(9) - 48;
        if (sum % 10 == 0)
            System.out.printf("身份證字號正確\n" +
                    "是位出生在%s的%s生喔\n\n", area, gender);
        else
            System.out.println("身份證字號錯誤\n");
    }

    public void generate() {
        int sum = 0;
        sum += area_code / 10;
        sum += area_code % 10 * 9;
        sum += id_make[0] * 8;
        for (int i = 1; i <= 7; i++) {
            id_make[i] = (int) (Math.random() * 10);
            sum += id_make[i] * (8 - i);
        }
        do {
            id_make[8] = (int) (Math.random() * 10);
        } while ((sum + id_make[8]) % 10 != 0);
        StringBuffer ID_generate = new StringBuffer();
        ID_generate.append(alphabet);
        for (int i = 0; i <= 8; i++)
            ID_generate.append(id_make[i]);
        id = ID_generate.toString();
        System.out.printf("產生的身分證字號為: %s\n", id);
    }

    public void check_gender(char id_gender) {
        if (id_gender == '1')
            gender = "男";
        else
            gender = "女";
    }

    public void alphabet_to_area(char ABC) {
        switch (ABC) {
            case 'A':
                area = "台北市";
                area_code = 10;
                break;
            case 'B':
                area = "台中市";
                area_code = 11;
                break;
            case 'C':
                area = "基隆市";
                area_code = 12;
                break;
            case 'D':
                area = "台南市";
                area_code = 13;
                break;
            case 'E':
                area = "高雄市";
                area_code = 14;
                break;
            case 'F':
                area = "台北縣";
                area_code = 15;
                break;
            case 'G':
                area = "宜蘭縣";
                area_code = 16;
                break;
            case 'H':
                area = "桃園縣";
                area_code = 17;
                break;
            case 'I':
                area = "嘉義市";
                area_code = 34;
                break;
            case 'J':
                area = "新竹縣";
                area_code = 18;
                break;
            case 'K':
                area = "苗栗縣";
                area_code = 19;
                break;
            case 'L':
                area = "台中縣";
                area_code = 20;
                break;
            case 'M':
                area = "南投縣";
                area_code = 21;
                break;
            case 'N':
                area = "彰化縣";
                area_code = 22;
                break;
            case 'O':
                area = "新竹市";
                area_code = 35;
                break;
            case 'P':
                area = "雲林縣";
                area_code = 23;
                break;
            case 'Q':
                area = "嘉義縣";
                area_code = 24;
                break;
            case 'R':
                area = "台南線";
                area_code = 25;
                break;
            case 'S':
                area = "高雄縣";
                area_code = 26;
                break;
            case 'T':
                area = "屏東縣";
                area_code = 27;
                break;
            case 'U':
                area = "花蓮縣";
                area_code = 28;
                break;
            case 'V':
                area = "台東縣";
                area_code = 29;
                break;
            case 'W':
                area = "金門縣";
                area_code = 32;
                break;
            case 'X':
                area = "澎湖縣";
                area_code = 30;
                break;
            case 'Y':
                area = "陽明山";
                area_code = 31;
                break;
            case 'Z':
                area = "連江縣";
                area_code = 33;
                break;
        }
    }

    public boolean gender_to_code(String input) {
        if (input.equals("男")) {
            id_make[0] = 1;
        } else if (input.equals("女")) {
            id_make[0] = 2;
        } else
            return true;
        gender = input;
        return false;
    }

    public boolean area_to_alphabet(String place) {
        switch (place) {
            case "台北市":
                alphabet = 'A';
                break;
            case "臺北市":
                alphabet = 'A';
                break;
            case "台中市":
                alphabet = 'B';
                break;
            case "臺中市":
                alphabet = 'B';
                break;
            case "基隆市":
                alphabet = 'C';
                break;
            case "台南市":
                alphabet = 'D';
                break;
            case "臺南市":
                alphabet = 'D';
                break;
            case "高雄市":
                alphabet = 'E';
                break;
            case "台北縣":
                alphabet = 'F';
                break;
            case "臺北縣":
                alphabet = 'F';
                break;
            case "宜蘭縣":
                alphabet = 'G';
                break;
            case "桃園縣":
                alphabet = 'H';
                break;
            case "嘉義市":
                alphabet = 'I';
                break;
            case "新竹縣":
                alphabet = 'J';
                break;
            case "苗栗縣":
                alphabet = 'K';
                break;
            case "台中縣":
                alphabet = 'L';
                break;
            case "臺中縣":
                alphabet = 'L';
                break;
            case "南投縣":
                alphabet = 'M';
                break;
            case "彰化縣":
                alphabet = 'N';
                break;
            case "新竹市":
                alphabet = 'O';
                break;
            case "雲林縣":
                alphabet = 'P';
                break;
            case "嘉義縣":
                alphabet = 'Q';
                break;
            case "台南線":
                alphabet = 'R';
                break;
            case "臺南線":
                alphabet = 'R';
                break;
            case "高雄縣":
                alphabet = 'S';
                break;
            case "屏東縣":
                alphabet = 'T';
                break;
            case "花蓮縣":
                alphabet = 'U';
                break;
            case "台東縣":
                alphabet = 'V';
                break;
            case "臺東縣":
                alphabet = 'V';
                break;
            case "金門縣":
                alphabet = 'W';
                break;
            case "澎湖縣":
                alphabet = 'X';
                break;
            case "陽明山":
                alphabet = 'Y';
                break;
            case "連江縣":
                alphabet = 'Z';
                break;
            default:
                return true;
        }
        alphabet_to_area(alphabet);
        return false;
    }
}
