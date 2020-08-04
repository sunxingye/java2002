package com.sun.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class ElectronicBook {
    private Integer bookId;

    private String bookName;

    private String bookPrimary;

    private String bookUploader;

    private Date uploadTime;

    private Integer groupId;

    private String groupName;
}