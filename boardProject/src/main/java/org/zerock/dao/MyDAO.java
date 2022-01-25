package org.zerock.dao;

public interface MyDAO {
    // mybatis-scan하면 @Component같은 것 없어도 빈등록이 된다.

    //@Select("select now()")
    public String getTime();
}
