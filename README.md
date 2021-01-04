# MergePdf
Simple java tool to merge pdfs to one single file with keeping an pages order.

## Table of contents
* [Technologies](#technologies)
* [Usage](#usage)
	
## Technologies
Requirements
* Java version: 1.8 or above
	
## Usage
PDF files should be named in convention "1.pdf", "2.pdf" etc.  
Download a JAR file from [here](https://github.com/baca90/MergePdf/blob/master/mergePdf-1.0.jar) and from directory where it is, run a command:

```
java -jar mergePdf-1.0.jar InputPath OutputPath+FileName
```

example:

```
java -jar mergePdf-1.0.jar C:\PdfsArePlacedHere C:\Destination\Merged.pdf
```
