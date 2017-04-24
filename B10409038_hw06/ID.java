/**
 * Created by B10409038 on 2017/4/24.
 */
public class ID {
    private String id;
    private String area;
    private int area_code;
    private String gender;
    private String error;

    public boolean format_confirm(String input) {
        if (!input.matches("[A-Z]{1}[1-2]{1}[0-9]{8}")) {
            id = input;
            error = "�榡����";
        } else {
            id = input;
            alphabet_to_area(id.charAt(0));
            check_gender(id.charAt(1));
            return true;
        }
        return false;
    }

    public boolean check(String input) {
        if (!format_confirm(input))
            return false;
        int sum = 0;
        sum += area_code / 10;
        sum += area_code % 10 * 9;
        for (int i = 1; i <= 8; i++) {
            int n = id.charAt(i) - 48;
            sum += n * (9 - i);
        }
        sum += id.charAt(9) - 48;
        if (sum % 10 == 0)
            return true;
        else
            error = "�����Ҧr�����~";
        return false;
    }

    public void alphabet_to_area(char ABC) {
        switch (ABC) {
            case 'A':
                area = "�x�_��";
                area_code = 10;
                break;
            case 'B':
                area = "�x����";
                area_code = 11;
                break;
            case 'C':
                area = "�򶩥�";
                area_code = 12;
                break;
            case 'D':
                area = "�x�n��";
                area_code = 13;
                break;
            case 'E':
                area = "������";
                area_code = 14;
                break;
            case 'F':
                area = "�x�_��";
                area_code = 15;
                break;
            case 'G':
                area = "�y����";
                area_code = 16;
                break;
            case 'H':
                area = "��鿤";
                area_code = 17;
                break;
            case 'I':
                area = "�Ÿq��";
                area_code = 34;
                break;
            case 'J':
                area = "�s�˿�";
                area_code = 18;
                break;
            case 'K':
                area = "�]�߿�";
                area_code = 19;
                break;
            case 'L':
                area = "�x����";
                area_code = 20;
                break;
            case 'M':
                area = "�n�뿤";
                area_code = 21;
                break;
            case 'N':
                area = "���ƿ�";
                area_code = 22;
                break;
            case 'O':
                area = "�s�˥�";
                area_code = 35;
                break;
            case 'P':
                area = "���L��";
                area_code = 23;
                break;
            case 'Q':
                area = "�Ÿq��";
                area_code = 24;
                break;
            case 'R':
                area = "�x�n�u";
                area_code = 25;
                break;
            case 'S':
                area = "������";
                area_code = 26;
                break;
            case 'T':
                area = "�̪F��";
                area_code = 27;
                break;
            case 'U':
                area = "�Ὤ��";
                area_code = 28;
                break;
            case 'V':
                area = "�x�F��";
                area_code = 29;
                break;
            case 'W':
                area = "������";
                area_code = 32;
                break;
            case 'X':
                area = "���";
                area_code = 30;
                break;
            case 'Y':
                area = "�����s";
                area_code = 31;
                break;
            case 'Z':
                area = "�s����";
                area_code = 33;
                break;
        }
    }

    public void check_gender(char id_gender) {
        if (id_gender == '1')
            gender = "�k��";
        else
            gender = "�k��";
    }

    public String correct_message() {
        return id + ", " + area + " " + gender;
    }

    public String error_message() {
        return id + ",\t" + error;
    }
}
