package org.example.borrow.repos;

import org.example.borrow.models.Borrow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends MongoRepository<Borrow, String> {
}