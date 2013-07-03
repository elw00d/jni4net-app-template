rem uncomment next lines to force using 32-bit JRE
rem @set JAVA_HOME="c:\Program Files (x86)\Java\jdk1.7.0_25\"
rem @set PATH=%JAVA_HOME%\bin;%PATH%

java -cp jni4net.j-0.8.6.0.jar;java-app.jar -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=y su.elwood.Main