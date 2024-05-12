package com.example.newsreaderdemo.Repository;

import com.example.newsreaderdemo.Entity.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedItemRepository extends JpaRepository<FeedItem,Integer> {
}
