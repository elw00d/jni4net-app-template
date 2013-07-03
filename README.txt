How-to build and run:

1. Go to net-app directory and open net-app.sln Visual Studio. Build project.

2. Run ant in root directory

3. Go to build\java-app directory. There are run.bat and run-jpda-wait.bat file you can
   use to execute your java-with-dotnet-application.

Remarks (russian only yet):

0. Почему-то proxygen не обрабатывает exe-файлы, вы обязаны делать dll.

1. Если вам нужно, чтобы ваша дотнетовая сборка была 32-битной (собрана не для AnyCpu, а для x86 -
   такое бывает необходимо, если вы взаимодействуете с 32-битным COM-окружением), то proxygen не будет работать.
   Чтобы это исправить нужно пропатчить proxygen командой

    corflags bin\proxygen.exe /32BIT+ /force

   ( см https://groups.google.com/forum/#!topic/jni4net/jiH3ItdNQ1Y )

2. Соответственно, для того, чтобы грузилась 32-битная версия CLR, нужно, чтобы и JVM была 32-битной.
   Для этого на 64разрядной машине нужно установить 32-битную JDK (JRE) и прописать её в качестве
   JAVA_HOME в скрипте запуска программы. После этого jni4net загрузит соответствующий нативный
   32-битную DLL-переходник, и, в конечном итоге, 32-битную версию CLR.

3. В принципе, если вы используете 32-битную JVM, то вам не нужно собирать ваши дотнетовые сборки для x86
   явно. Так как в 32-битном процессе JVM jni4net будет грузить 32-битную версию CLR, то и дотнетовая
   сборка будет загружена в 32-битное адресное пространство, и выставленный AnyCpu не помешает.