package design.cardia.exampleimageserver.svg

import design.cardia.ktxml.model.Element

fun svg(lambda: Svg.() -> Unit) = Svg().apply(lambda)

fun Element.rect(lambda: Rect.() -> Unit) = Rect().apply(lambda).also(::add)