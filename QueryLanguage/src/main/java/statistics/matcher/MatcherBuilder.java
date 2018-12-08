/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author ColdFish
 */
public class MatcherBuilder {

    private Matcher matcher;

    public MatcherBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher palautettava = this.matcher;
        this.matcher = new All();
        return palautettava;
    }

    public MatcherBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, p -> p.getTeam().toLowerCase().equals(team.toLowerCase()));
        return this;
    }

    public MatcherBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(this.matcher, new Or(matchers));
        return this;
    }

    public MatcherBuilder hasAtLeast(int value, String fieldName) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, fieldName));
        return this;
    }

    public MatcherBuilder hasFewerThan(int value, String fieldName) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, fieldName));
        return this;
    }

}
