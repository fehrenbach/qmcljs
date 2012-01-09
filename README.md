QMCLJS
======

Use [ClojureScript](https://github.com/clojure/clojurescript) instead of
[QML](https://developer.qt.nokia.com/doc/qt-4.8/qtquick.html#qml-features) for
[QtQuick](https://qt.nokia.com/qtquick/) applications.

For now, this repository contains only a minimal working example of ClojureScript code in a QML application.

Minimal example
---------------

### Prerequisites

* ClojureScript compiler `cljsc`

  Follow the first few steps of the
  [ClojureScript quick start guide](https://github.com/clojure/clojurescript/wiki/Quick-Start) to get a working `cljsc`.
 
* `qmlviewer` comes with Qt (on archlinux)

### Files

Create a ClojureScript file called `minimal.cljs` with the following content:

    (ns minimal)
    
    (defn ^:export hello []
      (str "Hello" " " "world!"))

Save the following QML code in a file named `minimal.qml`:

    import QtQuick 1.1
    import "qmcljs.js" as CLJS
    
    Text {
      text: CLJS.minimal.hello()
    }

QML does not allow the modification of the JavaScript root object, but imported
JavaScript may do as it wishes, so we create a file `qmcljs.js` that loads the
actual (compiled) code:

    .pragma library
    Qt.include("minimal.js")

You may also find these files in `examples/minimal/` in the github repository.

### Compile & Run

Compile using `:simple` optimisations, `:advanced` currently does not work. If
you know why, please do tell.

    $ cljsc minimal.cljs '{:optimizations :simple :pretty-print true}' > minimal.js
    
Run the application in the standalone `qmlviewer`:

    $ qmlviewer minimal.qml

Limitations
-----------

* Development compilation (no optimisation, multiple code files + dependencies
  file) is untested.
  
  Everything else is probably untested, too.

* No advanced compilation mode for now

  This might actually be easy to fix. If you are familiar with ClojureScript
  please have a look.

* Avoid non-alphanumeric characters (including `\-`) for `^:export`ed functions
  and namespaces, because QML is not aware of ClojureScript mangling
  
  This is probably rather impossible to fix without delving deep into QML
  internals. Since this affects only `^:export`ed functions called from `.qml`
  files, not general ClojureScript functions, it is low priority for now.

Immediate Roadmap
-----------------

* Port some [QML examples](http://doc.qt.nokia.com/4.8-snapshot/qdeclarativeexamples.html) to ClojureScript.
* Provide a library for commonly used functions specific to QML interop
  (seqs as ListModel comes to mind).
* Find out what's wrong with advanced compilation
* Test what parts of the [closure library](https://code.google.com/closure/library/) work
* ...

Contributing
------------

Contributions welcome!

Send pull requests, open issues, questions, feedback ..what are you waiting for?

License
-------

Nothing here right now, so no license.

Porting of examples is subject to their licenses.

The soon™ to come library is probably going to be BSD.
