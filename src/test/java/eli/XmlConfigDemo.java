package eli;

import eli.entity.User;
import eli.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eli
 * @date 2021/12/21
 */
public class XmlConfigDemo {

    public static void main(String[] args) throws IOException {
        String xmlPath = "eli/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(xmlPath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

}
