# programacion4-proyecto1-s1-2023
proyecto 1 del curso programación 4 semestre 1 2023 sistema de polizas UNA.

## Autenticacion con la base de datos

la base de datos se conecta con las credenciales proporcionadas en su archivo de manifiesto, localizado en

```
/backend/src/main/resources/configuraciones/credenciales-bd.properties

📦backend
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📂configuraciones
 ┃ ┃ ┃ ┃ ┗ 📜credenciales-bd.properties
 ┣ 📜.gitignore
 ┗ 📜pom.xml
```

puede modificarse este archivo para usar las credenciales correctas, o agregar
el usuario requerido mediante 

```sql
CREATE USER 'admin'@'%' IDENTIFIED BY 'changeme';
```

## permisos

```sql
GRANT ALL PRIVILEGES ON polizas.* TO 'admin'@'%';
GRANT EXECUTE ON `polizas`.* TO 'admin'@'%';
GRANT SELECT ON mysql.proc TO 'admin'@'%';
FLUSH PRIVILEGES;
```

## generar certificados para claves JWT

para el uso de tokens JWT se requieren certificados, puede generar los suyos si así lo desea, las configuraciones de ruta se ubican en el siguiente archivo.

```
/frontend/src/main/resources/configuraciones/jwt.properties

📦frontend
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📂configuraciones
 ┃ ┃ ┃ ┃ ┗ 📜jwt.properties
 ┣ 📜.gitignore
 ┗ 📜pom.xml
```

posteriormente modifique el archivo `jwt.properties` para que apunte a los certificados generados

De lo contrario la aplicación se encargará de generar las claves por si solo
