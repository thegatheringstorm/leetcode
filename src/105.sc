class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class Solution {
  def buildTreeH(preorder: List[Int], inorder: List[Int]): TreeNode = {
    if (preorder == Nil) null
    else {
      val root :: preorder_left_right = preorder
      val (inorder_left, inorder_root_right) = inorder.span(_ != root)
      val inorder_right = if (inorder_root_right==Nil) Nil else inorder_root_right.tail
      val (preorder_left, preorder_right) = preorder_left_right.span(!inorder_right.contains(_))
      val t = new TreeNode(root)
      t.left = buildTreeH(preorder_left, inorder_left)
      t.right = buildTreeH(preorder_right, inorder_right)
      t
    }
  }

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = buildTreeH(preorder.toList, inorder.toList)
}

val a = new Solution
a.buildTree(Array(1, 2), Array(2, 1))