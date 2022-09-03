#!/usr/bin/env bash

(mongod &)

sleep 30

mongo --eval "db.getSiblingDB('admin').createUser({user:'admin', pwd:'admin',
      roles:[{role: 'dbAdminAnyDatabase',db:'admin'},{role: 'userAdminAnyDatabase',db: 'admin'},{role: 'readWriteAnyDatabase', db: 'admin'},{role: 'clusterAdmin',db: 'admin'}]})"

for folder in $(find collections/* -type 'd'); do
    db_name=$(echo "${folder}" | cut -d'/' -f2)
    for file in $(find "${folder}" -type f -name '*.json'); do
        collection=$(echo "${file}" | cut -d'/' -f3)
        mongoimport --db "${db_name}" --username admin --password admin --authenticationDatabase admin --collection "${collection%.*}" --type json --file "${file}"
     done
done

mongod --shutdown