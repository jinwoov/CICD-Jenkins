FROM node:latest

WORKDIR /app

COPY ./mock ./

WORKDIR /app/client

EXPOSE 3000

RUN npm install

ENV NODE_ENV=production

CMD [ "npm", "run", "start" ]


