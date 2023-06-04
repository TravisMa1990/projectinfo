package com.ipdsys.flowmgt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ipdsys.flowmgt.enums.CommonStatus;
import lombok.Data;

import javax.xml.stream.events.Comment;
import java.sql.Timestamp;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private Long idP;
    private String userName;
    private String password;
    private String realName;
    private String email;
    private String phone;
    private CommonStatus status;
    private Timestamp createTime;
    private Timestamp updateTime;
}
