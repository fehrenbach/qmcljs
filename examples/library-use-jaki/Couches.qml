import QtQuick 1.1
import "qmcljs.js" as CLJS

Rectangle {
    height: 400
    width: 300

    ListView {
        anchors.fill: parent

        model: ListModel {
            id: lm
        }

        delegate: Text {
            text: name
        }
    }

    Component.onCompleted: {
        CLJS.foo.insert_couches(lm)
    }
}
