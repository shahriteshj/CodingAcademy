#!/bin/sh
function usage
if [ $# -lt 3 ]; then
    if [ "$1" = "-h" -o "$1" = "-help" -o "$1" = "--help" ]; then
        echo Usage:  
	echo     TCPMonPlusConsole.bat local_port remote_server remote_port [true or false for ssl enabled]
        exit 0
    fi
fi
if [ $# -eq 3 ]; then
	java -cp TCPMonPlus.jar:apache-xml-xerces.jar com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -console $1 $2 $3 false
else 
	java -cp TCPMonPlus.jar:apache-xml-xerces.jar com.yasmoicoco.proxy.tcpmon.TCPMonitorPlus -console  $@
fi

