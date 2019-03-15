#/bin/sh
./gradlew shadowJar
docker build -t mu51k-backend .