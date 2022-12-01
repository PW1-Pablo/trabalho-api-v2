package br.edu.unisep.albumcup.domain.usecase;

import br.edu.unisep.albumcup.domain.dto.StickerDto;

import java.util.List;

public interface FindStickerByCountryUseCase {
    List<StickerDto> execute(String country);
}
