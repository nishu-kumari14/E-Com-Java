# Running Java Shopping Cart in Eclipse IDE

## 📋 Prerequisites

### 1. Install Eclipse IDE for Enterprise Java Developers
1. **Download Eclipse IDE:**
   - Visit: https://www.eclipse.org/downloads/
   - Download "Eclipse IDE for Enterprise Java and Web Developers"
   - Install the downloaded package

2. **Required Software (if not already installed):**
   - Java JDK 17+ 
   - MySQL Server
   - Apache Tomcat 9.x
   - Git (for cloning)

## 🚀 Step-by-Step Eclipse Setup

### Step 1: Clone the Project in Eclipse

1. **Open Eclipse**
2. **Import Project from Git:**
   - Go to `File` → `Import`
   - Select `Git` → `Projects from Git` → `Next`
   - Choose `Clone URI` → `Next`
   - **URI:** `https://github.com/nishu-kumari14/E-Com-Java.git`
   - Click `Next` → `Next` → `Finish`

### Step 2: Configure Project as Maven Project

1. **Right-click on the project** in Project Explorer
2. **Configure** → **Convert to Maven Project**
3. If already a Maven project, go to:
   - Right-click project → `Maven` → `Reload Projects`

### Step 3: Database Setup

1. **Start MySQL Server**
2. **Create Database:**
   ```sql
   -- Open MySQL Workbench or command line
   mysql -u root -p
   
   -- Run the database script
   source /path/to/project/databases/mysql_query_fixed.sql
   
   -- Create application user
   CREATE USER 'shoppingcart'@'localhost' IDENTIFIED BY 'shopping123';
   GRANT ALL PRIVILEGES ON shopping_cart.* TO 'shoppingcart'@'localhost';
   FLUSH PRIVILEGES;
   ```

### Step 4: Configure Application Properties

1. **In Eclipse Project Explorer:**
   - Navigate to `src` → `application.properties.example`
   - **Copy** the file
   - **Paste** and rename to `application.properties`

2. **Edit `application.properties`:**
   ```properties
   # Database Configuration
   db.driver=com.mysql.cj.jdbc.Driver
   db.url=jdbc:mysql://localhost:3306/shopping_cart?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   db.username=shoppingcart
   db.password=shopping123

   # Email Configuration (Optional)
   mail.smtp.host=smtp.gmail.com
   mail.smtp.port=587
   mail.smtp.auth=true
   mail.smtp.starttls.enable=true
   mail.username=your_email@gmail.com
   mail.password=your_app_password
   ```

### Step 5: Build the Project with Maven

1. **Right-click on project** → `Run As` → `Maven build...`
2. **Goals:** Enter `clean install`
3. Click `Run`
4. **Wait for build to complete** (check Console for "BUILD SUCCESS")

### Step 6: Configure Tomcat Server in Eclipse

#### Option A: If Tomcat is NOT configured in Eclipse

1. **Right-click on project** → `Run As` → `Run on Server`
2. **Select:** `Manually define a new server`
3. **Server Type:** Apache → Tomcat v9.0 Server
4. **Next** → **Browse** to your Tomcat installation directory
5. **Next** → **Add** the shopping-cart project → **Finish**

#### Option B: If Tomcat is ALREADY configured

1. **Right-click on project** → `Run As` → `Run on Server`
2. **Select** your existing Tomcat server
3. **Next** → **Add** the project → **Finish**

### Step 7: Load Product Images

1. **In Eclipse, navigate to:**
   - `src` → `com.shashi.test` → `LoadProductImages.java`

2. **Run the image loader:**
   - Right-click on `LoadProductImages.java`
   - `Run As` → `Java Application`
   - Check console for success messages

### Step 8: Start the Application

1. **Method 1 - Using Server Tab:**
   - Go to `Server` tab (usually at bottom of Eclipse)
   - Right-click on your Tomcat server
   - Click `Start`

2. **Method 2 - Using Run Configuration:**
   - Right-click on project → `Run As` → `Run on Server`
   - Select your Tomcat server → `Finish`

### Step 9: Access the Application

1. **Open Browser** and go to: `http://localhost:8080/shopping-cart/`

2. **Default Login Credentials:**
   - **Admin:** `admin@gmail.com` / `admin`
   - **User:** `guest@gmail.com` / `guest`

