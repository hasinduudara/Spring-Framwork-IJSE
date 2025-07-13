package lk.hasindu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    @JsonProperty("CID")
    private String CID;

    @JsonProperty("CName")
    private String CName;

    @JsonProperty("CAddress")
    private String CAddress;

    public CustomerDTO() {
    }

    public CustomerDTO(String CID, String CName, String CAddress) {
        this.CID = CID;
        this.CName = CName;
        this.CAddress = CAddress;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCAddress() {
        return CAddress;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "CID='" + CID + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                '}';
    }
}
