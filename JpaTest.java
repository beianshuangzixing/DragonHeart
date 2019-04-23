package test;


import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
    @Test
    public void testSave(){
        /*//加载配置文件，创建工厂对象
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("myJpa");
        //通过实体管理工厂获取实体管理器
        EntityManager em=factory.createEntityManager();*/
        EntityManager em = JpaUtils.getEntityManager();
        //获取事务对象，开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //完成增删改查操作it
        Customer customer=new Customer();
        customer.setCustName("黑马");
        customer.setCustIndustry("it");
        //保存操作
        em.persist(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
       // em.close();
    }

    @Test
    public void testFind(){
        //通过工具类来获取相应的对象
        EntityManager em = JpaUtils.getEntityManager();
        //获取事务对象，开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //完成增删改查操作it,根据id查询数据
        //getReference()这个方法加载数据是方法被调用时进行加载。
        //Customer customer1 = em.getReference(Customer.class, 2);
        Customer customer = em.find(Customer.class, 2);
        System.out.println(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void testRemove(){
        //通过工具类来获取相应的对象
        EntityManager em = JpaUtils.getEntityManager();
        //获取事务对象，开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //完成增删改查操作it,根据id删除数据，删除数据之前，先进行查询，在进行删除
        Customer customer = em.find(Customer.class, 2);
        em.remove(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void testUpdate(){
        //通过工具类来获取相应的对象
        EntityManager em = JpaUtils.getEntityManager();
        //获取事务对象，开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //完成增删改查操作it,根据id更新数据，更新数据之前，先进行查询，在进行更新
        Customer customer = em.find(Customer.class, 3);
        customer.setCustName("热干面");
        em.merge(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

}
