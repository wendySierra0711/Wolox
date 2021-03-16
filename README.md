Para ejecutar el proyecto deberá tener las siguientes configuraciones en su entorno de desarrollo 
Debe tener en cuenta configurar las variables de entorno correspondientes a cada uno de los siguientes puntos
**Tener instalado el JDK de java
**Tener instalado el gestor de dependencias(maven/gradle), en mi caso estoy utilizado gradle

Posteriormente debe tener algún IDE de desarrollo de su preferencia o simplemente un editor de texto
en mi caso estoy utilizando intellij, en el IDE debe configurar los plugins de gradle,git,cucumber para java y gherkin para facilitar el trabajo.

como las dependencias las está gestionando el build.gradle desde el repositorio de maven, realizar un gradle compileJava 
para así descargar todas las librerías necesarias para el proyecto 

Para la ejecución de los test, lo puede hacer directamente por el IDE o simplemente por líneas de comando
**Se sitúa sobre la raíz del proyecto con CMD y ejecuta el comando gradle clean test o cualquier otro comando que el gestor tiene a su disposición

