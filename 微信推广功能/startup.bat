@echo off
rem 获取当前服务的根目录
set RUN_CLASS=com.ms.warehouse.user.Setup
set SERVER_NAME=WXUSER

cd ..
set BASE_PATH=%cd%
set "CONF_PATH=%cd%\conf"
set "LOG_PATH=%cd%\logs"
set "STDOUT_FILE=%LOG_PATH%\stdout.log"
set "LIB_DIR=%BASE_PATH%\lib"

echo 创建服务 %SERVER_NAME%

echo 读取依赖文件
rem 设置java运行环境
set "JAVA_OPTS=-DappName=%SERVER_NAME% -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Ddubbo.shutdown.hook=true -Dfile.encoding=UTF-8"
set "JAVA_JMX_OPTS= -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
set "JAVA_MEM_SIZE_OPTS=-Xmx768m -Xms378m -Xmn256m -XX:PermSize=64m -XX:MaxPermSize=256M -Xss256k"
set "JAVA_MEM_OPTS= -server %JAVA_MEM_SIZE_OPTS% -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
echo 设置JVM信息
java %JAVA_OPTS% %JAVA_MEM_OPTS% %JAVA_JMX_OPTS% -classpath %CONF_PATH%;%LIB_DIR%\* %RUN_CLASS% > %STDOUT_FILE% 2>&1 &
pause