ClojureScript Plasma Applets
============================
Yes, that's right.
You can write Plasma applets, also known as Plasmoids, in ClojureScript.

Compile & Run
-------------
Go to the plasmoid directory:

    $ cd qmcljs/examples/plasmoid-qml

Compile the `.cljs` file and put the output inside the `contents` folder, as
the top level directory is not included in the plasmoid, I think.

    $ cljsc . '{:optimizations :simple :pretty-print true}' > contents/minimal.js

Preview the plasmoid using `plasmoidviewer`:

    $ plasmoidviewer .

Install (temporarily, if you want to. The proper way is using CMake, which I
have not tried yet. See Plasma documentation for more info):

    $ cd ..
    $ plasmapkg --install plasmoid-qml

References
----------
Read this about QML plasmoids:
[QML Plasmoid Tutorial](http://techbase.kde.org/Development/Tutorials/Plasma/QML/GettingStarted)

The API doc for org.kde.plasma.components is here:
[Plasma Components API](http://api.kde.org/4.x-api/plasma-qml-apidocs/)
