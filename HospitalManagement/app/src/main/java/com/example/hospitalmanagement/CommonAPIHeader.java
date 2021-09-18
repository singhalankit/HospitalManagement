package com.example.hospitalmanagement;

public class CommonAPIHeader {

    private String hospitalId;
    private String transId;
    private String channelId;

    public String getHospitalId() {
        return hospitalId;
    }

    public String getTransId() {
        return transId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
