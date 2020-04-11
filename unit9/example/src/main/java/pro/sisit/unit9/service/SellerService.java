package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.BookPurchasedRepository;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.BookPurchased;
import pro.sisit.unit9.entity.Buyer;

import java.math.BigDecimal;
import java.util.List;

@Service

public class SellerService {

    @Autowired
    private BookPurchasedRepository bookPurchasedRepository;

    public void selleBook(Buyer buyer, Book book, BigDecimal cost){
        BookPurchased bookPurchased = new BookPurchased();
        bookPurchased.setBook(book);
        bookPurchased.setBuyer(buyer);
        bookPurchased.setCost(cost);
       bookPurchasedRepository.save(bookPurchased);
    }

    public BigDecimal calculatePriceBook(Book book){
        return calculatePrice(bookPurchasedRepository.findByBook(book));
    }

    public BigDecimal calculatePriceBuyer(Buyer buyer){
        return calculatePrice(bookPurchasedRepository.findByBuyer(buyer));
    }

    private BigDecimal calculatePrice(List<BookPurchased> list){
        return list.stream()
                .map(BookPurchased::getCost)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

    }

}
