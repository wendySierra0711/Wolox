
<div>
  <h1>Naiofy</h1>
  <p>
    <br>Proyecto Gradle creado con el patrón de diseño Screenplay, en el cual se ejecutan pruebas para las apis de la empresa Naiofy y la validación de la funcionalidad de estas.<br>
    Para ejecutar el proyecto deberá tener las siguientes configuraciones en su entorno de desarrollo:
    Debe tener en cuenta configurar las variables de entorno correspondientes a cada uno de los siguientes puntos<br>
    **Tener instalado el JDK de java<br>
    **Tener instalado el gestor de dependencias(Maven/Gradle)<br><br>
    Posteriormente debe tener algún IDE de desarrollo de su preferencia o simplemente un editor de texto<br>
    En mi caso estoy utilizando Intellij, en el IDE debe configurar los plugins de Gradle, Git, Cucumber para Java y Gherkin para facilitar el trabajo.<br>
    Como las dependencias las está gestionando el build.gradle desde el repositorio de Maven, realizar un Gradle compileJava, para así descargar todas las librerías necesarias      para el proyecto <br>
    También para la ejecución de las pruebas, puede hacerlo directamente por el IDE o simplemente por líneas de comando<br>
      **Se sitúa sobre la raíz del proyecto con CMD y ejecuta el comando gradle clean test o cualquier otro comando que el gestor tiene a su disposición.<br>
  </p>
</div>

