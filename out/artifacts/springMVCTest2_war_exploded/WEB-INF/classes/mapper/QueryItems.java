package mapper;

import po.Items;

import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
public interface QueryItems {
    List<Items> queryItemsByName(String name);
}
