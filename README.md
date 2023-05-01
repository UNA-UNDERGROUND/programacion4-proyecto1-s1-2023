# programacion4-proyecto1-s1-2023
proyecto 1 del curso programación 4 semestre 1 2023 sistema de polizas UNA.


## permisos

```sql
GRANT ALL PRIVILEGES ON polizas.* TO 'admin'@'%';
GRANT EXECUTE ON `polizas`.* TO 'admin'@'%';
GRANT SELECT ON mysql.proc TO 'admin'@'%';
FLUSH PRIVILEGES;
```