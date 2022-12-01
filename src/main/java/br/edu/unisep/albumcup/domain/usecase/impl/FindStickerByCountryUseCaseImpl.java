package br.edu.unisep.albumcup.domain.usecase.impl;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.StickerDto;
import br.edu.unisep.albumcup.domain.usecase.FindStickerByCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class FindStickerByCountryUseCaseImpl implements FindStickerByCountryUseCase {

    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;

    @Override
    public List<StickerDto> execute(String country) {

        Sort.Order order = Sort.Order.by(country);

        Example<Sticker> example = Example.of(new Sticker());

        var result = repository.findBy(example,
                q -> q.sortBy(Sort.by(order))).stream().toList();

        return stickerBuilder.build(result);
    }
}
