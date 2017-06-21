package me.sunshu.web.italker.push.bean.db;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.Consumes;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunshu
 */

@Entity
@Table(name = "TB_USER")
public class User {

    // 主键
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的类型为UUID
    @GeneratedValue(generator = "uuid")
    // 把uuid的生成器定位为uuid2,uuid2是uuid的 toString
    @GenericGenerator(name = "uuid" ,strategy = "uuid2")
    // 不允许为空
    @Column(updatable = false,nullable = false)
    private String id;

    // name
    @Column(nullable = false,length = 128,unique = true)
    private String name;

    //phone
    @Column(nullable = false,length = 62,unique = true)
    private String phone;

    // password
    @Column(nullable = false)
    private String password;

    // 头像可以为空
    @Column
    private String portraint;

    @Column
    private String description;

    // 有初始值，不为空
    @Column(nullable = false)
    private int sex = 0;

    @Column(unique = true)
    private String token;

    @Column
    private String pushId;

    // 创建时间戳
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间，
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 最后一次收到信息的时间
    @Column
    private LocalDateTime lastReceiveAt = LocalDateTime.now();


    // 我关注人的列表方法
    // 对用的数据库字段为 TB_USER_FOLLOW.originId
    @JoinColumn(name = "originId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollow> following = new HashSet<>();


    // 定义关注我的人
    // 对用的数据库字段为 TB_USER_FOLLOW.originId
    @JoinColumn(name = "targetId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserFollow> followers = new HashSet<>();

    // 我创建的所有的群
    // 对应的字段为 Group.owerId
    @JoinColumn(name = "ownerId")
    // 懒加载集合方式为尽可能的不加载具体数据
    // 当访问groups.size()仅仅查询数量，不加载具体的Group 信息
    // 只有当遍历集合的时候才加载具体的数据
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Group> groups = new HashSet<>();




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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortraint() {
        return portraint;
    }

    public void setPortraint(String portraint) {
        this.portraint = portraint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getLastReceiveAt() {
        return lastReceiveAt;
    }

    public void setLastReceiveAt(LocalDateTime lastReceiveAt) {
        this.lastReceiveAt = lastReceiveAt;
    }

    public Set<UserFollow> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserFollow> following) {
        this.following = following;
    }

    public Set<UserFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserFollow> followers) {
        this.followers = followers;
    }
}
