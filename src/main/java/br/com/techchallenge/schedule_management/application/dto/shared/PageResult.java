package br.com.techchallenge.schedule_management.application.dto.shared;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PageResult<T> {

    private final List<T> items;
    private final Integer size;
    private final Integer page;
    private final Long totalItems;
    private final Long totalPages;

    public PageResult(
            List<T> items,
            Integer page,
            Integer size,
            Long totalItems
    ) {
        this.isSizeValid(size);
        this.isPageValid(page);
        this.isTotalItemsValid(totalItems);

        this.items = new ArrayList<>(items);
        this.size = size;
        this.page = page;
        this.totalItems = totalItems;
        this.totalPages = (long) Math.ceil((double) totalItems / (double) size);
    }

    private void isSizeValid (Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("O tamanho da página deve ser maior que 0.");
        }
    }

    private void isPageValid (Integer page) {
        if (page < 0) {
            throw new IllegalArgumentException("A página atual deve ser maior ou igual a 0.");
        }
    }

    private void isTotalItemsValid (Long totalItems) {
        if (totalItems < 0) {
            throw new IllegalArgumentException("A quantidade total de itens deve ser maior ou igual a 0.");
        }
    }

}

