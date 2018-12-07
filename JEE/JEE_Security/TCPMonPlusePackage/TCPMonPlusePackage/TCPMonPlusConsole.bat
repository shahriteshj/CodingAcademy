@ECHO OFF
set numArgs=0
for %%x in (%*) do Set /A numArgs+=1
IF %numArgs% LSS 3 (
	REM java -cp TCPMonPlus.jar com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -help
	echo Usage:  
	echo     TCPMonPlusConsole.bat local_port remote_server remote_port [true or false for ssl enabled]
	goto end
)
IF %numArgs% EQU 3 (
	java -cp TCPMonPlus.jar;apache-xml-xerces.jar com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -console %* false
	goto end
)
java -cp TCPMonPlus.jar;apache-xml-xerces.jar com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -console %*

:end
