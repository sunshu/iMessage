package me.sunshu.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sunshu on 17-6-21.
 */

@Entity
@Table(name = "TB_Apply")
public class Apply {

    public static final  int TYPE_ADD_USER = 1; // 加人
    public static final int TYPE_ADD_GROUP = 2; // 加群




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


    // 描述部分：对我们的申请信息做描述
    // eg：想加你为好朋友
    @Column(nullable = false)
    private String description;

    // 附件
    // 可以附带图片，地址
    @Column(columnDefinition = "TEXT")
    private String attach;

    // 当强申请类型

    private String type;



    // 创建时间戳
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间，
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 申请人,可为空 为系统消息
    // 一个人可以有多个申请
    @ManyToOne()
    @JoinColumn(name = "applicantId")
    private User applicant;
    @Column(updatable = false,insertable = false)
    private String applicantId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }
}
