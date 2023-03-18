package design.cardia.exampleimageserver.controller

import design.cardia.exampleimageserver.usecase.GenerateLoadingImage
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class LoadingImageController(
    private val generateLoadingImage: GenerateLoadingImage
) {
    @GetMapping(value = ["/loading/{percent}.svg"], produces = ["image/svg+xml"])
    fun getLoadingImage(@PathVariable @Min(0) @Max(100) percent: Int): ResponseEntity<String> {
        val image = generateLoadingImage(percent)
        return ResponseEntity.ok(image)
    }
}