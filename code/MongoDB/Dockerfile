# Use Centos7 as base image
FROM registry.access.redhat.com/ubi7/ubi:7.7-99

# Maintainer of the Dockerfile
LABEL maintainer "QA"

# Input data
ARG MONGODB_VERSION=4.0.10

# Switch to ROOT user to do maintenance tasks
USER root

# Set workdir to tmp
WORKDIR /tmp

# Install additional yum packages
RUN yum -y --setopt=tsflags=nodocs install \
    libcurl openssl tar curl

# Copy mongodb repo
COPY src/mongodb-org-4.0.repo /etc/yum.repos.d/

# Install mongodb
RUN yum -y --setopt=tsflags=nodocs install \
    mongodb-org-4.0.10 mongodb-org-server-4.0.10 \
    mongodb-org-shell-4.0.10 mongodb-org-mongos-4.0.10 mongodb-org-tools-4.0.10

# Clean up tmp directory
RUN rm --recursive --force -- /tmp/*

# Create required folders
RUN mkdir -p /data/db

# Copy collections
COPY src/collections /tmp/collections

# Copy bash scripts
COPY src/*.sh /usr/local/bin/

# Execute seed data script
RUN /usr/local/bin/seedMongo.sh

# Update created files to be editable by root group
RUN chown -R mongod:root /data /var/lib/mongo /var/log/mongodb /var/run/mongodb \
    && chmod -R 0660 /data /data/db /data/db/journal /data/db/diagnostic.data /var/lib/mongo /var/log/mongodb /var/run/mongodb \
    && chmod 0770 /data /data/db /data/db/journal /data/db/diagnostic.data /var/lib/mongo /var/log/mongodb /var/run/mongodb

# Use non-root user
USER mongod

# Set entrypoint
ENTRYPOINT [ "sh", "-c", "/usr/local/bin/runMongo.sh" ]