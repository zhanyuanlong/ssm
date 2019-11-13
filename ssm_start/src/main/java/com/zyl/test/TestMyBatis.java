package com.zyl.test;

import com.zyl.dao.MessageDao;
import com.zyl.domain.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        MessageDao dao = session.getMapper(MessageDao.class);
        // 查询所有数据
        List<Message> list = dao.findAll();
        for(Message message : list){
            System.out.println(message);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        Message message = new Message();
        message.setMsg("xdfdsfsdf梵蒂冈导师的");
        message.setUsername("zyl");
        message.setTime("19-11-02 21:43");

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        MessageDao dao = session.getMapper(MessageDao.class);
        // 保存
        dao.saveMessage(message);
        // 提交事务
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }

}
