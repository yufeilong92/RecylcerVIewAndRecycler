package com.example.dell.myapplication;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: listVo.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/16 23:00
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/16 星期三
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class listVo {
    private String name;
    private String id;
    private List<Vo>datebean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vo> getDatebean() {
        return datebean;
    }

    public void setDatebean(List<Vo> datebean) {
        this.datebean = datebean;
    }
}
