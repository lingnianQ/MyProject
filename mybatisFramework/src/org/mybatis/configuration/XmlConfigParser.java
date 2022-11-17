package org.mybatis.configuration;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class XmlConfigParser {
    public static Configuration configuration = new Configuration();

    public static void parser(InputStream inputStream) throws Throwable {
        /**
         * <property name="driver" value="com.mysql"></>
         * <property name="url" value="testdb"></>
         * <property name="username" value="root"></>
         */
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        List<Element> propertyElement = document.selectNodes("//property");
        for (Element element : propertyElement) {
            String valueOfName = element.attributeValue("name");
            String valueOfValue = element.attributeValue("value");
            switch (valueOfName) {
                case "driver":
                    configuration.setDriver(valueOfValue);
                    break;
                case "url":
                    configuration.setUrl(valueOfValue);
                    break;
                case "username":
                    configuration.setUsername(valueOfValue);
                    break;
                case "password":
                    configuration.setPassword(valueOfValue);
                    break;
            }

        }

        configuration.setSqlMappers(new HashMap<String, SqlMapper>());
        List<Element> mapperElements = document.selectNodes("//mapper");
        for (Element element : mapperElements) {
            String resource = element.attributeValue("resource");
            parserMapper(resource);
        }
        System.out.println(configuration);

    }

    public static void parserMapper(String mapperFileName) throws Throwable {
        /**
         <select id="com.UserMapper.findAll"
         resultType="com.User">
         select * from user
         </select>
         */
        ClassLoader classLoader = XmlConfigParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(mapperFileName);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        List<Element> selectElements = document.selectNodes("//select");
        for (Element element : selectElements) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String sql = element.getText();
            SqlMapper sqlMapper = new SqlMapper();
            sqlMapper.setId(id);
            sqlMapper.setResultType(resultType);
            sqlMapper.setSql(sql);
            configuration.getSqlMappers().put(id, sqlMapper);
        }

    }
}
