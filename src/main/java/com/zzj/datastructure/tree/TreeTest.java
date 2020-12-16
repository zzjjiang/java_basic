package com.zzj.datastructure.tree;

import com.alibaba.fastjson.JSON;
import com.zzj.datastructure.tree.dto.TreeDto;
import com.zzj.javaversion.java8.pojo.Trader;
import com.zzj.javaversion.java8.pojo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zouzujiang
 */
public class TreeTest {

    List<TreeDto> list = new ArrayList<>();
    Map<Long, TreeDto> menuMap = new HashMap<>(16);

    @Before
    public void before() {
        list.add(new TreeDto(1L, "1顶级", 0L));
        list.add(new TreeDto(10L, "1二级_10", 1L));
        list.add(new TreeDto(11L, "1二级_11", 1L));
        list.add(new TreeDto(100L, "1三级_100", 10L));
        list.add(new TreeDto(110L, "1三级_110", 11L));

        list.add(new TreeDto(2L, "2顶级", 0L));
        list.add(new TreeDto(20L, "2二级_20", 2L));
        list.add(new TreeDto(21L, "2二级_21", 2L));
        list.add(new TreeDto(200L, "2三级_200", 20L));
        list.add(new TreeDto(210L, "2三级_210", 21L));
        for (TreeDto dto : list) {
            menuMap.put(dto.getId(), dto);
        }
    }

    @Test
    public void test() {
        List<Long> ids = new ArrayList<>();
        ids.add(100L);
        ids.add(20L);
        ids.add(21L);
        List<TreeDto> list = new ArrayList<>();
        for (Long id : ids) {
            add(id, menuMap, list);
        }
        System.out.println(JSON.toJSONString(list));
        List<TreeDto> collect = list.stream().sorted(Comparator.comparing(TreeDto::getId)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    public void add(Long id, Map<Long, TreeDto> menuMap, List<TreeDto> list) {
        TreeDto dto = menuMap.get(id);
        boolean flag = false;
        for (TreeDto tree : list) {
            if (dto.getId().equals(tree.getId())) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            list.add(dto);
        }
        if (dto.getParentId() != 0L) {
            add(dto.getParentId(), menuMap, list);
        }
    }
}
