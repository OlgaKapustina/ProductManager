package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book2 = new Book(12, "Евгений Онегин", 1300, "Пушкин");
    private Smartphone phone2 = new Smartphone(22, "Ягодофон", 45000, "Смартфонодел");
    private Smartphone phone3 = new Smartphone(23, "Ягодофон", 25000, "Смартфоноподдел");

    @Test
    public void shouldAddedProductToRepository() {

        manager.add(book2);
        manager.add(phone2);

        Product[] expected = new Product[]{book2, phone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book2);
        manager.add(phone2);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Ягодофон");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void productDoesNotMatchSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book2);
        manager.add(phone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Фруктофон");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleProductMatchSameSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone2, phone3};
        Product[] actual = manager.searchBy("Ягодофон");
        assertArrayEquals(expected, actual);
    }
}