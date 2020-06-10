package com.sven;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sven.entity.User;
import com.sven.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StudyspringApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("licsu");
        user.setAge(22);
        user.setEmail("225@163.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(11);
        user.setAge(22);
        userMapper.updateById(user);
    }

    /**
     * 根据多个ID查询
     */
    @Test
    public void testSelectDemo01() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage() {
        // 1.创建page对象 : 传入两个参数,当前页 和 每页显示记录数
        Page<User> userPage = new Page<>(1, 5);
        // 2.调用mp中分页查询方法
        // 调用mp分页查询过程中，底层封装
        // 把分页所有数据封装到 page 对象里面
        userMapper.selectPage(userPage, null);
        System.out.println(userPage.getCurrent());  // 当前页
        System.out.println(userPage.getRecords());  // 每页数据的list集合
        System.out.println(userPage.getSize());     // 每页显示记录数
        System.out.println(userPage.getTotal());    // 总记录数
        System.out.println(userPage.getPages());    // 总页数

        System.out.println(userPage.hasNext());     // 是否有下一页
        System.out.println(userPage.hasPrevious()); // 是否有上一页
    }

    // 删除操作 物理删除
    @Test
    public void testDetailById() {
        // 单个删除
        int i = userMapper.deleteById(1);
        System.out.println(i);
        // 批量删除
        int i1 = userMapper.deleteBatchIds(Arrays.asList(2, 3));
        System.out.println(i1);
    }

    // 逻辑删除
    @Test
    public void testDelete() {
        // 单个删除
        int i = userMapper.deleteById(20);
        System.out.println(i);
    }

    /**
     * mp 实现复杂点的查询操作
     */
    @Test
    public void testSelectQuery() {
        // 创建 QueryWrapper 对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过 QueryWrapper 设置条件
        // ge、gt、le、lt
        /**
         * ge : 大于等于
         * gt : 大于
         * le : 小于等于
         * lt : 小于
         */
        // 查询 age >= 10
        // 第一个参数字段名字
        // 第二个参数设置值
//        QueryWrapper<User> age = wrapper.ge("age", 10);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        /**
         * eq : 等于
         * ne : 不等于
         */
//        QueryWrapper<User> eq = wrapper.eq("name", "??");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        /**
         * between : 范围区间
         *
         */
//        QueryWrapper<User> between = wrapper.between("age",20,21);
//        List<User> users1 = userMapper.selectList(between);
//        System.out.println(users1);

        /**
         * like : 模糊查询
         */
//        QueryWrapper<User> name = wrapper.like("name", "B");
//        List<User> users = userMapper.selectList(name);
//        System.out.println(users);

        /**
         * orderByDesc : 排序
         */
//        QueryWrapper<User> userQueryWrapper = wrapper.orderByDesc("age");
//        List<User> users = userMapper.selectList(userQueryWrapper);
//        System.out.println(users);

        /**
         * last : 拼接
         */

        /**
         * 查询指定的列
         */
    }
}
