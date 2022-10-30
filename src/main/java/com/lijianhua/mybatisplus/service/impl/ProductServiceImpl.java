package com.lijianhua.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.lijianhua.mybatisplus.entity.Product;
import com.lijianhua.mybatisplus.mapper.ProductMapper;
import com.lijianhua.mybatisplus.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijianhua
 * @since 2022-10-29
 */
@DS("slave_1") //指定操作的数据源
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
