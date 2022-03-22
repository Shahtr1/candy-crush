# candy-crush

This is a Java Spring Boot web application which uses jsp pages for displaying data.

The database used is mysql.

To connect to database, just run the docker file

```bash
docker-compose up
```

it will create a mysql docker container.

**Please Note**

Mysql is connected to the ip on port 3300. Please use workbench or any other client to access it, set url to 0.0.0.0 or <your-ip-address> and port to 3300.
If you use your ip-address instead of 0.0.0.0, you might need to change it in application.properties as well.
The app has been tested on 0.0.0.0.
or you can even access the mysql shell like this

	```bash
	docker exec -it <container-id> mysql -uuser -p
	```

After starting mysql, start the spring boot application, (i have used <b>JAVA 11</b> here). 

After starting app successfully, i sincerely hope it does! Go to 
	
	http://localhost:8080/apps/553834731

553834731 is the id of the app.

