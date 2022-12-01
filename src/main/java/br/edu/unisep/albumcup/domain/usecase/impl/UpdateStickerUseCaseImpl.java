package br.edu.unisep.albumcup.domain.usecase.impl;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.usecase.UpdateStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Service
@RequiredArgsConstructor
public class UpdateStickerUseCaseImpl implements UpdateStickerUseCase {

    private final StickerRepository repository;

    public void execute(Integer id, Sticker sticker) {
        if (repository.findById(id).isEmpty()) {
            Sticker dto = repository.findById(id).get();
            dto.setPlayer(sticker.getPlayer());
            dto.setCountry(sticker.getCountry());
            dto.setWeight(sticker.getWeight());
            dto.setHeight(sticker.getHeight());
            dto.setBirthday(sticker.getBirthday());
            dto.setLegendary(sticker.isLegendary());
            repository.save(dto);
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }
}
