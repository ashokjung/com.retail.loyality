package com.retail.loyality.models;


public class CustomerClubcard {

    private long clubcardId;

    private long primaryClubcardId;

    private int clubcardType;

    private int clubcardStatus;

    public long getClubcardId() {
        return clubcardId;
    }

    public void setClubcardId(long clubcardId) {
        this.clubcardId = clubcardId;
    }

    public long getPrimaryClubcardId() {
        return primaryClubcardId;
    }

    public void setPrimaryClubcardId(long primaryClubcardId) {
        this.primaryClubcardId = primaryClubcardId;
    }

    public int getClubcardType() {
        return clubcardType;
    }

    public void setClubcardType(int clubcardType) {
        this.clubcardType = clubcardType;
    }

    public int getClubcardStatus() {
        return clubcardStatus;
    }

    public void setClubcardStatus(int clubcardStatus) {
        this.clubcardStatus = clubcardStatus;
    }
}
