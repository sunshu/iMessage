package me.sunshu.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * 用户关系的model
 * 用于用户直接进行好友关系实现
 * 用户和中间表
 * Created by sunshu
 *
 */

@Entity
@Table(name = "TB_USER_FOLLOW")
public class UserFollow {


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


    // 定义一个发起人，你关注某人，这里就是你
    // 多对一 -> 你可以关注很多人，你的每一次关注都是一条记录
    // 你可以创建很多个关注的信息，所以这里是多对1;
    // 这里的多对一： User 对应 多个 UserFollow
    // optional 不可选，必须存储，一条关注记录一定要有个一个你
    @ManyToOne(optional = false)
    // 定义关联表的字段名为priginId,对应的是User.id
    @JoinColumn(name = "originId")
    private User origin;

    // 把这个列提取到我们的model 中，不许null，更新，插入
    @Column(nullable = false,updatable = false,insertable = false)
    private String originId;

    // 定义关注的目标，你关注的人
    // 也是多对一，你可以被很多人关注，每次关注都是一条记录
    // 所有就是 多个UserFollow 对应一个User
    @ManyToOne(optional = false)
    // 定义关联表的字段名为targetId,对应的是User.id
    @JoinColumn(name = "targetId")
    private User target;
    @Column(nullable = false,updatable = false,insertable = false)
    private String targetId;

    // 别名，对target 的备注
    @Column
    private String alias;

    // 定义创建时间，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();


    // 定义为更新时间，
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOrigin() {
        return origin;
    }

    public void setOrigin(User origin) {
        this.origin = origin;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
}
