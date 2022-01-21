# PicBucket

PicBucket es una API para el almacenamiento de imagenes. Usa MongoDB para el almacenamiento de datos (archivo y metadata).

## Endpoints

* **GET /api/picbucket/photos:** Listar todas las fotos almacenadas.
* **GET /api/picbucket/photos/{id}:** Mostrar los datos de la imagen.
* **GET /api/picbucket/photos/view/{id}:** Visualizar la imagen.
* **POST /api/picbucket/photos:** Almacenar una imagen. Se requiere permisos de ROLE_USER.
* **GET /api/users/register:** Crea nuevo usuario en el sistema.
* **GET /api/users/users:** Listar todos los usuarios registrados. Se requiere permisos de ROLE_ADMIN.
* **GET /api/users/roles:** Listar todos los roles registrados. Se requiere permisos de ROLE_ADMIN.
* **GET /api/users/roles/assign:** Asigna un ROLE a USER. Se requiere permisos de ROLE_ADMIN.
* **GET /api/users/refresh:** Devuelve un nuevo ACCESS_TOKEN para el uso del sistema.
