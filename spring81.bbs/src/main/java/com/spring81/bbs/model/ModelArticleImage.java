package com.spring81.bbs.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelArticleImage {
    
    Integer articleno ;
    String  boardcd   ;
    String  title     ;
    String  content   ;
    String  email     ;
    Integer hit       ;
    Date    regdate   ;
    Boolean UseYN     ;
    String  InsertUID ;     
    Date    InsertDT  ;
    String  UpdateUID ;     
    Date    UpdateDT  ;
    
    Integer uploadImageNo ;
    String  fileName       ;
    Long    fileSize ;
    String  contentType ;
    byte[]  imageBytes ;
    String  imageBase64 ;
    CommonsMultipartFile image;

    
    
    Integer attachFileNum;
    
    Integer commentNum;

    public ModelArticleImage(Integer articleno, String boardcd, String title,
            String content, String email, Integer hit, Date regdate,
            Boolean useYN, String insertUID, Date insertDT, String updateUID,
            Date updateDT, Integer uploadImageNo, String fileName,
            Long fileSize, String contentType, byte[] imageBytes,
            String imageBase64, CommonsMultipartFile image,
            Integer attachFileNum, Integer commentNum) {
        super();
        this.articleno = articleno;
        this.boardcd = boardcd;
        this.title = title;
        this.content = content;
        this.email = email;
        this.hit = hit;
        this.regdate = regdate;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
        this.uploadImageNo = uploadImageNo;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.imageBytes = imageBytes;
        this.imageBase64 = imageBase64;
        this.image = image;
        this.attachFileNum = attachFileNum;
        this.commentNum = commentNum;
    }

    public ModelArticleImage() {
        super();
    }

    public Integer getArticleno() {
        return articleno;
    }

    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }

    public String getBoardcd() {
        return boardcd;
    }

    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Boolean getUseYN() {
        return UseYN;
    }

    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
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

    public Integer getAttachFileNum() {
        return attachFileNum;
    }

    public void setAttachFileNum(Integer attachFileNum) {
        this.attachFileNum = attachFileNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
    

    public ModelArticleImage(Integer articleno) {
        super();
        this.articleno = articleno;
    }

    @Override
    public String toString() {
        return "ModelArticleImage [articleno=" + articleno + ", boardcd="
                + boardcd + ", title=" + title + ", content=" + content
                + ", email=" + email + ", hit=" + hit + ", regdate=" + regdate
                + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + ", uploadImageNo=" + uploadImageNo
                + ", fileName=" + fileName + ", fileSize=" + fileSize
                + ", contentType=" + contentType + ", imageBytes="
                + Arrays.toString(imageBytes) + ", imageBase64=" + imageBase64
                + ", image=" + image + ", attachFileNum=" + attachFileNum
                + ", commentNum=" + commentNum + "]";
    }

    
}
