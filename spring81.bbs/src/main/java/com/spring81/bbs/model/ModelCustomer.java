package com.spring81.bbs.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelCustomer {
    
    Integer  userno ;//`userno` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    String   userid;//`userid` VARCHAR(50) NOT NULL,
    String   email;//`email` VARCHAR(100) NOT NULL,
    String   passwd;//`passwd` VARCHAR(30) NULL DEFAULT NULL,
    String   name;//`name` VARCHAR(30) NULL DEFAULT NULL,
    String   mobile;//`mobile` VARCHAR(20) NULL DEFAULT NULL,
    Boolean  retireYN;//`retireYN` TINYINT(1) NULL DEFAULT '1',
    String   InsertUID;//`InsertUID` VARCHAR(40) NULL DEFAULT NULL,
    Date     InsertDT;//`InsertDT` DATETIME NULL DEFAULT NULL,
    String   UpdateUID;//`UpdateUID` VARCHAR(40) NULL DEFAULT NULL,
    Date     UpdateDT;//`UpdateDT` DATETIME NULL DEFAULT NULL,
    String   address;//`adress` VARCHAR(50) NULL DEFAULT NULL,
    Integer coin;//`coin` INT(11) NULL DEFAULT NULL,
    Integer mileage;//`mileage` INT(11) NULL DEFAULT NULL,
    Integer uploadImageNo ;//`uploadImageNo` INT(10) UNSIGNED NULL DEFAULT NULL,
    String  fileName       ;//`fileName` VARCHAR(50) NULL DEFAULT NULL,
    Long    fileSize ;//`fileSize` INT(10) UNSIGNED NULL DEFAULT NULL,
    String  contentType ;//`contentType` VARCHAR(30) NULL DEFAULT NULL,
    byte[]  imageBytes ;//`imageBytes` LONGBLOB NULL,
    String  imageBase64 ;//`imageBase64` LONGTEXT NULL,
    CommonsMultipartFile image;
    
    public ModelCustomer(Integer userno, String userid, String email,
            String passwd, String name, String mobile, Boolean retireYN,
            String insertUID, Date insertDT, String updateUID, Date updateDT,
            String address, Integer coin, Integer mileage,
            Integer uploadImageNo, String fileName, Long fileSize,
            String contentType, byte[] imageBytes, String imageBase64,
            CommonsMultipartFile image) {
        super();
        this.userno = userno;
        this.userid = userid;
        this.email = email;
        this.passwd = passwd;
        this.name = name;
        this.mobile = mobile;
        this.retireYN = retireYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
        this.address = address;
        this.coin = coin;
        this.mileage = mileage;
        this.uploadImageNo = uploadImageNo;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.imageBytes = imageBytes;
        this.imageBase64 = imageBase64;
        this.image = image;
    }

    public ModelCustomer() {
        super();
    }

    public Integer getUserno() {
        return userno;
    }

    public void setUserno(Integer userno) {
        this.userno = userno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getRetireYN() {
        return retireYN;
    }

    public void setRetireYN(Boolean retireYN) {
        this.retireYN = retireYN;
    }

    public String getInsertUID() {
        return InsertUID;
    }

    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }

    public Date getInsertDT() {
        return InsertDT;
    }

    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }

    public String getUpdateUID() {
        return UpdateUID;
    }

    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }

    public Date getUpdateDT() {
        return UpdateDT;
    }

    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getUploadImageNo() {
        return uploadImageNo;
    }

    public void setUploadImageNo(Integer uploadImageNo) {
        this.uploadImageNo = uploadImageNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ModelCustomer [userno=" + userno + ", userid=" + userid
                + ", email=" + email + ", passwd=" + passwd + ", name=" + name
                + ", mobile=" + mobile + ", retireYN=" + retireYN
                + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT
                + ", address=" + address + ", coin=" + coin + ", mileage="
                + mileage + ", uploadImageNo=" + uploadImageNo + ", fileName="
                + fileName + ", fileSize=" + fileSize + ", contentType="
                + contentType + ", imageBytes=" + Arrays.toString(imageBytes)
                + ", imageBase64=" + imageBase64 + ", image=" + image + "]";
    }
    
    
    
    
   
    
}
