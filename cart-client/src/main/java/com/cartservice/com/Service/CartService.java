package com.cartservice.com.Service;

import com.cartservice.com.Dto.BookDto;
import com.cartservice.com.FeignClient.ProductFeignClient;
import com.cartservice.com.Model.Cart;
import com.cartservice.com.Repository.CartRepository;
import com.cartservice.com.util.ProductDoesNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductFeignClient productFeignClient;

    public boolean IsCartExists(Long userId) {
        return cartRepository.existsById(userId);
    }
    public ResponseEntity createCart(Long userId) {
        if (IsCartExists(userId)){
            Cart cart = new Cart();
            cart.setId(userId);
            cart.setUserId(userId);
            cart.setBooks_set(new HashMap<>());
        }
        return getAllItems(userId);
    }

    public ResponseEntity getAllItems(Long userId) {
        Cart cart = cartRepository.findAllByUserId(userId);
        List<BookDto> bookDtoList = new ArrayList<>();
        HashMap<Long , Integer> bookList = cart.getBooks_set();
        for (Map.Entry<Long, Integer> entry : bookList.entrySet()) {
            Long book_id = entry.getKey();
            int quantity = entry.getValue();
            BookDto bookDto = productFeignClient.getBookDetails(book_id);
            bookDto.setQuantity(quantity);
            bookDtoList.add(bookDto);
        }
        return ResponseEntity.ok(bookDtoList);
    }

    public ResponseEntity addItem(Long userId , Long book_id) {
        BookDto bookDto = productFeignClient.getBookDetails(book_id);
        if(bookDto == null) throw new ProductDoesNotExists("Book Does Not Exist");
        Cart cart = cartRepository.findAllByUserId(userId);
        return ResponseEntity.ok(cart.addItem(book_id));
    }

    public ResponseEntity removeItem(Long userId , Long bookId) {
        Cart cart = cartRepository.findAllByUserId(userId);
        return ResponseEntity.ok(cart.removeItem(bookId));
    }
}
