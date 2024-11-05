## Descripción del Sistema de Alertas

El Sistema de Alertas es una aplicación web diseñada para gestionar y visualizar alertas en tiempo real. Utiliza **Spring Boot** para el backend, **Thymeleaf** para el frontend, y **Firebase** para la autenticación y almacenamiento de datos. El sistema permite a los usuarios recibir alertas inmediatas sobre diversos eventos críticos, como emergencias médicas, delitos, incendios, y más.

### Funcionalidades

- **Autenticación de Usuarios:** Implementación de un sistema de autenticación seguro que permite a los usuarios registrarse y acceder a la aplicación.
- **Gestión de Alertas:** Los usuarios pueden recibir y visualizar alertas en tiempo real mediante un flujo continuo de datos.
- **Interfaz Dinámica:** La interfaz de usuario se actualiza dinámicamente sin necesidad de recargar la página, utilizando Server-Sent Events (SSE) para enviar actualizaciones de alertas a los clientes.

### Problemas Encontrados y Soluciones

Durante el desarrollo del sistema, se presentaron varios desafíos relacionados con el manejo de flujos reactivos en combinación con Thymeleaf. La integración de flujos reactivos con la lógica de vista de Thymeleaf resultó ser compleja, ya que Thymeleaf no está diseñado para trabajar directamente con flujos de datos reactivos.

Para solucionar este problema, implementé **Server-Sent Events (SSE)**. Esta técnica permite a los servidores enviar actualizaciones automáticamente a los clientes a través de una conexión HTTP mantenida, facilitando la entrega de alertas en tiempo real a la interfaz de usuario sin requerir actualizaciones manuales de la página. Esta solución no solo mejoró la experiencia del usuario, sino que también simplificó la gestión de estados en la aplicación.

### Tecnologías Utilizadas

- **Spring Boot**: Para el desarrollo del backend y la creación de APIs RESTful.
- **Thymeleaf**: Como motor de plantillas para generar el frontend.
- **Firebase**: Para la autenticación de usuarios y almacenamiento de datos.
- **Server-Sent Events (SSE)**: Para el envío de alertas en tiempo real a la interfaz de usuario.

### Instalación

1. Clona este repositorio.
2. Asegúrate de tener JDK 11 o superior instalado.
3. Configura tu conexión a Firebase y las credenciales necesarias.
4. Ejecuta la aplicación desde tu IDE

### Imagenes Demostracion
![image](https://github.com/user-attachments/assets/0d95cc33-3721-4e8d-bf0f-fad7ea3b18d2)
![image](https://github.com/user-attachments/assets/38f611f7-5b68-4855-8050-5207dc0ebbe1)
![image](https://github.com/user-attachments/assets/2c9335c8-6d32-4122-a429-118d65f59f56)
![image](https://github.com/user-attachments/assets/02dbdd37-e404-4a55-bb5b-76a55c6e1cdd)
![image](https://github.com/user-attachments/assets/9a888493-b7e3-4b0b-b59c-77ce9a89e0f1)


### Videos Demostraciones
https://drive.google.com/drive/folders/1I1PtBVASMwIdViJuSarHvQsiUrdw6yUO
- **Tik Tok Compañero**: https://vm.tiktok.com/ZMh4M3ugv/
