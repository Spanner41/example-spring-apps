package design.cardia.exampleimageserver.svg

import design.cardia.ktxml.model.Element

class Svg: Element("svg") {
    init {
        "xmlns" to "http://www.w3.org/2000/svg"
    }
}

class Rect: Element("rect") {
}