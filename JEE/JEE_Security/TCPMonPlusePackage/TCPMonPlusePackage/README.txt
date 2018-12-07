TcpMonPlus version 1.0: A Utility Application to Monitor TCP Packets
This utility application can be used to monitor the packets flowing on a TCP connection.
TcpMonPlus is used by placing it in-between a client and a server.
The client is configured to connect to TcpMonPlus and TcpMonPlus forwards the packets
to server with all required authentications.
The client must be configured to TcpMonPlus local Port that is it is listening to.
TcpMonPlus forwards the packets to the server and port specified in the configuraiton panel.
User Name and Password may be supplied if the server requires HTTP authentication.
NOTE: You can run the application in console mode using the following example command:
java -cp . com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -console 9080 192.168.1.1 9080 true

Using the scripts:
Or You may exeucte one of the scripts as follows:
Windows:
TCPMonPlus.bat		for graphical interface
TCPMonPlusConsole.bat	for console command line. Requires parameters: local_port remote_host remote_port  true|false for ssl enabled
TCPMonPlusConsole.bat	for console command line. Requires parameters: local_port remote_host remote_port  true|false -auth=true -username=_USERNAMe -password=_PASSWORD_ 
	                to enable authentication in cosole mode


Unix/Linux/AIX....
TCPMonPlus.sh		for graphical interface
TCPMonPlusConsole.sh	for console command line. Requires parameters: local_port remote_host remote_port  true|false -auth=true -username=_USERNAMe -password=_PASSWORD_ 
	                to enable authentication in cosole mode

Package available in:
sourceforge.netc