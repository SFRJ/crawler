# crawler
To build the project:

mvn clean install


To package the project:
mvn package

To run the project once packaged(note you need to pass a parameter)
cd target
java -jar crawler-1.0-SNAPSHOT-jar-with-dependencies.jar http://www.self-build.co.uk/

Minimum requirements
This program require JVM 1.8 to be installed

Comments
This simple web crawler will given a url go and get all the internal links in that url and present them in the terminal
Also it will gather all the image links and will print them in the terminal

Tradeoffs
This tool does not use any specific framework for generating a site map in the form of a graphic UI or XML document. 
It was quick and easy to test and implement. Perhaps the con that I see is that the value is just printed in the terminal and not persisted in any way, not even a text file.

This tool could easily be extended to support any kind of persistance and also output formant

I did aim for modularity and OOP. As you will observe my classes and methods are relatively small, well written, named and tested.
I was unsure what kind of format to use for the output, either xml,json or maybe some kind of image but the quickest was to use the terminal. Maybe a future improvement could be to add identation in the links that are outputed so it gives more the sensation of a sitemap(currently, it looks like breadcrumbs).

