package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickerDto;
import br.edu.unisep.albumcup.domain.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sticker")
public class StickerController {

    private final CreateStickerUseCase createStickerUseCase;
    private final FindAllStickersUseCase findAllStickersUseCase;
    private final DeleteStickerUseCase deleteStickerUseCase;
    private final FindStickerByIdUseCase findStickerByIdUseCase;
    private final UpdateStickerUseCase updateStickerUseCase;
    private final FindStickerByCountryUseCase findStickerByCountryUseCase;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateStickerDto stickerData) {
        createStickerUseCase.execute(stickerData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<StickerDto>> findAll() {
        var result = findAllStickersUseCase.execute();

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<StickerDto>> findByCountry(@PathVariable("country") String country) {
        var result = findStickerByCountryUseCase.execute(country);

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Sticker>> findById(@PathVariable("id") Integer id) {
        var result = findStickerByIdUseCase.execute(id);

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        deleteStickerUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Sticker sticker) {
        updateStickerUseCase.execute(id, sticker);
    }

}
