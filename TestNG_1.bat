cd D:\Automated_Tools\WorkspacePooja\DemoDataProvider
Set Project_Path=D:\Automated_Tools\WorkspacePooja\DemoDataProvider
echo %Project_Path%
set classpath=%Project_Path%\bin;%Project_Path%\lib\*
echo %classpath%
java  org.testng.TestNG %Project_Path%\testng.xml


