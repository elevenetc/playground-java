package su.levenetc.playground.java.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {

    @Test
    public void test01() {
        Trie trie = new Trie();
        trie.add("a");
        assertThat(trie.contains("a")).isTrue();
        assertThat(trie.startsWith("a")).isTrue();
        assertThat(trie.contains("z")).isFalse();
        trie.add("abc");
        assertThat(trie.startsWith("ab")).isTrue();
        assertThat(trie.startsWith("abc")).isTrue();
        assertThat(trie.contains("abc")).isTrue();
        assertThat(trie.contains("abz")).isFalse();
        assertThat(trie.contains("abcx")).isFalse();
    }

    @Test
    public void test02() {
        Trie trie = new Trie();
        trie.add("apple");
        assertThat(trie.contains("apple")).isTrue();
        assertThat(trie.contains("app")).isFalse();
        assertThat(trie.startsWith("app")).isTrue();
        trie.add("app");
        assertThat(trie.contains("app")).isTrue();
    }

}