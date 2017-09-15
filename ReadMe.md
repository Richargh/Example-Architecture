# Example-Architecture

[![Build Status](https://travis-ci.org/Richargh/Example-ArchitectureValidation.svg?branch=master)](https://travis-ci.org/Richargh/Example-ArchitectureValidation)

An example for how to generate and validate achitecture with structurizr and jdepend.

## Run

`mvn test`
`mvn exec:java`
`mvn install` then `java -jar target/snslyxe-1.0-SNAPSHOT-jar-with-dependencies.jar`

On windows you need to install [Graphviz](http://www.graphviz.org/Download_windows.php) and set the environment variable GRAPHVIZ_DOT to `c:\Program Files\Graphviz*\bin\dot.exe` or `/usr/local/bin/dot`. Make sure to point directly to the dot executable. Then test the installation via `java -jar plantuml.jar -testdot`. Plantuml is downloaded to `~\.m2\repository\net\sourceforge\plantuml\plantuml`.

## Troubleshoot

SourceCodeComponentFinderStrategy results in a "NoClassDefFoundError: com/sun/tools/javadoc/Main". Seems to be a common problem and is also found for different tool [umlgraph](https://www.spinellis.gr/umlgraph/doc/faq.html).
> [From Stackoverflow](https://askubuntu.com/questions/65035/sun-java-6-incorrect-classpath-java-home-problems-in-finding-tools-jar): Well, it's a hack, but we ended up copying the tools.jar file into the jre/lib/ext directory

## Visual Studio Code

* Install [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java)

### Shortcuts

Check out all the cool [Shortcuts](https://code.visualstudio.com/docs/getstarted/keybindings#_keyboard-shortcuts-reference). Here's a sample.

#### Basic Editing
Ctrl+I 	Select current line
Ctrl+Shift+[ 	Fold (collapse) region
Ctrl+/ 	Toggle Line Comment

#### Rich Languages Editing
Ctrl+Space 	Trigger Suggest
Ctrl+Shift+Space 	Trigger Parameter Hints
Shift+Alt+F 	Format Document
F12 	Go to Definition
Alt+F12 	Peek Definition
Shift+F12 	Show References

#### Navigation
Ctrl+T 	Show All Symbols
Ctrl+G 	Go to Line...
Ctrl+Shift+M 	Show Problems
Ctrl+Shift+P 	Show All Commands 

Ctrl+\ 	Split Editor

#### Display
F11 	Toggle Full Screen
Ctrl+K Z 	Toggle Zen Mode
Escape Escape 	Leave Zen Mode
Ctrl+Numpad0 	Reset Zoom
Ctrl+B 	Toggle Sidebar Visibility
Ctrl+Q 	Quick Open View

#### Debug
F5 	Start
F10 	Step Over
Shift+F11 	Step Out
Shift+F5 	Stop

#### Tasks
Ctrl+Shift+B 	Run Build Task