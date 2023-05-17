package com.board.boardTest.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySources({
        @PropertySource("classpath:/application.yml")
})
public class BoardConfigAppMapper {
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    Environment env;
//
//    private String dbType;
//
//    @PostConstruct
//    void init() {
//        dbType = env.getProperty("Globals.DbType");
//    }
//
//    @Bean
//    @Lazy
//    public DefaultLobHandler lobHandler() {
//        return new DefaultLobHandler();
//    }
//
//    @Bean(name = {"sqlSession", "egov.sqlSession"})
//    public SqlSessionFactoryBean sqlSession() {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//
//        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
//
//        sqlSessionFactoryBean.setConfigLocation(
//                pathMatchingResourcePatternResolver
//                        .getResource("classpath:/egovframework/mapper/config/mapper-config.xml"));
//
//        try {
//            sqlSessionFactoryBean.setMapperLocations(
//                    pathMatchingResourcePatternResolver
//                            .getResources("classpath:/egovframework/mapper/**/**/*_" + dbType + ".xml")
//            );
//        } catch (IOException e) {
//            // TODO Exception 처리 필요
//        }
//
//        return sqlSessionFactoryBean;
//    }
//
//    @Bean
//    public SqlSessionTemplate boardSqlSessionTemplate(@Qualifier("sqlSession") SqlSessionFactory sqlSession) {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSession);
//        return sqlSessionTemplate;
//    }

}