## 🔧 Troubleshooting in Eclipse

### Common Issues:

#### 1. **Build Path Errors (Red X marks)**
**Solution:**
- Right-click project → `Properties`
- Go to `Java Build Path` → `Libraries`
- Remove any libraries with red X marks
- Click `Modulepath` or `Classpath` → `Add Library` → `Server Runtime` → Select Tomcat
- Apply and Close

#### 2. **Maven Dependencies Not Resolved**
**Solution:**
- Right-click project → `Maven` → `Update Project`
- Check `Force Update of Snapshots/Releases`
- Click `OK`

#### 3. **Server Won't Start - Port Already in Use**
**Solution:**
- Go to `Servers` tab
- Double-click on Tomcat server
- In `Ports` section, change HTTP/1.1 port from 8080 to 8081
- Save and restart server
- Access at: `http://localhost:8081/shopping-cart/`

#### 4. **Database Connection Error**
**Solution:**
- Verify MySQL is running
- Check credentials in `application.properties`
- Test database connection:
  - Right-click on `DatabaseTest.java` in `com.shashi.test`
  - `Run As` → `Java Application`

#### 5. **Images Not Loading**
**Solution:**
- Make sure you ran `LoadProductImages.java`
- Check console for any database errors
- Verify ShowImage servlet is working

#### 6. **Project Not Deploying to Tomcat**
**Solution:**
- Right-click project → `Properties` → `Project Facets`
- Ensure `Java` version matches your JDK
- Enable `Dynamic Web Module` (version 3.1)
- Apply changes

### Eclipse-Specific Tips:

#### Enable Auto-Refresh:
- `Window` → `Preferences` → `General` → `Workspace`
- Check `Refresh using native hooks or polling`

#### Console Output:
- Check `Console` tab for build/runtime logs
- Switch between different consoles using the console dropdown

#### Hot Deployment:
- Eclipse auto-deploys changes when you save files
- For JSP changes: Just refresh browser
- For Java changes: Eclipse auto-compiles and redeploys

## 📊 Project Structure in Eclipse

```
shopping-cart/
├── src/main/java (or just src/)
│   ├── com.shashi.beans/          # Data models
│   ├── com.shashi.service/        # Business logic interfaces
│   ├── com.shashi.service.impl/   # Business logic implementation
│   ├── com.shashi.srv/            # Servlets
│   ├── com.shashi.utility/        # Utility classes
│   ├── com.shashi.test/           # Test and setup classes
│   └── application.properties     # Configuration
├── WebContent/                    # Web resources
│   ├── WEB-INF/web.xml           # Servlet configuration
│   ├── *.jsp                     # JSP pages
│   ├── css/                      # Stylesheets
│   ├── js/                       # JavaScript files
│   └── images/                   # Static images
├── databases/                     # Database scripts
└── pom.xml                       # Maven configuration
```

## ⚡ Quick Commands in Eclipse

- **Build Project:** `Ctrl+B` or Right-click → `Refresh`
- **Run on Server:** `Alt+Shift+X, R`
- **Clean Build:** Right-click → `Maven` → `Clean`
- **Restart Server:** Server tab → Right-click → `Restart`
- **View Problems:** `Window` → `Show View` → `Problems`

## ✅ Verification Checklist

- [ ] Project imported from Git successfully
- [ ] Maven dependencies resolved (no red errors in Package Explorer)
- [ ] Database created and user configured
- [ ] `application.properties` configured with correct database credentials
- [ ] Project builds successfully with Maven
- [ ] Tomcat server configured and added to project
- [ ] Product images loaded using `LoadProductImages.java`
- [ ] Server starts without errors
- [ ] Application accessible at `http://localhost:8080/shopping-cart/`
- [ ] Can login with default credentials
- [ ] Images display correctly on product pages

## 🎯 Development Workflow in Eclipse

1. **Make Code Changes** → Eclipse auto-compiles
2. **Save Files** → Eclipse auto-deploys to Tomcat
3. **Refresh Browser** → See changes immediately
4. **Check Console** → Monitor for any errors
5. **Debug if needed** → Use Eclipse debugger

Your Java Shopping Cart application should now be running successfully in Eclipse! 🎉
