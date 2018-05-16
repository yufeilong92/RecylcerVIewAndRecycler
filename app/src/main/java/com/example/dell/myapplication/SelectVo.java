package com.example.dell.myapplication;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: SelectVo.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/16 23:26
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/16 星期三
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SelectVo {

    private String parenid;
    private List<itemSelect> data;

    public List<itemSelect> getData() {
        return data;
    }

    public void setData(List<itemSelect> data) {
        this.data = data;
    }

    public String getParenid() {
        return parenid;
    }

    public void setParenid(String parenid) {
        this.parenid = parenid;
    }

}
