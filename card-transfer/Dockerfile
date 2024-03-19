FROM node:latest
WORKDIR /g/transfer-money/card-transfer
COPY package*.json ./
EXPOSE 3000
RUN npm install
COPY . .
CMD ["npm",  "run", "serve"]