FROM node:20.11.1-slim
EXPOSE 3000
ADD ./ /front
WORKDIR /front
RUN npm install
ENTRYPOINT ["npm", "run", "start"]