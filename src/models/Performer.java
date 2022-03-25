package models;

public class Performer {
    private String mstage_name, mpid, mindustry, memail, mmobile_number, mpostal_code;

    public Performer(String stage_name, String pid, String industry, String email, String mobile_number, String postal_code){
            mstage_name = stage_name;
            mpid = pid;
            mindustry = industry;
            memail = email;
            mmobile_number = mobile_number;
            mpostal_code = postal_code;
    }

    public String getMemail() {
        return memail;
    }

    public String getMmobile_number() {
        return mmobile_number;
    }

    public String getMpostal_code() {
        return mpostal_code;
    }

    public String getMindustry() {
        return mindustry;
    }

    public String getMpid() {
        return mpid;
    }

    public String getMstage_name() {
        return mstage_name;
    }
}
