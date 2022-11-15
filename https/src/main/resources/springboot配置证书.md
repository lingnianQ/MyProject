# 1.   创建证书


 第一步：为服务器生成证书 

 使用keytool 为 Tomcat 生成证书，假定目标机器的域名是“ localhost ”， keystore 文件存放在“ d:\tomcat.keystore ”，口令为“ password123 ”，使用如下命令生成： 

```cmd
keytool -genkey -v -alias tomcat -keyalg RSA -validity 3650 -keystore C:\Users\sytsn\Desktop\MyProject\https\src\main\resources\tomcat.keystore -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,c=cn" -storepass password123 -keypass password123
```


 这个tomcat.cer是为了解决不信任时要导入的 

```cmd
keytool -export -alias tomcat -keystore C:\Users\sytsn\Desktop\MyProject\https\src\main\resources\tomcat.keystore -file C:\Users\sytsn\Desktop\MyProject\https\src\main\resources\tomcat.cer -storepass password123
```



# 2.   创建springboot项目

## 2.1.    拷贝证书到resources

​                               

 

## 2.2.    Application.yml

```yml
server:
  # 服务器的HTTP端口，默认为8080
  port: 8080
  ssl:
    #文件所在位置
    key-store: classpath:tomcat.keystore
    #keystore的密码
    key-store-password: password123
    key-store-type: JKS
    key-alias: tomcat
```

## 2.3.    pom.xml  build中增加以下内容

```xml
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
        <excludes>
            <exclude>*.keystore</exclude>
        </excludes>
    </resource>
    <resource>
        <directory>src/main/resources</directory>
        <filtering>false</filtering>
        <includes>
            <include>*.keystore</include>
        </includes>
    </resource>
</resources>
```

## 2.4.    添加网页

 ~~~
 index.html
 ~~~

## 2.5.    访问

### 2.5.1. 端口号8080 

 https://localhost:8080/index.html

### 2.5.2. 端口号改成443

https://localhost/index.html

# 3.   验证用户身份

用手机号发验证码