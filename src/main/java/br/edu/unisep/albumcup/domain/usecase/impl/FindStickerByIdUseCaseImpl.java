package br.edu.unisep.albumcup.domain.usecase.impl;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.usecase.FindStickerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindStickerByIdUseCaseImpl implements FindStickerByIdUseCase {

    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;

    @Override
    public Optional<Sticker> execute(Integer id) {
        var result = repository.findById(id);
        return stickerBuilder.build(result);
    }
}
