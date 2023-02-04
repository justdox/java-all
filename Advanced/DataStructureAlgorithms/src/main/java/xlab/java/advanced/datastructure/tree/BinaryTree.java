package xlab.java.advanced.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author CodeKing
 */
public class BinaryTree<T> {
  protected T data;

  protected BinaryTree<T> left;

  protected BinaryTree<T> right;

  public BinaryTree(final T data) {
    this.data = data;
  }

  private static String findSubTree(final String tree, final String sub) {
    if (tree.length() == 1) {
      return tree;
    }

    // {b}
    // {b{d}}
    // {b{d,e}}

    // {,c}
    // {,c{e}}
    // {,c{e,f}}

    // {b,c}
    // {b,c{e}}
    // {b{d},c}

    // {b{d},c{e}}
    // {b{d,e},c{f}}
    // {b{d,e},c{f,g}}
    String subTree = tree.substring(1);
    if (subTree.contains(",")) {
      if (subTree.startsWith("{,")) {
        return "left".equals(sub) ? null : subTree.substring(2,
          subTree.length() - 1);
      }

      subTree = subTree.substring(1, subTree.length() - 1);
      if (subTree.charAt(1) == ',') {
        return "left".equals(sub) ? subTree.substring(0, 1) : subTree.substring(2);
      }

      if (subTree.charAt(subTree.length() - 2) == ',') {
        return "left".equals(sub) ? subTree.substring(0, subTree.length() - 2) :
          subTree.substring(subTree.length() - 1);
      }

      int open = 0;
      int close = 0;
      for (int i = 0; i < subTree.length(); i++) {
        final char c = subTree.charAt(i);
        if (c == '{') {
          open++;
        } else if (c == '}') {
          close++;
          if (close == open) {
            if (i + 1 == subTree.length()) {
              return "left".equals(sub) ? subTree : null;
            }

            return "left".equals(sub) ? subTree.substring(0, i + 1) :
              subTree.substring(i + 2);
          }
        }
      }
    }

    return "left".equals(sub) ? subTree.substring(1, subTree.length() - 1) : null;
  }

  public static <T> BinaryTree<T> create(final String tree,
                                         final Function<Character, T> convertor) {
    if (tree == null || "".equals(tree.trim())) {
      return null;
    }

    final BinaryTree<T> root = new BinaryTree<>(convertor.apply(tree.charAt(0)));
    if (tree.length() == 1) {
      return root;
    }

    final String left = findSubTree(tree, "left");
    final String right = findSubTree(tree, "right");
    root.left = create(left, convertor);
    root.right = create(right, convertor);

    return root;
  }

  @Override
  public String toString() {
    final List<String> values = new ArrayList<>();
    values.add(String.valueOf(data));

    if (left != null || right != null) {
      values.add("{");
      if (right == null) {
        values.add(left.toString());
      } else if (left == null) {
        values.add(",");
        values.add(right.toString());
      } else {
        values.add(left.toString());
        values.add(",");
        values.add(right.toString());
      }
      values.add("}");
    }

    return String.join("", values);
  }

  public List<T> preOrderTraversal() {
    final List<T> values = new ArrayList<>();

    values.add(data);

    if (left != null) {
      values.addAll(left.preOrderTraversal());
    }

    if (right != null) {
      values.addAll(right.preOrderTraversal());
    }

    return values;
  }

  public List<T> intermediateOrderTraversal() {
    final ArrayList<T> values = new ArrayList<>();

    if (left != null) {
      values.addAll(left.intermediateOrderTraversal());
    }

    values.add(data);

    if (right != null) {
      values.addAll(right.intermediateOrderTraversal());
    }

    return values;
  }

  public List<T> postOrderTraversal() {
    final ArrayList<T> values = new ArrayList<>();

    if (left != null) {
      values.addAll(left.postOrderTraversal());
    }

    if (right != null) {
      values.addAll(right.postOrderTraversal());
    }

    values.add(data);

    return values;
  }
}
