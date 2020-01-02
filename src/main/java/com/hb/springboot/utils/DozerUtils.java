package com.hb.springboot.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 将list的PO转换为list的VO
 * @Param:
 * @return:
 * @Author: huangbo
 * @Date: 2019/9/14
 */
public class DozerUtils {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext(); ) {
            Object sourceObject = i$.next();
            Object destinationObject = dozerBeanMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}