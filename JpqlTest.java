1111package test;

import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试Jpql查询
 * jpql是一个语句
 */

public class JpqlTest {
    //查询全部
    @Test
    public void testFindAll(){
        //获取entitymanager对象
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //查询全部
        String jpql="from cn.itcast.domain.Customer";
        //创建query查询对象，query对象才是执行jpql的对象
        Query query = em.createQuery(jpql);
        //发送查询并封装结果集
        List list = query.getResultList() ;
        for (Object obj:list){
            System.out.println(obj);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }


    /**
     * 排序查询，倒序查询全部用户
     */
    @Test
    public void testOrderBy(){
        //获取entitymanager对象
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //查询全部,如果要进行倒序查询则加上desc关键字
        String jpql="from Customer order by custId desc ";
        //创建query查询对象，query对象才是执行jpql的对象
        Query query = em.createQuery(jpql);
        //发送查询并封装结果集
        List list = query.getResultList() ;
        for (Object obj:list){
            System.out.println(obj);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    /**
     * 使用jpql统计客户总数
     */
    @Test
    public void testCount(){
        //获取entitymanager对象
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //查询全部,进行统计查询.根据jpql语句创建query查询对象
        String jpql="select count(custId) from Customer ";
        //创建query查询对象，query对象才是执行jpql的对象
        Query query = em.createQuery(jpql);
        //发送查询并封装结果集,getSingleResult()此方法会得到唯一的结果
        Object result= query.getSingleResult() ;
        System.out.println(result);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }


    @Test
    public void testPage(){
        //获取entitymanager对象
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //查询全部,进行统计查询.根据jpql语句创建query查询对象
        String jpql="from Customer  ";
        //创建query查询对象，query对象才是执行jpql的对象
        Query query = em.createQuery(jpql);
        //对页码参数进行赋值
        query.setFirstResult(0);
        query.setMaxResults(2);
        //发送查询并封装结果集,getSingleResult()此方法会得到唯一的结果
        List resultList = query.getResultList();
        for (Object obj:resultList){
            System.out.println(obj);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }


    /**
     * 条件查询:查询客户名称
     */
    @Test
    public void testCondition(){
        //获取entitymanager对象
        EntityManager em = JpaUtils.getEntityManager();
        //开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //查询全部,进行统计查询.根据jpql语句创建query查询对象
        String jpql="from Customer  where custName like ?";
        //创建query查询对象，query对象才是执行jpql的对象
        Query query = em.createQuery(jpql);
        query.setParameter(1,"%校");
        //发送查询并封装结果集,getSingleResult()此方法会得到唯一的结果
        List resultList = query.getResultList();
        for (Object obj:resultList){
            System.out.println(obj);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }
}
