package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new Soft17Strategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}