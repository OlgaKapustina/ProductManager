package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(11, "Братья Карамазовы", 1500, "Достоевский");
    private Smartphone phone1 = new Smartphone(21, "Фруктофон", 20000, "Смартфонодел");

    @BeforeEach
    public void addProducts() {
        repository.save(book1);
        repository.save(phone1);
    }

    @Test
    public void shouldSaveOneBook() {
        ProductRepository repository = new ProductRepository();

        repository.save(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {
        ProductRepository repository = new ProductRepository();

        repository.save(phone1);

        Product[] expected = new Product[]{phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllSavedProducts() {
        Product[] expected = {book1, phone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemovedById() {
        repository.removeById(21);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}