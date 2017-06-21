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
@Table(name = "TB_Group")
public class Group {

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

    // name 群名称
    @Column(nullable = false,length = 128,unique = true)
    private String name;

    // 群描述
    @Column
    private String description;

    // 群图标
    @Column(nullable = false)
    private String picture;

    // 创建时间戳
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间，
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();


    // 群的创建者
    // optional : 可选为false, 必须有一个创建者
    // fetch ： 加载方式为 FetchType.EAGER
    // 意味着加载群的信息的时候就必须加载ower的信息
    // cascade:联级级别为ALL,所欲更改(更新,删除)都将进行关系更细
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId")
    private User user;
    @Column(nullable = false,updatable = false,insertable = false)
    private String ownerId;

    public Group(String name, String description, String picture, LocalDateTime createAt, LocalDateTime updateAt, User user, String ownerId) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.user = user;
        this.ownerId = ownerId;
    }
}
