package br.edu.unisep.albumcup.domain.usecase;

import br.edu.unisep.albumcup.data.entity.Sticker;

public interface UpdateStickerUseCase {

    void execute(Integer id, Sticker sticker);
}
