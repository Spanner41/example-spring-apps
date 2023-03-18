# Image Server

This is an example of a server that generates and returns an SVG.

## Try it out

```shell
mvn clean package
java -jar target/image-server-0.0.1-SNAPSHOT.jar
```

After starting the server, send a `GET http://localhost:8080/loading/{value}.svg`. For example, the curl command would look like this:

```shell
curl --header "X-Api-Key: key-valid" http://localhost:8080/loading/75.svg
```

If this were a production application, I would optimize performance by caching the template instead of re-building it every time.
I didn't do it here because I'm using an SVG library that isn't thread-safe. 