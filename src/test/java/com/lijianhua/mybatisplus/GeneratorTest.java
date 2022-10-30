package com.lijianhua.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * 生成mybatis-plus代码
 * @author 李建华
 * @create 2022/10/29 10:25
 * @description 自己写
 * @since 1.0
 */
@SpringBootTest
public class GeneratorTest {

    public static void main(String[] args) {
        //生成master库的代码
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8"
                        , "root", "123456")
                .globalConfig(builder -> {
                    builder.author("lijianhua") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Projects\\JavaProjects\\mybatis_plus_datasource\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lijianhua") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Projects\\JavaProjects\\mybatis_plus_datasource\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

        //生成slave_1库的代码
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus_1?characterEncoding=utf-8&useSSL=false"
                        , "root", "123456")
                .globalConfig(builder -> {
                    builder.author("lijianhua") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Projects\\JavaProjects\\mybatis_plus_datasource\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lijianhua") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Projects\\JavaProjects\\mybatis_plus_datasource\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("product") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀，我猜是，生成实体类时，去掉t_，c_前缀。
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
