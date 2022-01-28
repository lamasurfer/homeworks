# Задача Прокси на nginx

```
server {
    ...
    listen       80;
    server_name  localhost;
    root /var/jclorest/static;

    location / {
            proxy_pass http://localhost:8080;
    }

    location /signin {
            try_files $uri $uri.html =404;
    }
    ...
}
```




