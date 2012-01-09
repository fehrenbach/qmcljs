import QtQuick 1.1
import "qmcljs.js" as CLJS

Text {
  text: CLJS.minimal.hello()
}
