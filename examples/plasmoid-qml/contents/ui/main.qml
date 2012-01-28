import QtQuick 1.1

import org.kde.plasma.components 0.1 as PlasmaComponents

import "../qmcljs.js" as CLJS

PlasmaComponents.Label {
     text: CLJS.minimal.hello()
}
