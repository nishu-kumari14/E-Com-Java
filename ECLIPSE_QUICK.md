# Eclipse Quick Setup - Java Shopping Cart

## 🎯 Essential Eclipse Steps (15 minutes)

### 1. Import Project
```
File → Import → Git → Projects from Git → Clone URI
URI: https://github.com/nishu-kumari14/E-Com-Java.git
```

### 2. Configure as Maven Project
```
Right-click project → Configure → Convert to Maven Project
Right-click project → Maven → Update Project
```

### 3. Setup Database
```sql
-- In MySQL Workbench or command line:
source /path/to/databases/mysql_query_fixed.sql
CREATE USER 'shoppingcart'@'localhost' IDENTIFIED BY 'shopping123';
GRANT ALL PRIVILEGES ON shopping_cart.* TO 'shoppingcart'@'localhost';
```

### 4. Configure Properties
```
Copy: src/application.properties.example 
To: src/application.properties
Update database credentials in the new file
```

### 5. Build Project
```
Right-click project → Run As → Maven build
Goals: clean install
```

### 6. Setup Tomcat Server
```
Right-click project → Run As → Run on Server
Select: Apache Tomcat v9.0 Server
Add project to server
```

### 7. Load Product Images
```
Right-click: src/com/shashi/test/LoadProductImages.java
Run As → Java Application
```

### 8. Start Server & Access
```
Server tab → Right-click Tomcat → Start
Browser: http://localhost:8080/shopping-cart/
Login: admin@gmail.com / admin
```

## 🚨 Common Eclipse Issues

**Build Path Errors:**
- Right-click project → Properties → Java Build Path → Libraries
- Remove libraries with red X marks
- Add Library → Server Runtime → Select Tomcat

**Port 8080 Busy:**
- Server tab → Double-click Tomcat → Ports → Change HTTP/1.1 to 8081

**Maven Dependencies:**
- Right-click project → Maven → Update Project → Force Update

**For complete details, see [ECLIPSE_SETUP.md](ECLIPSE_SETUP.md)**
