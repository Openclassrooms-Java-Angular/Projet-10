# utiliser une image officielle de Node.js 18
FROM node:18 AS build

# définir le répertoire de travail
WORKDIR /usr/local/app

# copier les fichiers package.json et package-lock.json et télécharger les dépendances avec mise en cache
COPY package*.json ./
RUN npm ci

# copier les sources du projet et construire l'application
COPY src ./src
COPY angular.json .
COPY tsconfig.json .

# build Angular
RUN npm run build

# utiliser une image officielle de nginx
FROM nginx:alpine

# nettoyage avant copie
RUN rm -rf /usr/share/nginx/html/*

# copier les fichiers générés
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/local/app/dist/bobapp /usr/share/nginx/html

# exposer le port pour accéder à l'application
EXPOSE 80
