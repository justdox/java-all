package xlab.java.advanced.datastructure.tree;

import org.junit.jupiter.api.*;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinaryTreeTest {
  final String[][] testCases = new String[][]{
    {"a", "a", "a", "a"},
    {"a{b}", "ab", "ba", "ba"},
    {"a{b{d}}", "abd", "dba", "dba"},
    {"a{b{d,e}}", "abde", "dbea", "deba"},
    {"a{,c}", "ac", "ac", "ca"},
    {"a{,c{e}}", "ace", "aec", "eca"},
    {"a{,c{e,f}}", "acef", "aecf", "efca"},
    {"a{b,c}", "abc", "bac", "bca"},
    {"a{b,c{e}}", "abce", "baec", "beca"},
    {"a{b{d},c}", "abdc", "dbac", "dbca"},
    {"a{b{d},c{e}}", "abdce", "dbaec", "dbeca"},
    {"a{b{d,e},c{f}}", "abdecf", "dbeafc", "debfca"},
    {"a{b{d,e},c{f,g}}", "abdecfg", "dbeafcg", "debfgca"},
  };

  @Test
  @Order(1)
  void create() {
    for (String[] testCase : testCases) {
      final String input = testCase[0];
      final BinaryTree<String> tree = BinaryTree.create(input, String::valueOf);
      assertNotNull(tree);
      final String actual = tree.toString();
      assertEquals(input, actual);
    }
  }

  @Test
  @Order(2)
  void traversal() {
    for (final String[] testCase : testCases) {
      final String input = testCase[0];
      final BinaryTree<String> tree = BinaryTree.create(input, String::valueOf);

      System.out.printf("Original input:%n%s%n", input);

      String expected = testCase[1];
      String actual = tree.preOrderTraversal().stream().map(String::valueOf)
        .collect(Collectors.joining(""));
      System.out.printf("Pre-order traversal:%n%s%n", actual);
      assertEquals(expected, actual);

      expected = testCase[2];
      actual = tree.intermediateOrderTraversal().stream().map(String::valueOf)
        .collect(Collectors.joining(""));
      System.out.printf("Intermediate-order traversal:%n%s%n", actual);
      assertEquals(expected, actual);

      expected = testCase[3];
      actual = tree.postOrderTraversal().stream().map(String::valueOf)
        .collect(Collectors.joining(""));
      System.out.printf("Post-order traversal:%n%s%n%n", actual);
      assertEquals(expected, actual);
    }
  }
}
