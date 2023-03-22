package com.mvcmember.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String id;
    private String pass;
    private String name;
    private java.util.Date regidate;
    private String email;
    private String tel;
}
