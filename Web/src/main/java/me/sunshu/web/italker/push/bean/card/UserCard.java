package me.sunshu.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

/**
 * Created by sunshu
 */
public class UserCard {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String phone;

    @Expose
    private String portrait; // 头像
    @Expose
    private String desc;
    @Expose
    private int sex = 0;

    //
    @Expose
    private int follows; // 关注的人

    @Expose
    private int following; // 关注你的人（粉丝）

    @Expose
    private int isFollow; // 查询者是否关注用户

    @Expose
    private LocalDateTime modifyAt; // 用户信息最后更新时间


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
    }

    public LocalDateTime getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(LocalDateTime modifyAt) {
        this.modifyAt = modifyAt;
    }
}
