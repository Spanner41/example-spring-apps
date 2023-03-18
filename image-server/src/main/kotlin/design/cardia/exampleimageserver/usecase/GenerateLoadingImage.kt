package design.cardia.exampleimageserver.usecase

import design.cardia.exampleimageserver.svg.rect
import design.cardia.exampleimageserver.svg.svg
import design.cardia.ktxml.builder.document
import design.cardia.ktxml.model.XmlEncoding
import design.cardia.ktxml.model.XmlVersion
import design.cardia.ktxml.printer.XmlFormat
import design.cardia.ktxml.printer.XmlPrinter
import org.springframework.stereotype.Service

@Service
class GenerateLoadingImage(
    private val xmlFormat: XmlFormat,
    private val xmlPrinter: XmlPrinter
) {
    operator fun invoke(percent: Int, color: String = "green"): String {
        val document = document(XmlVersion.V1_0, XmlEncoding.UTF_8) {
            svg {
                "width" to WIDTH
                "height" to HEIGHT
                "style" to "border:1px solid black"

                rect {
                    "width" to percent
                    "height" to HEIGHT
                    "style" to "fill:$color"
                }
            }
        }

        return xmlPrinter.print(document, xmlFormat)
    }

    companion object {
        private const val WIDTH = 100
        private const val HEIGHT = 8
    }
}