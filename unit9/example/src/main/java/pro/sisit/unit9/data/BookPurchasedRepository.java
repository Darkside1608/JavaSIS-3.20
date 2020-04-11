package pro.sisit.unit9.data;

import org.springframework.data.repository.CrudRepository;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.BookPurchased;
import pro.sisit.unit9.entity.Buyer;

import java.util.List;

public interface BookPurchasedRepository extends CrudRepository<BookPurchased, Long> {
    List<BookPurchased> findByBookAndBuyer(Book book, Buyer buyer);
    List<BookPurchased> findByBook(Book book);
    List<BookPurchased> findByBuyer(Buyer buyer);

}
