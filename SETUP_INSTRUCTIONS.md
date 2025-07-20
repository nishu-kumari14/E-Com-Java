# Java Shopping Cart - Complete Setup Instructions

## 📋 Prerequisites & Software Installation

### Step 1: Install Java Development Kit (JDK)
1. **Download Java JDK 17 or later:**
   - Visit: https://www.oracle.com/java/technologies/downloads/
   - Download JDK for your operating system (Windows/Mac/Linux)
   - Install the downloaded file

2. **Verify Java Installation:**
   ```bash
   java -version
   javac -version
   ```
   - You should see Java version 17 or higher

### Step 2: Install Apache Maven
1. **Download Maven:**
   - Visit: https://maven.apache.org/download.cgi
   - Download Binary zip archive (apache-maven-3.x.x-bin.zip)

2. **Install Maven:**
   - **Windows:** Extract to `C:\Program Files\Apache\maven`
   - **Mac/Linux:** Extract to `/opt/maven` or `/usr/local/maven`

3. **Set Environment Variables:**
   - **Windows:**
     - Add `MAVEN_HOME` = `C:\Program Files\Apache\maven`
     - Add `%MAVEN_HOME%\bin` to PATH
   - **Mac/Linux:**
     - Add to `~/.bashrc` or `~/.zshrc`:
     ```bash
     export MAVEN_HOME=/usr/local/maven
     export PATH=$MAVEN_HOME/bin:$PATH
     ```

4. **Verify Maven Installation:**
   ```bash
   mvn -version
   ```

### Step 3: Install MySQL Database
1. **Download MySQL:**
   - Visit: https://dev.mysql.com/downloads/mysql/
   - Download MySQL Community Server for your OS

2. **Install MySQL:**
   - Follow the installation wizard
   - **Remember the root password you set during installation**

3. **Install MySQL Workbench (Optional but Recommended):**
   - Visit: https://dev.mysql.com/downloads/workbench/
   - Download and install MySQL Workbench

### Step 4: Install Apache Tomcat 9
1. **Download Tomcat 9:**
   - Visit: https://tomcat.apache.org/download-90.cgi
   - Download "Core" zip file (apache-tomcat-9.x.x.zip)

2. **Extract Tomcat:**
   - **Windows:** Extract to `C:\Program Files\Apache\tomcat9`
   - **Mac/Linux:** Extract to `/opt/tomcat9` or `/usr/local/tomcat9`

## 🚀 Project Setup

