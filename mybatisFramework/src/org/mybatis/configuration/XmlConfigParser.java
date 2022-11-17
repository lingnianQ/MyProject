package org.mybatis.configuration;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlConfigParser {
   public static Configuration configuration=new Configuration();
   public static void parser(InputStream inputStream) throws Throwable{
       /**
        * <property name="driver" value="com.mysql"></>
        * <property name="url" value="testdb"></>
        * <property name="username" value="root"></>
        */
       SAXReader saxReader = new SAXReader();
       Document document = saxReader.read(inputStream);
       List<Element> propertyElement = document.selectNodes("//property");
       for(Element element:propertyElement){
           String valueOfName = element.attributeValue("name");
           String valueOfValue = element.attributeValue("value");
           switch (valueOfName){
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
       System.out.println(configuration);

   }
}
