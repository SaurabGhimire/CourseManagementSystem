SETUP ENV FILE

Create a ".env" file using any text editor in the root of the project
in the same range as "src" and ".pom.xml"
Your folder structure should look like the following:
    src
    .env
    .gitignore
    pom.xml
Add the following in env files or as according to your configuration
DB_URL=jdbc:mysql://localhost:3306/cs544-project?useSSL=false&serverTimezone=UTC
DB_USERNAME=root
DB_PASSWORD=123456

SWAGGER DOCUMENTATION:
Head over to "http://localhost:8080/swagger-ui/index.html"
You should see all the available Api