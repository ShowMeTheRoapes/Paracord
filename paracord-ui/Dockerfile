# imports a base image with necessary things to run a node app
FROM node:12.2.0-alpine

# Copy all into container
COPY . /app

# Add node modules to path
ENV PATH /app/node_modules/.bin:$PATH

# Switch to app directory
WORKDIR /app

# Install npm dependencies
RUN yarn install

# Expose the container port to be mapped
EXPOSE 3000

# start the node application
CMD ["yarn", "start"]
