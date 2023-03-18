# API Rate Limiting

This is an example of an endpoint that requires an API Key, and it limits each user to 5 requests per minute.
This server requires an `X-Api-Key` header and will accept any key ending in `valid`.

## Try it out

```shell
mvn clean package
java -jar target/api-rate-limiting-0.0.1-SNAPSHOT.jar
```

After starting the server, send a `GET http://localhost:8080/order`. For example, the curl command would look like this:

```shell
curl --header "X-Api-Key: key-valid" http://localhost:8080/order
```

The sixth request in a minute should return a `429 Too Many Requests` status.