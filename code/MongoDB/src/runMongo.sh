#!/usr/bin/env bash

cp -r -n /data/db/* /var/lib/mongo

mongod --bind_ip_all --dbpath /var/lib/mongo