# MySQL docker image

## How to use

```bash
docker-compose up
```

It'll create a container with MySQL.

After that, we need to create the database and run two scripts to populate the database. To do that, we need to follow these steps:

1. Find out the container name

    ```bash
    docker ps -a
    ```

    In this case, the database name is: `mysql-testing-db`

2. Access to the container
  
    ```bash
    docker exec -it mysql-testing-db /bin/bash
    ```

3. Access to MySQL

    ```bash
    mysql -uroot -ppassword
    ```

4. We need to run two scripts to create the tables and populate them:
   1. Create tables

      ```bash
      source scripts/sakila-schema.sql
      ```

   2. Populate tables

      ```bash
      source scripts/sakila-data.sql
      ```

5. We can do a query to check everything is ok

```bash
> use sakila

> select * from country
```

If we results, everything was properly installed.