### Step 5: Clone the Project
1. **Install Git (if not installed):**
   - Visit: https://git-scm.com/downloads

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/nishu-kumari14/E-Com-Java.git
   cd E-Com-Java
   ```

### Step 6: Database Setup
1. **Start MySQL Service:**
   - **Windows:** Start MySQL service from Services panel
   - **Mac:** `sudo brew services start mysql` (if installed via Homebrew)
   - **Linux:** `sudo systemctl start mysql`

2. **Create Database:**
   ```bash
   # Open MySQL command line or MySQL Workbench
   mysql -u root -p
   ```
   
3. **Run Database Script:**
   ```sql
   -- In MySQL command line or Workbench, run:
   source /path/to/E-Com-Java/databases/mysql_query_fixed.sql
   ```
   
   **Or copy-paste the content of `databases/mysql_query_fixed.sql` into MySQL Workbench and execute**

4. **Create Application Database User:**
   ```sql
   CREATE USER 'shoppingcart'@'localhost' IDENTIFIED BY 'shopping123';
   GRANT ALL PRIVILEGES ON shopping_cart.* TO 'shoppingcart'@'localhost';
   FLUSH PRIVILEGES;
   ```

### Step 7: Configure Application
1. **Copy Configuration File:**
   ```bash
   cp src/application.properties.example src/application.properties
   ```

2. **Edit Configuration:**
   Open `src/application.properties` and update:
   ```properties
   # Database Configuration
   db.driver=com.mysql.cj.jdbc.Driver
   db.url=jdbc:mysql://localhost:3306/shopping_cart?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   db.username=shoppingcart
   db.password=shopping123

   # Email Configuration (Optional - for notifications)
   mail.smtp.host=smtp.gmail.com
   mail.smtp.port=587
   mail.smtp.auth=true
   mail.smtp.starttls.enable=true
   mail.username=your_email@gmail.com
   mail.password=your_app_password
   ```

### Step 8: Build the Project
1. **Navigate to Project Directory:**
   ```bash
   cd E-Com-Java
   ```

2. **Build with Maven:**
   ```bash
   mvn clean package
   ```
   - This will create a WAR file in the `target/` directory

### Step 9: Deploy to Tomcat
1. **Copy WAR File:**
   ```bash
   # Copy the generated WAR file to Tomcat webapps directory
   cp target/shopping-cart.war /path/to/tomcat9/webapps/
   ```

2. **Start Tomcat:**
   - **Windows:** 
     ```bash
     cd C:\Program Files\Apache\tomcat9\bin
     startup.bat
     ```
   - **Mac/Linux:**
     ```bash
     cd /opt/tomcat9/bin
     ./startup.sh
     ```

### Step 10: Load Product Images (Important!)
1. **Compile and Run Image Loader:**
   ```bash
   # From project directory
   mvn compile exec:java -Dexec.mainClass="com.shashi.test.LoadProductImages"
   ```

## 🌐 Access the Application

### Step 11: Open in Browser
1. **Visit:** http://localhost:8080/shopping-cart/

2. **Default Login Credentials:**
   - **Admin:** 
     - Username: `admin@gmail.com`
     - Password: `admin`
   - **User:** 
     - Username: `guest@gmail.com`
     - Password: `guest`

## 🔧 Troubleshooting

### Common Issues:

1. **Port 8080 Already in Use:**
   - Change Tomcat port in `conf/server.xml`
   - Look for `<Connector port="8080"` and change to `8081` or other port

2. **Database Connection Failed:**
   - Verify MySQL is running
   - Check database credentials in `application.properties`
   - Ensure database user has proper permissions

3. **Images Not Loading:**
   - Make sure you ran the LoadProductImages step
   - Check database connectivity

4. **Maven Build Fails:**
   - Ensure internet connection for downloading dependencies
   - Try: `mvn clean install -U`

5. **Tomcat Won't Start:**
   - Check if Java is properly installed
   - Verify JAVA_HOME environment variable
   - Check Tomcat logs in `logs/catalina.out`

## 📧 Email Configuration (Optional)

To enable email notifications:

1. **Create Gmail App Password:**
   - Go to Google Account Settings → Security
   - Enable 2-Step Verification
   - Generate App Password for "Custom App"

2. **Update Configuration:**
   - Add your Gmail and app password to `application.properties`

## 🎯 Quick Start Commands

```bash
# 1. Clone project
git clone https://github.com/nishu-kumari14/E-Com-Java.git
cd E-Com-Java

# 2. Setup database (run mysql_query_fixed.sql)

# 3. Configure application
cp src/application.properties.example src/application.properties
# Edit the file with your database credentials

# 4. Build project
mvn clean package

# 5. Deploy to Tomcat
cp target/shopping-cart.war /path/to/tomcat/webapps/

# 6. Start Tomcat
/path/to/tomcat/bin/startup.sh  # Linux/Mac
# OR
\path\to\tomcat\bin\startup.bat  # Windows

# 7. Load product images
mvn compile exec:java -Dexec.mainClass="com.shashi.test.LoadProductImages"

# 8. Access: http://localhost:8080/shopping-cart/
```

## ✅ Verification Checklist

- [ ] Java JDK 17+ installed and `java -version` works
- [ ] Maven installed and `mvn -version` works  
- [ ] MySQL installed and running
- [ ] Database created using mysql_query_fixed.sql
- [ ] Database user 'shoppingcart' created with proper permissions
- [ ] Project cloned from GitHub
- [ ] application.properties configured with correct database credentials
- [ ] Project built successfully with `mvn clean package`
- [ ] WAR file deployed to Tomcat webapps directory
- [ ] Tomcat started successfully
- [ ] Product images loaded into database
- [ ] Application accessible at http://localhost:8080/shopping-cart/
- [ ] Can login with admin@gmail.com/admin or guest@gmail.com/guest

## 🎉 Success!

Your Java Shopping Cart application should now be running successfully!

**Need Help?** 
- Check the troubleshooting section above
- Verify each step was completed correctly
- Check application logs in Tomcat's `logs/` directory
