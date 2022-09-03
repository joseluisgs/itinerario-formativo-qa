# MongoDB docker image

## With Dockerfile

Generate docker image

```bash
docker build -t <image_name> .
```

Run docker container

```bash
docker run -p 27017:27017 --name <container_name> <image_name>
```

And with these only two commands we have a collection with data to do the mondodb exercieses for the intermediate level.

## Using docker-compose (not recommended)

```bash
docker-compose up
```

After creating the container, we run a command to find out the name of the container:

```bash
docker ps
```

Enter in the container:

```bash
docker exec -it <container_name> /bin/bash
```

Enter in the mongo shell:

```bash
mongo admin -u root -p password
```

Use mongoimport to import data in the database:

```bash
mongoimport --host "localhost:27017" --db <db_name> --collection <collection_name> --drop --type json --file "/scripts/inventory.json" --jsonArray
```

There is other option to do this. You can install MongoDB Compass, connect to the database and import the script (collection/users/users.json) to have information.
