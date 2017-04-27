/**
 * Created by B10409038 on 2017/4/27.
 */

public class TimeLength {
    /**
     * ��(HR), ��(MIN), ��(SEC)
     * 1�� �� 60 ��
     * 1�� �� 60 ��
     * 1�� �� 3600 ��
     */
    private static final int MIN_TO_SEC = 60;
    private static final int HR_TO_SEC = 3600;
    private int sec;

    public TimeLength() {
        sec = 0;
    }

    /**�]�m���, �ѼƬ���*/
    public void setSec(int sec) {
        this.sec = sec;
    }

    /**�]�m���, �ѼƬ��ɡB���B��M���t��*/
    public void setSec(int hr, int min, int sec, int minusOrplus) {
        this.sec = convertToSec(hr, min, sec, minusOrplus);
    }

    /**hh:mm:ss�榡�ഫ����*/
    public int convertToSec(int hr, int min, int sec, int minusOrplus) {
        return (hr * HR_TO_SEC + min * MIN_TO_SEC + sec) * minusOrplus;
    }

    /**�վ���, �ѼƬ���*/
    public void adjustSec(int sec) {
        this.sec += sec;
    }

    /**�վ���, �ѼƬ��ɡB���B��M���t��*/
    public void adjustSec(int hr, int min, int sec, int minusOrplus) {
        this.sec += convertToSec(hr, min, sec, minusOrplus);
    }

    /**���o���*/
    public int getSec() {
        return sec;
    }

    /**���ohh:mm:ss�榡�r��*/
    public String getStrTime() {
        return getStrminusOrplus() + getStrHr() + ":" + getStrMin() + ":" + getStrSec();
    }

    /**���ohh:mm:ss�榡�r�ꤧ���t��*/
    public String getStrminusOrplus() {
        if (sec >= 0)
            return "";
        else
            return "-";
    }

    /**���ohh:mm:ss�榡�r�ꤧ�ɼ�*/
    public String getStrHr() {
        String hr = String.valueOf(Math.abs(sec) / HR_TO_SEC);
        if (hr.length() == 1)
            return "0" + hr;
        else
            return hr;
    }

    /**���ohh:mm:ss�榡�r�ꤧ����*/
    public String getStrMin() {
        String min = String.valueOf(Math.abs(sec) % HR_TO_SEC / MIN_TO_SEC);
        if (min.length() == 1)
            return "0" + min;
        else
            return min;
    }

    /**���ohh:mm:ss�榡�r�ꤧ���*/
    public String getStrSec() {
        String sec = String.valueOf(Math.abs(this.sec) - Integer.parseInt(getStrHr()) * HR_TO_SEC - Integer.parseInt(getStrMin()) * MIN_TO_SEC);
        if (sec.length() == 1)
            return "0" + sec;
        else
            return sec;
    }

    /**��Jhh:mm:ss�榡�r��ɪ�set�B�z�{��*/
    public void String_process_set(String time) {
        String[] units = time.split(":");
        int hr = Math.abs(Integer.parseInt(units[0]));
        int min = Integer.parseInt(units[1]);
        int sec = Integer.parseInt(units[2]);
        if (time.charAt(0) == '-')
            setSec(hr, min, sec, -1);
        else
            setSec(hr, min, sec, 1);
    }

    /**��Jhh:mm:ss�榡�r��ɪ�adjust�B�z�{��*/
    public void String_process_adjust(String time) {
        String[] units = time.split(":");
        int hr = Math.abs(Integer.parseInt(units[0]));
        int min = Integer.parseInt(units[1]);
        int sec = Integer.parseInt(units[2]);
        if (time.charAt(0) == '-')
            adjustSec(hr, min, sec, -1);
        else
            adjustSec(hr, min, sec, 1);
    }
}
