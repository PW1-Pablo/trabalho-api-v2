package br.edu.unisep.albumcup.domain.usecase;

import br.edu.unisep.albumcup.data.entity.Sticker;

import java.util.Optional;

public interface FindStickerByIdUseCase {

    Optional<Sticker> execute(Integer id);
}
