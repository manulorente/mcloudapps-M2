# WebServicesTesting-P02

## Install npm and all dependencies for Artillery in windows

### Install latest NVM for Windows

`https://github.com/coreybutler/nvm-windows/releases`

### Once the installation is complete. Open PowerShell (recommend opening with elevated Admin permissions) and try using windows-nvm to list which versions of Node are currently installed (should be none at this point)

`PS C:\Windows\system32> nvm ls`

<https://learn.microsoft.com/en-us/windows/dev-environment/javascript/nodejs-on-windows#install-nvm-windows-nodejs-and-npm>

### Install Artillery via npm

`PS C:\Windows\system32> npm install -g artillery@latest`

## Getting started

By default, PowerShell sets an execution policy on Windows Desktop clients that prevents the execution of scripts. If you use Windows PowerShell, you may see the following error message when attempting to run Artillery:

`artillery: File C:\Users\Artillery\AppData\Roaming\npm\artillery.ps1
cannot be loaded because running scripts is disabled on this system.`

To allow your Windows system to use Artillery, you'll need to change the PowerShell execution policy to RemoteSigned. Open PowerShell as an administrator and use the Set-ExecutionPolicy to change the execution policy to RemoteSigned:

`PS C:\Windows\system32> Set-ExecutionPolicy RemoteSigned
Execution Policy Change
The execution policy helps protect you from scripts that you do not trust. Changing the execution policy might expose
you to the security risks described in the about_Execution_Policies help topic at
https:/go.microsoft.com/fwlink/?LinkID=135170. Do you want to change the execution policy?
[Y] Yes  [A] Yes to All  [N] No  [L] No to All  [S] Suspend  [?] Help (default is "N"): Y`

<https://www.artillery.io/docs/guides/getting-started/installing-artillery>

### Run the app from cmd

`java -jar -Dspring.profiles.active=dev target/practica_1_pruebas_ordinaria-0.0.1-SNAPSHOT.jar` 

### Run Artillery from PS

 `artillery run -o fail-report.json load-test.yml`
