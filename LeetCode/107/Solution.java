/*
 * Author: Minho Kim (ISKU)
 * Date: November 7, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

class Solution {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null)
            return answer;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            answer.add(0, level);
            
            int count = q.size();
            while (count-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        
        return answer;
    }
}
