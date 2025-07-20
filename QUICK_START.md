# Quick Setup Guide - Java Shopping Cart

## 🚀 Essential Steps (30 minutes)

### 1. Install Required Software
```bash
# Install Java 17+, Maven, MySQL, Tomcat 9
```

### 2. Setup Database
```sql
-- Run in MySQL:
mysql -u root -p
source /path/to/databases/mysql_query_fixed.sql
CREATE USER 'shoppingcart'@'localhost' IDENTIFIED BY 'shopping123';
GRANT ALL PRIVILEGES ON shopping_cart.* TO 'shoppingcart'@'localhost';
```

### 3. Clone & Configure
```bash
git clone https://github.com/nishu-kumari14/E-Com-Java.git
cd E-Com-Java
cp src/application.properties.example src/application.properties
# Edit application.properties with your database credentials
```

### 4. Build & Deploy
```bash
mvn clean package
cp target/shopping-cart.war /path/to/tomcat/webapps/
/path/to/tomcat/bin/startup.sh
mvn compile exec:java -Dexec.mainClass="com.shashi.test.LoadProductImages"
```

### 5. Access Application
**URL:** http://localhost:8080/shopping-cart/
**Login:** admin@gmail.com / admin

## 📋 Software Download Links
- **Java JDK:** https://www.oracle.com/java/technologies/downloads/
- **Maven:** https://maven.apache.org/download.cgi
- **MySQL:** https://dev.mysql.com/downloads/mysql/
- **Tomcat 9:** https://tomcat.apache.org/download-90.cgi

## ⚡ Default Credentials
- **Admin:** admin@gmail.com / admin
- **User:** guest@gmail.com / guest

**For detailed instructions, see `SETUP_INSTRUCTIONS.md`**
