package br.edu.unisep.albumcup.domain.builder;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickerDto;


import java.util.List;
import java.util.Optional;

public interface StickerBuilder {
    Sticker build(CreateStickerDto dto);

    StickerDto build(Sticker sticker);

    List<StickerDto> build(List<Sticker> sticker);

    Optional<Sticker> build(Optional<Sticker> sticker);

}
