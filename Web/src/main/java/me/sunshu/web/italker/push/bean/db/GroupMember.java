package me.sunshu.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sunshu on 17-6-16.
 */

@Entity
@Table(name = "TB_GroupMember")
public class GroupMember {

    private static final  int PERMISSION_TYPE_NONE = 0;// 默认权限，普通成员
    private static final  int PERMISSION_TYPE_ADMIN = 1;// 管理员
    private static final  int PERMISSION_TYPE_ADMIN_SU = 100;// 创建者


    private static final  int NOTIFY_LEVEL_INVALID = -1;// 默认不接受
    private static final  int NOTIFY_LEVEL_NONE = 0; // 默认
    private static final  int NOTIFY_LEVEL_CLOSE = 1; // 接受不提示




    // 主键
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的类型为UUID,自动生成
    @GeneratedValue(generator = "uuid")
    // 把uuid的生成器定位为uuid2,uuid2是uuid的 toString
    @GenericGenerator(name = "uuid" ,strategy = "uuid2")
    // 不允许为空
    @Column(updatable = false,nullable = false)
    private String id;


    // 别名，对target 的备注
    @Column
    private String alias;

    // 通知的级别
    @Column(nullable = false)
    private int notifyLevel = NOTIFY_LEVEL_NONE;

    // 成员的权限类型
    @Column(nullable = false)
    private int permissionType = PERMISSION_TYPE_NONE;

    // 创建时间戳
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间，
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();


    @JoinColumn(name = "userId")
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;
    @Column(nullable = false,updatable = false,insertable = false)
    private String userId;



    @JoinColumn(name = "groupId")
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Group group;
    @Column(nullable = false,updatable = false,insertable = false)
    private String groupId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}




