package de.olgadem.tradingapplication.repository;

import de.olgadem.tradingapplication.model.Strategy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategyRepository extends MongoRepository<Strategy, Integer> {
  public long count();
}
