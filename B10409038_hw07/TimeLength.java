/**
 * Created by B10409038 on 2017/4/27.
 */

public class TimeLength {
    /**
     * (HR), だ(MIN), (SEC)
     * 1 ∽ 60 だ
     * 1だ ∽ 60 
     * 1 ∽ 3600 
     */
    private static final int MIN_TO_SEC = 60;
    private static final int HR_TO_SEC = 3600;
    private int sec;

    public TimeLength() {
        sec = 0;
    }

    /**砞竚计, 把计*/
    public void setSec(int sec) {
        this.sec = sec;
    }

    /**砞竚计, 把计だ㎝タ璽腹*/
    public void setSec(int hr, int min, int sec, int minusOrplus) {
        this.sec = convertToSec(hr, min, sec, minusOrplus);
    }

    /**hh:mm:ssΑ锣传*/
    public int convertToSec(int hr, int min, int sec, int minusOrplus) {
        return (hr * HR_TO_SEC + min * MIN_TO_SEC + sec) * minusOrplus;
    }

    /**秸俱计, 把计*/
    public void adjustSec(int sec) {
        this.sec += sec;
    }

    /**秸俱计, 把计だ㎝タ璽腹*/
    public void adjustSec(int hr, int min, int sec, int minusOrplus) {
        this.sec += convertToSec(hr, min, sec, minusOrplus);
    }

    /**眔计*/
    public int getSec() {
        return sec;
    }

    /**眔hh:mm:ssΑ﹃*/
    public String getStrTime() {
        return getStrminusOrplus() + getStrHr() + ":" + getStrMin() + ":" + getStrSec();
    }

    /**眔hh:mm:ssΑ﹃ぇタ璽腹*/
    public String getStrminusOrplus() {
        if (sec >= 0)
            return "";
        else
            return "-";
    }

    /**眔hh:mm:ssΑ﹃ぇ计*/
    public String getStrHr() {
        String hr = String.valueOf(Math.abs(sec) / HR_TO_SEC);
        if (hr.length() == 1)
            return "0" + hr;
        else
            return hr;
    }

    /**眔hh:mm:ssΑ﹃ぇだ计*/
    public String getStrMin() {
        String min = String.valueOf(Math.abs(sec) % HR_TO_SEC / MIN_TO_SEC);
        if (min.length() == 1)
            return "0" + min;
        else
            return min;
    }

    /**眔hh:mm:ssΑ﹃ぇ计*/
    public String getStrSec() {
        String sec = String.valueOf(Math.abs(this.sec) - Integer.parseInt(getStrHr()) * HR_TO_SEC - Integer.parseInt(getStrMin()) * MIN_TO_SEC);
        if (sec.length() == 1)
            return "0" + sec;
        else
            return sec;
    }

    /**块hh:mm:ssΑ﹃set矪瞶祘*/
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

    /**块hh:mm:ssΑ﹃adjust矪瞶祘*/
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
