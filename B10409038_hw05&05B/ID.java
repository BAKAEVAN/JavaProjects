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
            System.out.println("�榡����\n");
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
            System.out.printf("�����Ҧr�����T\n" +
                    "�O��X�ͦb%s��%s�ͳ�\n\n", area, gender);
        else
            System.out.println("�����Ҧr�����~\n");
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
        System.out.printf("���ͪ������Ҧr����: %s\n", id);
    }

    public void check_gender(char id_gender) {
        if (id_gender == '1')
            gender = "�k";
        else
            gender = "�k";
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

    public boolean gender_to_code(String input) {
        if (input.equals("�k")) {
            id_make[0] = 1;
        } else if (input.equals("�k")) {
            id_make[0] = 2;
        } else
            return true;
        gender = input;
        return false;
    }

    public boolean area_to_alphabet(String place) {
        switch (place) {
            case "�x�_��":
                alphabet = 'A';
                break;
            case "�O�_��":
                alphabet = 'A';
                break;
            case "�x����":
                alphabet = 'B';
                break;
            case "�O����":
                alphabet = 'B';
                break;
            case "�򶩥�":
                alphabet = 'C';
                break;
            case "�x�n��":
                alphabet = 'D';
                break;
            case "�O�n��":
                alphabet = 'D';
                break;
            case "������":
                alphabet = 'E';
                break;
            case "�x�_��":
                alphabet = 'F';
                break;
            case "�O�_��":
                alphabet = 'F';
                break;
            case "�y����":
                alphabet = 'G';
                break;
            case "��鿤":
                alphabet = 'H';
                break;
            case "�Ÿq��":
                alphabet = 'I';
                break;
            case "�s�˿�":
                alphabet = 'J';
                break;
            case "�]�߿�":
                alphabet = 'K';
                break;
            case "�x����":
                alphabet = 'L';
                break;
            case "�O����":
                alphabet = 'L';
                break;
            case "�n�뿤":
                alphabet = 'M';
                break;
            case "���ƿ�":
                alphabet = 'N';
                break;
            case "�s�˥�":
                alphabet = 'O';
                break;
            case "���L��":
                alphabet = 'P';
                break;
            case "�Ÿq��":
                alphabet = 'Q';
                break;
            case "�x�n�u":
                alphabet = 'R';
                break;
            case "�O�n�u":
                alphabet = 'R';
                break;
            case "������":
                alphabet = 'S';
                break;
            case "�̪F��":
                alphabet = 'T';
                break;
            case "�Ὤ��":
                alphabet = 'U';
                break;
            case "�x�F��":
                alphabet = 'V';
                break;
            case "�O�F��":
                alphabet = 'V';
                break;
            case "������":
                alphabet = 'W';
                break;
            case "���":
                alphabet = 'X';
                break;
            case "�����s":
                alphabet = 'Y';
                break;
            case "�s����":
                alphabet = 'Z';
                break;
            default:
                return true;
        }
        alphabet_to_area(alphabet);
        return false;
    }
}
