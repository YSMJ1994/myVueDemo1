package service;

import mapper.QueryItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import po.Items;

import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/4.
 */
@Service
@Transactional
public class ItemService {
    @Autowired
    private QueryItems queryItems;
    //@Autowired
    //private SqlSessionFactory sqlSessionFactory;
    public List<Items> queryItemsByName(String name) {
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //QueryItems queryItems = sqlSession.getMapper(QueryItems.class);
        //return queryItems.queryItemsByName("桌子");
        return queryItems.queryItemsByName(name);
    }
}
