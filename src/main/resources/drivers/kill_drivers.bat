@echo off
rem   just kills stray local chromedriver.exe, geckodriver.exe instances.
rem   useful if you are trying to clean your project, and your ide is complaining. running Project->Clean in Eclipse
 

taskkill /im chromedriver.exe /f
taskkill /im geckodriver.exe /f
taskkill /im IEDriverServer.exe /f
