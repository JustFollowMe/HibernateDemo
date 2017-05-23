package com.yixin;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.yixin.pojo.User;

public class Test {

	public static void main(String[] args) {

		// 默认读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = null;
		try {
			// 开启session
			session = sessionFactory.openSession();
			// 开启事务
			session.beginTransaction();
			
			User user = new User();  
            user.setName("Yasin");  
            user.setPassword("123456");  
            user.setCreateTime(new Date());  
            user.setExpireTime(new Date());  
            //保存User对象  
            session.save(user);  
              
            //提交事务  
            session.getTransaction().commit(); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}

	}

}
