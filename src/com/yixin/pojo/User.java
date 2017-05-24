package com.yixin.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //不写Table默认为user，@Table(name="t_user")
@Table(name="t_user")
public class User {
	
	//JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.   
    //TABLE：使用一个特定的数据库表格来保存主键。   
    //SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。   
    //IDENTITY：主键由数据库自动生成（主要是自动增长型）   
    //AUTO：主键由程序控制。
	//主键
	@Id   
//    @GeneratedValue(strategy=GenerationType.AUTO)//采用数据库自增方式生成主键  
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid",strategy="identity")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;  
	
	
	@Column(name="name",unique=true,nullable=false) //字段为name，不允许为空，用户名唯一
    private String name;  
	
	@Column(name="password")
    private String password;  
    
    @Temporal(TemporalType.DATE)//生成yyyy-MM-dd类型的日期
    @Column(name="createTime")
    private Date createTime;  
    
    @Temporal(TemporalType.DATE)//生成yyyy-MM-dd类型的日期
    @Column(name="expireTime")
    private Date expireTime;
    
    private Group groups;
    
    private Set<Role> roles;
    
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Group getGroups() {
		return groups;
	}
	public void setGroups(Group groups) {
		this.groups = groups;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}  

}
